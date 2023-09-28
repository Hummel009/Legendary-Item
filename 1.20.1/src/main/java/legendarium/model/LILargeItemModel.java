package legendarium.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public record LILargeItemModel(BakedModel smallModel, BakedModel largeModel) implements BakedModel {

	@Override
	public BakedModel applyTransform(ItemDisplayContext itemDisplayContext, PoseStack poseStack, boolean b) {
		BakedModel bakedModel = smallModel;
		if (itemDisplayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || itemDisplayContext == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND || itemDisplayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || itemDisplayContext == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND) {
			bakedModel = largeModel;
		}
		return bakedModel.applyTransform(itemDisplayContext, poseStack, b);
	}

	@Override
	public List<BakedQuad> getQuads(BlockState blockState, Direction direction, RandomSource randomSource) {
		return smallModel.getQuads(blockState, direction, randomSource);
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
