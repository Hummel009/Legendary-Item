package legendarium.model;

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
	public TextureAtlasSprite getParticleTexture() {
		return smallBakedModel.getParticleTexture();
	}

	@Override
	public List<BakedQuad> getFaceQuads(EnumFacing facing) {
		return smallBakedModel.getFaceQuads(facing);
	}

	@Override
	public List<BakedQuad> getGeneralQuads() {
		return null;
	}

	@Override
	public Pair<? extends IFlexibleBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType transformType) {
		IBakedModel bakedModel = smallBakedModel;
		if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON) {
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

	@Override
	public VertexFormat getFormat() {
		return ((IFlexibleBakedModel) smallBakedModel).getFormat();
	}
}