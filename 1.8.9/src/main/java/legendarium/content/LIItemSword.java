package legendarium.content;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.util.List;

public class LIItemSword extends ItemSword {
	public LIItemSword() {
		super(Item.ToolMaterial.EMERALD);
		setCreativeTab(LICreativeTabs.TAB_ARTIFACTS);
	}

	public static class LargeItemModel implements IPerspectiveAwareModel {
		public final IBakedModel smallModel;
		public final IBakedModel largeModel;

		public LargeItemModel(IBakedModel smallModel, IBakedModel largeModel) {
			this.smallModel = smallModel;
			this.largeModel = largeModel;
		}

		@Override
		public TextureAtlasSprite getParticleTexture() {
			return smallModel.getParticleTexture();
		}

		@Override
		public ItemCameraTransforms getItemCameraTransforms() {
			return smallModel.getItemCameraTransforms();
		}

		@Override
		public Pair<? extends IFlexibleBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType transformType) {
			IBakedModel bakedModel = smallModel;
			if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON) {
				bakedModel = largeModel;
			}
			return ((IPerspectiveAwareModel) bakedModel).handlePerspective(transformType);
		}

		@Override
		public List<BakedQuad> getFaceQuads(EnumFacing facing) {
			return smallModel.getFaceQuads(facing);
		}

		@Override
		public List<BakedQuad> getGeneralQuads() {
			return smallModel.getGeneralQuads();
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

		@Override
		public VertexFormat getFormat() {
			return ((IPerspectiveAwareModel) smallModel).getFormat();
		}
	}
}