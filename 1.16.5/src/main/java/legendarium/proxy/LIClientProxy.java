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
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.*;

public class LIClientProxy extends LICommonProxy {
	public static final Map<ResourceLocation, ResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onModelBake(ModelBakeEvent event) {
		for (Map.Entry<ResourceLocation, ResourceLocation> compliance : COMPLIANCES.entrySet()) {
			ModelResourceLocation smallLocation = new ModelResourceLocation(compliance.getKey(), "inventory");
			IBakedModel smallModel = event.getModelRegistry().get(smallLocation);
			if (smallModel != null) {
				ResourceLocation largeLocation = compliance.getValue();
				IBakedModel largeModel = event.getModelRegistry().get(largeLocation);
				if (largeModel != null) {
					event.getModelRegistry().put(smallLocation, new LargeItemModel(smallModel, largeModel));
				}
			}
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onModelRegistry(ModelRegistryEvent event) {
		Collection<ResourceLocation> resourceLocations = Minecraft.getInstance().getResourceManager().listResources("models", loc -> loc.endsWith("_large.json"));
		for (ResourceLocation resourceLocation : resourceLocations) {
			String itemName = resourceLocation.getPath().replace("models/item/", "").replace("_large.json", "");
			ResourceLocation smallModel = new ResourceLocation("legendarium", itemName);
			ResourceLocation largeModel = new ResourceLocation("legendarium", "item/" + itemName + "_large");
			ModelLoader.addSpecialModel(largeModel);
			COMPLIANCES.put(smallModel, largeModel);
		}
	}

	public static class LargeItemModel implements IBakedModel {
		public final IBakedModel smallModel;
		public final IBakedModel largeModel;

		public LargeItemModel(IBakedModel smallModel, IBakedModel largeModel) {
			this.smallModel = smallModel;
			this.largeModel = largeModel;
		}

		@Override
		public ItemOverrideList getOverrides() {
			return smallModel.getOverrides();
		}

		@Override
		public TextureAtlasSprite getParticleIcon() {
			return smallModel.getParticleIcon();
		}

		@Override
		public List<BakedQuad> getQuads(BlockState blockState, Direction direction, Random random) {
			return smallModel.getQuads(blockState, direction, random);
		}

		@Override
		public IBakedModel handlePerspective(ItemCameraTransforms.TransformType transformType, MatrixStack matrixStack) {
			IBakedModel bakedModel = smallModel;
			if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
				bakedModel = largeModel;
			}
			return bakedModel.handlePerspective(transformType, matrixStack);
		}

		@Override
		public boolean isCustomRenderer() {
			return smallModel.isCustomRenderer();
		}

		@Override
		public boolean isGui3d() {
			return smallModel.isGui3d();
		}

		@Override
		public boolean useAmbientOcclusion() {
			return smallModel.useAmbientOcclusion();
		}

		@Override
		public boolean usesBlockLight() {
			return smallModel.usesBlockLight();
		}
	}
}
