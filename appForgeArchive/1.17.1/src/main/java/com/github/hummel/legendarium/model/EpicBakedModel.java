package com.github.hummel.legendarium.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Random;

@SuppressWarnings("deprecation")
public record EpicBakedModel(BakedModel smallBakedModel, BakedModel largeBakedModel) implements BakedModel {
	@Override
	public BakedModel handlePerspective(ItemTransforms.TransformType transformType, PoseStack poseStack) {
		BakedModel bakedModel;
		if (transformType == ItemTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
			bakedModel = largeBakedModel;
		} else {
			bakedModel = smallBakedModel;
		}
		return bakedModel.handlePerspective(transformType, poseStack);
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
	public List<BakedQuad> getQuads(BlockState blockState, Direction direction, Random random) {
		return largeBakedModel.getQuads(blockState, direction, random);
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
	public boolean useAmbientOcclusion() {
		return largeBakedModel.useAmbientOcclusion();
	}

	@Override
	public boolean usesBlockLight() {
		return largeBakedModel.usesBlockLight();
	}
}