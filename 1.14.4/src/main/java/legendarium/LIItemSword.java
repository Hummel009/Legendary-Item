package legendarium;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Direction;
import net.minecraftforge.client.ForgeHooksClient;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.util.List;
import java.util.Random;

public class LIItemSword extends SwordItem {
	public LIItemSword() {
		super(ItemTier.DIAMOND, 3, -2.4F, new Properties().group(LICreativeTabs.TAB_ARTIFACTS));
	}

	public static class LargeItemModel implements IBakedModel {
		public final IBakedModel defaultModel;
		public final IBakedModel handheldModel;

		public LargeItemModel(IBakedModel defaultModel, IBakedModel handheldModel) {
			this.defaultModel = defaultModel;
			this.handheldModel = handheldModel;
		}

		@Override
		public ItemOverrideList getOverrides() {
			return handheldModel.getOverrides();
		}

		@Override
		public TextureAtlasSprite getParticleTexture() {
			return defaultModel.getParticleTexture();
		}

		@Override
		public List<BakedQuad> getQuads(BlockState state, Direction cullFace, Random rand) {
			return defaultModel.getQuads(state, cullFace, rand);
		}

		@Override
		public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType transformType) {
			IBakedModel modelToUse = defaultModel;
			if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
				modelToUse = handheldModel;
			}
			return ForgeHooksClient.handlePerspective(modelToUse, transformType);
		}

		@Override
		public boolean isAmbientOcclusion() {
			return defaultModel.isAmbientOcclusion();
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