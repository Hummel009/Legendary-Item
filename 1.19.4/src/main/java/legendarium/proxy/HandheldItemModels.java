package legendarium.proxy;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.RandomSource;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.model.ForgeItemModelShaper;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class HandheldItemModels implements PreparableReloadListener {
	public static final HandheldItemModels INSTANCE = new HandheldItemModels();
	public static final String HANDHELD_SUFFIX = "handheld";
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
			if (!resMgr.getResourceStack(fullHandheldModelPath).isEmpty()) {
				addSpecialHandheld(itemName, resMgr);
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public void addSpecialHandheld(ResourceLocation itemName, ResourceManager resMgr) {
		Item item = ForgeRegistries.ITEMS.getValue(itemName);
		specialHandheldItemNames.add(itemName);
		ForgeItemModelShaper s = new ForgeItemModelShaper((ModelManager) resMgr);
		s.register(item, getHandheldModelLocation(itemName));
	}

	@OnlyIn(Dist.CLIENT)
	public ModelResourceLocation getHandheldModelLocation(ResourceLocation itemName) {
		return new ModelResourceLocation(new ResourceLocation(String.format("%s_%s", itemName, "handheld")), "inventory");
	}

	@OnlyIn(Dist.CLIENT)
	public void onModelBake(ModelEvent.BakingCompleted event) {
		Map<ResourceLocation, BakedModel> modelMap = event.getModels();
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
		public TextureAtlasSprite getParticleTexture(ModelData extraData) {
			return defaultModel.getParticleIcon(extraData);
		}

		public BakedModel handlePerspective(ItemDisplayContext transformType, PoseStack mat) {
			BakedModel modelToUse = defaultModel;
			if (transformType == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || transformType == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND || transformType == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || transformType == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND) {
				modelToUse = handheldModel;
			}
			return ForgeHooksClient.handleCameraTransforms(mat, modelToUse, transformType, false);
		}

		@Override
		public List<BakedQuad> getQuads(@Nullable BlockState p_235039_, @Nullable Direction p_235040_, RandomSource p_235041_) {
			return defaultModel.getQuads(p_235039_, p_235040_, p_235041_);
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
			return getParticleTexture(ModelData.EMPTY);
		}

		@Override
		public ItemOverrides getOverrides() {
			return handheldModel.getOverrides();
		}
	}
}
