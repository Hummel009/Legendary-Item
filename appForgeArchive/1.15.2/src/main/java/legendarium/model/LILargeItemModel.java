package legendarium.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;

import java.util.List;
import java.util.Random;

@SuppressWarnings("deprecation")
public class LILargeItemModel implements IBakedModel {
	private final IBakedModel smallBakedModel;
	private final IBakedModel largeBakedModel;

	public LILargeItemModel(IBakedModel smallBakedModel, IBakedModel largeBakedModel) {
		this.smallBakedModel = smallBakedModel;
		this.largeBakedModel = largeBakedModel;
	}

	@Override
	public IBakedModel handlePerspective(ItemCameraTransforms.TransformType transformType, MatrixStack matrixStack) {
		IBakedModel bakedModel = smallBakedModel;
		if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
			bakedModel = largeBakedModel;
		}
		return bakedModel.handlePerspective(transformType, matrixStack);
	}

	@Override
	public List<BakedQuad> getQuads(BlockState blockState, Direction direction, Random random) {
		return smallBakedModel.getQuads(blockState, direction, random);
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
	public ItemOverrideList getOverrides() {
		return smallBakedModel.getOverrides();
	}
}