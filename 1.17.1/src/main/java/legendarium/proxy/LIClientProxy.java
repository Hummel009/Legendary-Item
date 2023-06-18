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
import net.minecraft.world.level.block.state.BlockState;
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
			var smallLocation = new ModelResourceLocation(compliance.getKey(), "inventory");
			var smallModel = event.getModelRegistry().get(smallLocation);
			if (smallModel != null) {
				var largeLocation = compliance.getValue();
				var largeModel = event.getModelRegistry().get(largeLocation);
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
			var regName = resourceLocation.getPath().replace("models/item/", "").replace("_large.json", "");
			var smallModel = new ResourceLocation("legendarium", regName);
			var largeModel = new ResourceLocation("legendarium", "item/" + regName + "_large");
			ModelLoader.addSpecialModel(largeModel);
			COMPLIANCES.put(smallModel, largeModel);
		}
	}

	public record LargeItemModel(BakedModel smallModel, BakedModel largeModel) implements BakedModel {
		@Override
		public BakedModel handlePerspective(ItemTransforms.TransformType transformType, PoseStack poseStack) {
			BakedModel bakedModel = smallModel;
			if (transformType == ItemTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
				bakedModel = largeModel;
			}
			return bakedModel.handlePerspective(transformType, poseStack);
		}

		@Override
		public List<BakedQuad> getQuads(BlockState blockState, Direction direction, Random random) {
			return smallModel.getQuads(blockState, direction, random);
		}

		@Override
		public boolean useAmbientOcclusion() {
			return smallModel.useAmbientOcclusion();
		}

		@Override
		public boolean isGui3d() {
			return smallModel.isGui3d();
		}

		@Override
		public boolean usesBlockLight() {
			return smallModel.usesBlockLight();
		}

		@Override
		public boolean isCustomRenderer() {
			return smallModel.isCustomRenderer();
		}

		@Override
		public TextureAtlasSprite getParticleIcon() {
			return smallModel.getParticleIcon();
		}

		@Override
		public ItemOverrides getOverrides() {
			return smallModel.getOverrides();
		}
	}
}
