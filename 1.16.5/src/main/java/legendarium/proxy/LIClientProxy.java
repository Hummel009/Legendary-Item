package legendarium.proxy;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.*;
import java.util.function.Predicate;

public class LIClientProxy extends LIServerProxy {
	private static final Map<ResourceLocation, ResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onModelBake(ModelBakeEvent event) {
		for (Map.Entry<ResourceLocation, ResourceLocation> compliance : COMPLIANCES.entrySet()) {
			ModelResourceLocation oldLocation = new ModelResourceLocation(compliance.getKey(), "inventory");
			IBakedModel oldModel = event.getModelRegistry().get(oldLocation);
			if (oldModel != null) {
				ResourceLocation newLocation = compliance.getValue();
				IBakedModel newModel = event.getModelRegistry().get(newLocation);
				if (newModel != null) {
					event.getModelRegistry().put(oldLocation, new LargeItemModel(oldModel, newModel));
				}
			}
		}
	}

	@SubscribeEvent
	public void onModelRegistry(ModelRegistryEvent event) {
		Collection<ResourceLocation> resourceLocations = Minecraft.getInstance().getResourceManager().listResources("models", new Predicate<String>() {
			@Override
			public boolean test(String loc) {
				return loc.endsWith("_large.json");
			}
		});
		for (ResourceLocation resourceLocation : resourceLocations) {
			String path = resourceLocation.getPath().replace("models/item/", "").replace("_large.json", "");
			ResourceLocation oldModel = new ResourceLocation("legendarium", path);
			ResourceLocation newModel = new ResourceLocation("legendarium", "item/" + path + "_large");
			ModelLoader.addSpecialModel(newModel);
			COMPLIANCES.put(oldModel, newModel);
		}
	}

	public static class LargeItemModel implements IBakedModel {
		public final IBakedModel defaultModel;
		public final IBakedModel handheldModel;

		public LargeItemModel(IBakedModel defaultModel, IBakedModel handheldModel) {
			this.defaultModel = defaultModel;
			this.handheldModel = handheldModel;
		}

		@Override
		public ItemOverrideList getOverrides() {
			return handheldModel.getOverrides();
		}

		@Override
		public TextureAtlasSprite getParticleIcon() {
			return defaultModel.getParticleIcon();
		}

		@Override
		public List<BakedQuad> getQuads(BlockState state, Direction cullFace, Random rand) {
			return defaultModel.getQuads(state, cullFace, rand);
		}

		@Override
		public IBakedModel handlePerspective(ItemCameraTransforms.TransformType transformType, MatrixStack mat) {
			IBakedModel modelToUse = defaultModel;
			if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
				modelToUse = handheldModel;
			}
			return ForgeHooksClient.handlePerspective(modelToUse, transformType, mat);
		}

		@Override
		public boolean isCustomRenderer() {
			return defaultModel.isCustomRenderer();
		}

		@Override
		public boolean isGui3d() {
			return defaultModel.isGui3d();
		}

		@Override
		public boolean useAmbientOcclusion() {
			return defaultModel.useAmbientOcclusion();
		}

		@Override
		public boolean usesBlockLight() {
			return defaultModel.usesBlockLight();
		}
	}
}
