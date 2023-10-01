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

public class LILargeItemModel implements IBakedModel {
	public final IBakedModel smallModel;
	public final IBakedModel largeModel;

	public LILargeItemModel(IBakedModel smallModel, IBakedModel largeModel) {
		this.smallModel = smallModel;
		this.largeModel = largeModel;
	}

	@Override
	public boolean func_230044_c_() {
		return smallModel.func_230044_c_();
	}

	@Override
	public ItemOverrideList getOverrides() {
		return smallModel.getOverrides();
	}

	@Override
	public TextureAtlasSprite getParticleTexture() {
		return smallModel.getParticleTexture();
	}

	@Override
	public List<BakedQuad> getQuads(BlockState blockState, Direction direction, Random random) {
		return smallModel.getQuads(blockState, direction, random);
	}

	@Override
	public IBakedModel handlePerspective(ItemCameraTransforms.TransformType transformType, MatrixStack matrixStack) {
		IBakedModel bakedModel = smallModel;
		if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
			bakedModel = largeModel;
		}
		return bakedModel.handlePerspective(transformType, matrixStack);
	}

	@Override
	public boolean isAmbientOcclusion() {
		return smallModel.isAmbientOcclusion();
	}

	@Override
	public boolean isBuiltInRenderer() {
		return smallModel.isBuiltInRenderer();
	}

	@Override
	public boolean isGui3d() {
		return smallModel.isGui3d();
	}
}