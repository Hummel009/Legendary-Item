package legendarium.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

@SuppressWarnings("deprecation")
public record LILargeItemModel(BakedModel smallBakedModel, BakedModel largeBakedModel) implements BakedModel {
	@Override
	public BakedModel applyTransform(ItemDisplayContext itemDisplayContext, PoseStack poseStack, boolean b) {
		var bakedModel = smallBakedModel;
		if (itemDisplayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || itemDisplayContext == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND || itemDisplayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || itemDisplayContext == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND) {
			bakedModel = largeBakedModel;
		}
		return bakedModel.applyTransform(itemDisplayContext, poseStack, b);
	}

	@Override
	public List<BakedQuad> getQuads(BlockState blockState, Direction direction, RandomSource randomSource) {
		return smallBakedModel.getQuads(blockState, direction, randomSource);
	}

	@Override
	public boolean useAmbientOcclusion() {
		return smallBakedModel.useAmbientOcclusion();
	}

	@Override
	public boolean isGui3d() {
		return smallBakedModel.isGui3d();
	}

	@Override
	public boolean usesBlockLight() {
		return smallBakedModel.usesBlockLight();
	}

	@Override
	public boolean isCustomRenderer() {
		return smallBakedModel.isCustomRenderer();
	}

	@Override
	public TextureAtlasSprite getParticleIcon() {
		return smallBakedModel.getParticleIcon();
	}

	@Override
	public ItemOverrides getOverrides() {
		return smallBakedModel.getOverrides();
	}
}