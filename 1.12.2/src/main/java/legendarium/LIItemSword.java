package legendarium;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumFacing;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.util.List;

public class LIItemSword extends ItemSword {
	public LIItemSword() {
		super(Item.ToolMaterial.DIAMOND);
		setCreativeTab(LICreativeTabs.TAB_ARTIFACTS);
	}

	public static class LargeItemModel implements IBakedModel {
		public final IBakedModel defaultModel;
		public final IBakedModel handheldModel;

		public LargeItemModel(IBakedModel defaultModel, IBakedModel handheldModel) {
			this.defaultModel = defaultModel;
			this.handheldModel = handheldModel;
		}

		@Override
		public ItemCameraTransforms getItemCameraTransforms() {
			return defaultModel.getItemCameraTransforms();
		}

		@Override
		public ItemOverrideList getOverrides() {
			return defaultModel.getOverrides();
		}

		@Override
		public TextureAtlasSprite getParticleTexture() {
			return defaultModel.getParticleTexture();
		}

		@Override
		public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
			return defaultModel.getQuads(state, side, rand);
		}

		@Override
		public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType transformType) {
			IBakedModel modelToUse = defaultModel;
			if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
				modelToUse = handheldModel;
			}
			return modelToUse.handlePerspective(transformType);
		}

		@Override
		public boolean isAmbientOcclusion() {
			return defaultModel.isAmbientOcclusion();
		}

		@Override
		public boolean isAmbientOcclusion(IBlockState state) {
			return defaultModel.isAmbientOcclusion(state);
		}

		@Override
		public boolean isBuiltInRenderer() {
			return defaultModel.isBuiltInRenderer();
		}

		@Override
		public boolean isGui3d() {
			return defaultModel.isGui3d();
		}
	}
}