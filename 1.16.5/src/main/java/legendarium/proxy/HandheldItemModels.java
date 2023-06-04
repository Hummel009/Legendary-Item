package legendarium.proxy;

import com.mojang.blaze3d.matrix.MatrixStack;
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
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.resource.IResourceType;
import net.minecraftforge.resource.ISelectiveResourceReloadListener;
import net.minecraftforge.resource.VanillaResourceType;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HandheldItemModels implements ISelectiveResourceReloadListener {
	public static final HandheldItemModels INSTANCE = new HandheldItemModels();
	public static final String HANDHELD_SUFFIX = "handheld";
	public List<ResourceLocation> specialHandheldItemNames = new ArrayList<>();

	public void setupAndDetectModels(Minecraft mc) {
		SimpleReloadableResourceManager resMgr = (SimpleReloadableResourceManager) mc.getResourceManager();
		resMgr.registerReloadListener(this);
		detectSpecialHandhelds(resMgr);
	}

	public void onResourceManagerReload(IResourceManager resMgr, Predicate<IResourceType> predicate) {
		if (predicate.test(VanillaResourceType.MODELS)) {
			detectSpecialHandhelds(resMgr);
		}
	}

	public void detectSpecialHandhelds(IResourceManager resMgr) {
		specialHandheldItemNames.clear();
		for (ResourceLocation itemName : ForgeRegistries.ITEMS.getKeys()) {
			ResourceLocation fullHandheldModelPath = new ResourceLocation(itemName.getNamespace(), String.format("models/item/%s_%s.json", itemName.getPath(), "handheld"));
			System.out.println(fullHandheldModelPath);
			if (resMgr.hasResource(fullHandheldModelPath)) {
				addSpecialHandheld(itemName);
			}
		}
	}

	public void addSpecialHandheld(ResourceLocation itemName) {
		specialHandheldItemNames.add(itemName);
		ModelLoader.addSpecialModel(getHandheldModelLocation(itemName));
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
			HandheldWrapperModel.remapHandheldModelOverrides(modelResourceLocation1, defaultModel, handheldModel);
			IBakedModel wrapperModel = new HandheldWrapperModel(defaultModel, handheldModel);
			modelMap.put(modelResourceLocation1, wrapperModel);
		}
	}

	public static class HandheldWrapperModel implements IBakedModel {
		public final IBakedModel defaultModel;
		public final IBakedModel handheldModel;

		public HandheldWrapperModel(IBakedModel defaultModel, IBakedModel handheldModel) {
			this.defaultModel = defaultModel;
			this.handheldModel = handheldModel;
		}

		public static void remapHandheldModelOverrides(ResourceLocation modelName, IBakedModel defaultModel, IBakedModel handheldModel) {
			try {
				ItemOverrideList overrides = handheldModel.getOverrides();
				Field f_overrideBakedModels = ObfuscationReflectionHelper.findField(ItemOverrideList.class, "field_209582_c");
				List<IBakedModel> overrideModels = (List<IBakedModel>) f_overrideBakedModels.get(overrides);
				List<HandheldWrapperModel> remappedOverrideModels = overrideModels.stream().map(handheldOverride -> new HandheldWrapperModel(defaultModel, handheldOverride)).collect(Collectors.toList());
				f_overrideBakedModels.set(overrides, remappedOverrideModels);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public List<BakedQuad> getQuads(BlockState state, Direction side, Random rand, IModelData extraData) {
			return defaultModel.getQuads(state, side, rand, extraData);
		}

		public TextureAtlasSprite getParticleTexture(IModelData extraData) {
			return defaultModel.getParticleTexture(extraData);
		}

		public IBakedModel handlePerspective(ItemCameraTransforms.TransformType transformType, MatrixStack mat) {
			IBakedModel modelToUse = defaultModel;
			if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
				modelToUse = handheldModel;
			}
			return ForgeHooksClient.handlePerspective(modelToUse, transformType, mat);
		}

		@Override
		public List<BakedQuad> getQuads(BlockState state, Direction cullFace, Random rand) {
			return getQuads(state, cullFace, rand, EmptyModelData.INSTANCE);
		}

		@Override
		public boolean useAmbientOcclusion() {
			return defaultModel.useAmbientOcclusion();
		}

		@Override
		public boolean isGui3d() {
			return defaultModel.isGui3d();
		}

		@Override
		public boolean usesBlockLight() {
			return defaultModel.usesBlockLight();
		}

		@Override
		public boolean isCustomRenderer() {
			return defaultModel.isCustomRenderer();
		}

		@Override
		public TextureAtlasSprite getParticleIcon() {
			return getParticleTexture(EmptyModelData.INSTANCE);
		}

		@Override
		public ItemOverrideList getOverrides() {
			return handheldModel.getOverrides();
		}
	}
}
