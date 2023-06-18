package legendarium.proxy;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LIClientProxy extends LICommonProxy {
	public static final Map<ResourceLocation, ResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onModifyBakingResult(ModelEvent.ModifyBakingResult event) {
		for (Map.Entry<ResourceLocation, ResourceLocation> compliance : COMPLIANCES.entrySet()) {
			var smallLocation = new ModelResourceLocation(compliance.getKey(), "inventory");
			var smallModel = event.getModels().get(smallLocation);
			if (smallModel != null) {
				var largeLocation = compliance.getValue();
				var largeModel = event.getModels().get(largeLocation);
				if (largeModel != null) {
					event.getModels().put(smallLocation, new LargeItemModel(smallModel, largeModel));
				}
			}
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onRegisterAdditional(ModelEvent.RegisterAdditional event) {
		Set<ResourceLocation> resourceLocations = Minecraft.getInstance().getResourceManager().listResources("models", loc -> "legendarium".equals(loc.getNamespace()) && loc.getPath().endsWith("_large.json")).keySet();
		for (ResourceLocation resourceLocation : resourceLocations) {
			var regName = resourceLocation.getPath().replace("models/item/", "").replace("_large.json", "");
			var smallModel = new ResourceLocation("legendarium", regName);
			var largeModel = new ResourceLocation("legendarium", "item/" + regName + "_large");
			COMPLIANCES.put(smallModel, largeModel);
			event.register(largeModel);
		}
	}

	public record LargeItemModel(BakedModel smallModel, BakedModel largeModel) implements BakedModel {
		@Override
		public BakedModel applyTransform(ItemDisplayContext itemDisplayContext, PoseStack poseStack, boolean b) {
			BakedModel bakedModel = smallModel;
			if (itemDisplayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || itemDisplayContext == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND || itemDisplayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || itemDisplayContext == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND) {
				bakedModel = largeModel;
			}
			return bakedModel.applyTransform(itemDisplayContext, poseStack, b);
		}

		@Override
		public List<BakedQuad> getQuads(BlockState blockState, Direction direction, RandomSource randomSource) {
			return smallModel.getQuads(blockState, direction, randomSource);
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