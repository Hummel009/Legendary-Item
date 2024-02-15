package com.github.hummel.legendarium.model;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.util.List;

@SuppressWarnings("deprecation")
public class EpicBakedModel implements IBakedModel {
	private final IBakedModel smallBakedModel;
	private final IBakedModel largeBakedModel;

	public EpicBakedModel(IBakedModel smallBakedModel, IBakedModel largeBakedModel) {
		this.smallBakedModel = smallBakedModel;
		this.largeBakedModel = largeBakedModel;
	}

	@Override
	public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType transformType) {
		IBakedModel bakedModel;
		if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
			bakedModel = largeBakedModel;
		} else {
			bakedModel = smallBakedModel;
		}
		return bakedModel.handlePerspective(transformType);
	}

	@Override
	public ItemOverrideList getOverrides() {
		return largeBakedModel.getOverrides();
	}

	@Override
	public TextureAtlasSprite getParticleTexture() {
		return largeBakedModel.getParticleTexture();
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState blockState, EnumFacing facing, long random) {
		return largeBakedModel.getQuads(blockState, facing, random);
	}

	@Override
	public ItemCameraTransforms getItemCameraTransforms() {
		return largeBakedModel.getItemCameraTransforms();
	}

	@Override
	public boolean isAmbientOcclusion() {
		return largeBakedModel.isAmbientOcclusion();
	}

	@Override
	public boolean isBuiltInRenderer() {
		return largeBakedModel.isBuiltInRenderer();
	}

	@Override
	public boolean isGui3d() {
		return largeBakedModel.isGui3d();
	}
}