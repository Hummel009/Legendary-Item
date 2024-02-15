package com.github.hummel.legendarium.model;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.util.List;

@SuppressWarnings("deprecation")
public class EpicBakedModel implements IPerspectiveAwareModel {
	private final IBakedModel smallBakedModel;
	private final IBakedModel largeBakedModel;

	public EpicBakedModel(IBakedModel smallBakedModel, IBakedModel largeBakedModel) {
		this.smallBakedModel = smallBakedModel;
		this.largeBakedModel = largeBakedModel;
	}

	@Override
	public Pair<? extends IFlexibleBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType transformType) {
		IBakedModel bakedModel;
		if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON) {
			bakedModel = largeBakedModel;
		} else {
			bakedModel = smallBakedModel;
		}
		return ((IPerspectiveAwareModel) bakedModel).handlePerspective(transformType);
	}

	@Override
	public List<BakedQuad> getFaceQuads(EnumFacing facing) {
		return largeBakedModel.getFaceQuads(facing);
	}

	@Override
	public VertexFormat getFormat() {
		return ((IFlexibleBakedModel) largeBakedModel).getFormat();
	}

	@Override
	public List<BakedQuad> getGeneralQuads() {
		return largeBakedModel.getGeneralQuads();
	}

	@Override
	public TextureAtlasSprite getParticleTexture() {
		return largeBakedModel.getParticleTexture();
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