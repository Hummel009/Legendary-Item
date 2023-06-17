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
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class LIClientProxy extends LICommonProxy {
	private static final Map<ResourceLocation, ResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onModifyBakingResult(ModelEvent.ModifyBakingResult event) {
		for (Map.Entry<ResourceLocation, ResourceLocation> compliance : COMPLIANCES.entrySet()) {
			var oldLocation = new ModelResourceLocation(compliance.getKey(), "inventory");
			var oldModel = event.getModels().get(oldLocation);
			if (oldModel != null) {
				var newLocation = compliance.getValue();
				var newModel = event.getModels().get(newLocation);
				if (newModel != null) {
					event.getModels().put(oldLocation, new LargeItemModel(oldModel, newModel));
				}
			}
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onRegisterAdditional(ModelEvent.RegisterAdditional event) {
		Set<ResourceLocation> resourceLocations = Minecraft.getInstance().getResourceManager().listResources("models", new Predicate<>() {
			@Override
			public boolean test(ResourceLocation loc) {
				return "legendarium".equals(loc.getNamespace()) && loc.getPath().endsWith("_large.json");
			}
		}).keySet();
		for (ResourceLocation resourceLocation : resourceLocations) {
			var path = resourceLocation.getPath().replace("models/item/", "").replace("_large.json", "");
			var oldModel = new ResourceLocation("legendarium", path);
			var newModel = new ResourceLocation("legendarium", "item/" + path + "_large");
			COMPLIANCES.put(oldModel, newModel);
			event.register(newModel);
		}
	}

	public record LargeItemModel(BakedModel defaultModel, BakedModel handheldModel) implements BakedModel {
		@Override
		public BakedModel applyTransform(ItemDisplayContext transformType, PoseStack mat, boolean applyLeftHandTransform) {
			BakedModel modelToUse = defaultModel;
			if (transformType == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || transformType == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND || transformType == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || transformType == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND) {
				modelToUse = handheldModel;
			}
			return ForgeHooksClient.handleCameraTransforms(mat, modelToUse, transformType, applyLeftHandTransform);
		}

		@Override
		public List<BakedQuad> getQuads(BlockState state, Direction cullFace, RandomSource rand) {
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