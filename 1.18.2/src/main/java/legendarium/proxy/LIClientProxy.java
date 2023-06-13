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
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ForgeModelBakery;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.*;
import java.util.function.Predicate;

public class LIClientProxy extends LIServerProxy {
	private static final Map<ResourceLocation, ResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onModelBake(ModelBakeEvent event) {
		for (Map.Entry<ResourceLocation, ResourceLocation> compliance : COMPLIANCES.entrySet()) {
			var oldLocation = new ModelResourceLocation(compliance.getKey(), "inventory");
			var oldModel = event.getModelRegistry().get(oldLocation);
			if (oldModel != null) {
				var newLocation = compliance.getValue();
				var newModel = event.getModelRegistry().get(newLocation);
				if (newModel != null) {
					event.getModelRegistry().put(oldLocation, new ScaledItemModel(oldModel, newModel));
				}
			}
		}
	}

	@SubscribeEvent
	public void onModelRegistry(ModelRegistryEvent event) {
		Collection<ResourceLocation> resourceLocations = Minecraft.getInstance().getResourceManager().listResources("models", new Predicate<>() {
			@Override
			public boolean test(String loc) {
				return loc.endsWith("_large.json");
			}
		});
		for (ResourceLocation resourceLocation : resourceLocations) {
			var path = resourceLocation.getPath().replace("models/item/", "").replace("_large.json", "");
			var oldModel = new ResourceLocation("legendarium", path);
			var newModel = new ResourceLocation("legendarium", "item/" + path + "_large");
			ForgeModelBakery.addSpecialModel(newModel);
			COMPLIANCES.put(oldModel, newModel);
		}
	}

	public record ScaledItemModel(BakedModel defaultModel, BakedModel handheldModel) implements BakedModel {
		@Override
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