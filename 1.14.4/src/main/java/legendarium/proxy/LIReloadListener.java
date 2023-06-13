package legendarium.proxy;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.SimpleReloadableResourceManager;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.resource.IResourceType;
import net.minecraftforge.resource.ISelectiveResourceReloadListener;
import net.minecraftforge.resource.VanillaResourceType;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;

public class LIReloadListener implements ISelectiveResourceReloadListener {
	public static final LIReloadListener INSTANCE = new LIReloadListener();
	public List<ResourceLocation> specialHandheldItemNames = new ArrayList<>();

	public void detectSpecialHandhelds(IResourceManager resMgr) {
		specialHandheldItemNames.clear();
		for (ResourceLocation itemName : ForgeRegistries.ITEMS.getKeys()) {
			ResourceLocation fullHandheldModelPath = new ResourceLocation(itemName.getNamespace(), String.format("models/item/%s_%s.json", itemName.getPath(), "handheld"));
			if (resMgr.hasResource(fullHandheldModelPath)) {
				specialHandheldItemNames.add(itemName);
				ModelLoader.addSpecialModel(getHandheldModelLocation(itemName));
			}
		}
	}

	public ModelResourceLocation getHandheldModelLocation(ResourceLocation itemName) {
		return new ModelResourceLocation(String.format("%s_%s", itemName, "handheld"), "inventory");
	}

	public void onModelBake(ModelBakeEvent event) {
		Map<ResourceLocation, IBakedModel> modelMap = event.getModelRegistry();
		for (ResourceLocation itemName : specialHandheldItemNames) {
			ModelResourceLocation modelResourceLocation1 = new ModelResourceLocation(itemName, "inventory");
			ModelResourceLocation modelResourceLocation2 = getHandheldModelLocation(itemName);
			IBakedModel defaultModel = modelMap.get(modelResourceLocation1);
			IBakedModel handheldModel = modelMap.get(modelResourceLocation2);
			if (defaultModel == null) {
				throw new IllegalStateException("Could not find default inventory model for " + modelResourceLocation1);
			}
			if (handheldModel == null) {
				throw new IllegalStateException("Could not find handheld model for " + modelResourceLocation2);
			}
			IBakedModel wrapperModel = new HandheldWrapperModel(defaultModel, handheldModel);
			modelMap.put(modelResourceLocation1, wrapperModel);
		}
	}

	@Override
	public void onResourceManagerReload(IResourceManager resMgr, Predicate<IResourceType> predicate) {
		if (predicate.test(VanillaResourceType.MODELS)) {
			detectSpecialHandhelds(resMgr);
		}
	}

	public void setupAndDetectModels(Minecraft mc) {
		SimpleReloadableResourceManager resMgr = (SimpleReloadableResourceManager) mc.getResourceManager();
		resMgr.addReloadListener(this);
		detectSpecialHandhelds(resMgr);
	}

	public static class HandheldWrapperModel implements IBakedModel {
		public final IBakedModel defaultModel;
		public final IBakedModel handheldModel;

		public HandheldWrapperModel(IBakedModel defaultModel, IBakedModel handheldModel) {
			this.defaultModel = defaultModel;
			this.handheldModel = handheldModel;
		}

		@Override
		public ItemOverrideList getOverrides() {
			return handheldModel.getOverrides();
		}

		@Override
		public TextureAtlasSprite getParticleTexture() {
			return defaultModel.getParticleTexture();
		}

		@Override
		public List<BakedQuad> getQuads(BlockState state, Direction cullFace, Random rand) {
			return defaultModel.getQuads(state, cullFace, rand);
		}

		@Override
		public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType transformType) {
			IBakedModel modelToUse = defaultModel;
			if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
				modelToUse = handheldModel;
			}
			return ForgeHooksClient.handlePerspective(modelToUse, transformType);
		}

		@Override
		public boolean isAmbientOcclusion() {
			return defaultModel.isAmbientOcclusion();
		}

		@Override
		public boolean isBuiltInRenderer() {
			return defaultModel.isBuiltInRenderer();
		}

		@Override
		public boolean isGui3d() {
			return defaultModel.isGui3d();
		}
	}
}
