package legendarium.model;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.util.List;

@SuppressWarnings("deprecation")
public class LILargeItemModel implements IPerspectiveAwareModel {
	private final IBakedModel smallBakedModel;
	private final IBakedModel largeBakedModel;

	public LILargeItemModel(IBakedModel smallBakedModel, IBakedModel largeBakedModel) {
		this.smallBakedModel = smallBakedModel;
		this.largeBakedModel = largeBakedModel;
	}

	@Override
	public ItemCameraTransforms getItemCameraTransforms() {
		return smallBakedModel.getItemCameraTransforms();
	}

	@Override
	public ItemOverrideList getOverrides() {
		return smallBakedModel.getOverrides();
	}

	@Override
	public TextureAtlasSprite getParticleTexture() {
		return smallBakedModel.getParticleTexture();
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState blockState, EnumFacing facing, long l) {
		return smallBakedModel.getQuads(blockState, facing, l);
	}

	@Override
	public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType transformType) {
		IBakedModel bakedModel = smallBakedModel;
		if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
			bakedModel = largeBakedModel;
		}
		return ((IPerspectiveAwareModel) bakedModel).handlePerspective(transformType);
	}

	@Override
	public boolean isAmbientOcclusion() {
		return smallBakedModel.isAmbientOcclusion();
	}

	@Override
	public boolean isBuiltInRenderer() {
		return smallBakedModel.isBuiltInRenderer();
	}

	@Override
	public boolean isGui3d() {
		return smallBakedModel.isGui3d();
	}
}