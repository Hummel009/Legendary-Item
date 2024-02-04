package legendarium.model;

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
public record LILargeItemModel(BakedModel smallModel, BakedModel largeModel) implements BakedModel {

	@Override
	public BakedModel handlePerspective(ItemTransforms.TransformType transformType, PoseStack poseStack) {
		var bakedModel = smallModel;
		if (transformType == ItemTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
			bakedModel = largeModel;
		}
		return bakedModel.handlePerspective(transformType, poseStack);
	}

	@Override
	public List<BakedQuad> getQuads(BlockState blockState, Direction direction, Random random) {
		return smallModel.getQuads(blockState, direction, random);
	}

	@Override
	public boolean useAmbientOcclusion() {
		return smallModel.useAmbientOcclusion();
	}

	@Override
	public boolean isGui3d() {
		return smallModel.isGui3d();
	}

	@Override
	public boolean usesBlockLight() {
		return smallModel.usesBlockLight();
	}

	@Override
	public boolean isCustomRenderer() {
		return smallModel.isCustomRenderer();
	}

	@Override
	public TextureAtlasSprite getParticleIcon() {
		return smallModel.getParticleIcon();
	}

	@Override
	public ItemOverrides getOverrides() {
		return smallModel.getOverrides();
	}
}
