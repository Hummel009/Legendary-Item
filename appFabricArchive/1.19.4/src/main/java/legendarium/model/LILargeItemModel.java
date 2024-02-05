package legendarium.model;

import legendarium.mixin.LIAccessor;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.function.Supplier;

public record LILargeItemModel(BakedModel smallBakedModel, BakedModel largeBakedModel) implements BakedModel {
	@Override
	@SuppressWarnings({"CastToIncompatibleInterface", "deprecation"})
	public void emitItemQuads(ItemStack itemStack, Supplier<RandomSource> randomSupplier, RenderContext context) {
		BakedModel bakedModel;

		var transformMode = ((LIAccessor) context).getTransformMode();
		if (transformMode == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || transformMode == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND || transformMode == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || transformMode == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND) {
			bakedModel = largeBakedModel;
		} else {
			bakedModel = smallBakedModel;
		}

		context.bakedModelConsumer().accept(bakedModel, null);
	}

	@Override
	public List<BakedQuad> getQuads(BlockState blockState, Direction direction, RandomSource randomSource) {
		return largeBakedModel.getQuads(blockState, direction, randomSource);
	}

	@Override
	public boolean isVanillaAdapter() {
		return false;
	}

	@Override
	public boolean useAmbientOcclusion() {
		return largeBakedModel.useAmbientOcclusion();
	}

	@Override
	public boolean isGui3d() {
		return largeBakedModel.isGui3d();
	}

	@Override
	public boolean usesBlockLight() {
		return largeBakedModel.usesBlockLight();
	}

	@Override
	public boolean isCustomRenderer() {
		return largeBakedModel.isCustomRenderer();
	}

	@Override
	public TextureAtlasSprite getParticleIcon() {
		return largeBakedModel.getParticleIcon();
	}

	@Override
	public ItemTransforms getTransforms() {
		return largeBakedModel.getTransforms();
	}

	@Override
	public ItemOverrides getOverrides() {
		return largeBakedModel.getOverrides();
	}
}