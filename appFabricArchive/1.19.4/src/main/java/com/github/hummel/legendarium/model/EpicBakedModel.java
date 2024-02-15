package com.github.hummel.legendarium.model;

import com.github.hummel.legendarium.mixin.ContextAccessor;
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

@SuppressWarnings("deprecation")
public record EpicBakedModel(BakedModel smallBakedModel, BakedModel largeBakedModel) implements BakedModel {
	@Override
	@SuppressWarnings("CastToIncompatibleInterface")
	public void emitItemQuads(ItemStack itemStack, Supplier<RandomSource> randomSupplier, RenderContext renderContext) {
		BakedModel bakedModel;

		var transformMode = ((ContextAccessor) renderContext).getTransformMode();
		if (transformMode == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || transformMode == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND || transformMode == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || transformMode == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND) {
			bakedModel = largeBakedModel;
		} else {
			bakedModel = smallBakedModel;
		}

		renderContext.bakedModelConsumer().accept(bakedModel, null);
	}

	@Override
	public ItemOverrides getOverrides() {
		return largeBakedModel.getOverrides();
	}

	@Override
	public TextureAtlasSprite getParticleIcon() {
		return largeBakedModel.getParticleIcon();
	}

	@Override
	public List<BakedQuad> getQuads(BlockState blockState, Direction direction, RandomSource randomSource) {
		return largeBakedModel.getQuads(blockState, direction, randomSource);
	}

	@Override
	public ItemTransforms getTransforms() {
		return largeBakedModel.getTransforms();
	}

	@Override
	public boolean isCustomRenderer() {
		return largeBakedModel.isCustomRenderer();
	}

	@Override
	public boolean isGui3d() {
		return largeBakedModel.isGui3d();
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
	public boolean usesBlockLight() {
		return largeBakedModel.usesBlockLight();
	}
}