package legendarium.proxy;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.ForgeModelBakery;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class LIReloadListener implements PreparableReloadListener {
	public static final LIReloadListener INSTANCE = new LIReloadListener();
	public List<ResourceLocation> specialHandheldItemNames = new ArrayList<>();

	public void setupAndDetectModels(Minecraft mc) {
		ReloadableResourceManager resMgr = (ReloadableResourceManager) mc.getResourceManager();
		resMgr.registerReloadListener(this);
		detectSpecialHandhelds(resMgr);
	}

	@Override
	public CompletableFuture<Void> reload(PreparationBarrier p_10638_, ResourceManager resMgr, ProfilerFiller p_10640_, ProfilerFiller p_10641_, Executor p_10642_, Executor p_10643_) {
		detectSpecialHandhelds(resMgr);
		return null;
	}

	public void detectSpecialHandhelds(ResourceManager resMgr) {
		specialHandheldItemNames.clear();
		for (ResourceLocation itemName : ForgeRegistries.ITEMS.getKeys()) {
			ResourceLocation fullHandheldModelPath = new ResourceLocation(itemName.getNamespace(), String.format("models/item/%s_%s.json", itemName.getPath(), "handheld"));
			if (resMgr.hasResource(fullHandheldModelPath)) {
				specialHandheldItemNames.add(itemName);
				ForgeModelBakery.addSpecialModel(getHandheldModelLocation(itemName));
			}
		}
	}

	public ModelResourceLocation getHandheldModelLocation(ResourceLocation itemName) {
		return new ModelResourceLocation(String.format("%s_%s", itemName, "handheld"), "inventory");
	}

	public void onModelBake(ModelBakeEvent event) {
		Map<ResourceLocation, BakedModel> modelMap = event.getModelRegistry();
		for (ResourceLocation itemName : specialHandheldItemNames) {
			ModelResourceLocation modelResourceLocation1 = new ModelResourceLocation(itemName, "inventory");
			ModelResourceLocation modelResourceLocation2 = getHandheldModelLocation(itemName);
			BakedModel defaultModel = modelMap.get(modelResourceLocation1);
			BakedModel handheldModel = modelMap.get(modelResourceLocation2);
			if (defaultModel == null) {
				throw new IllegalStateException("Could not find default inventory model for " + modelResourceLocation1);
			}
			if (handheldModel == null) {
				throw new IllegalStateException("Could not find handheld model for " + modelResourceLocation2);
			}
			BakedModel wrapperModel = new HandheldWrapperModel(defaultModel, handheldModel);
			modelMap.put(modelResourceLocation1, wrapperModel);
		}
	}

	public record HandheldWrapperModel(BakedModel defaultModel, BakedModel handheldModel) implements BakedModel {
		public BakedModel handlePerspective(ItemTransforms.TransformType transformType, PoseStack mat) {
			BakedModel modelToUse = defaultModel;
			if (transformType == ItemTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
				modelToUse = handheldModel;
			}
			return ForgeHooksClient.handlePerspective(modelToUse, transformType, mat);
		}

		@Override
		public List<BakedQuad> getQuads(BlockState state, Direction cullFace, Random rand) {
			return defaultModel.getQuads(state, cullFace, rand);
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
			return defaultModel.getParticleIcon();
		}

		@Override
		public ItemOverrides getOverrides() {
			return handheldModel.getOverrides();
		}
	}
}