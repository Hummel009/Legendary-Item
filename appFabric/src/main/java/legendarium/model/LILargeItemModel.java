package legendarium.model;

import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.fabricmc.fabric.impl.renderer.VanillaModelEncoder;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.function.Supplier;

public record LILargeItemModel(BakedModel smallModel, BakedModel largeModel) implements BakedModel {
	@Override
	public void emitItemQuads(ItemStack stack, Supplier<RandomSource> randomSupplier, RenderContext context) {
		BakedModel bakedModel;
		var itemDisplayContext = context.itemTransformationMode();
		if (itemDisplayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || itemDisplayContext == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND || itemDisplayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || itemDisplayContext == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND) {
			bakedModel = largeModel;
		} else {
			bakedModel = smallModel;
		}
		VanillaModelEncoder.emitItemQuads(bakedModel, null, randomSupplier, context);
	}

	@Override
	public List<BakedQuad> getQuads(BlockState blockState, Direction direction, RandomSource randomSource) {
		return largeModel.getQuads(blockState, direction, randomSource);
	}

	@Override
	public boolean isVanillaAdapter() {
		return false;
	}

	@Override
	public boolean useAmbientOcclusion() {
		return largeModel.useAmbientOcclusion();
	}

	@Override
	public boolean isGui3d() {
		return largeModel.isGui3d();
	}

	@Override
	public boolean usesBlockLight() {
		return largeModel.usesBlockLight();
	}

	@Override
	public boolean isCustomRenderer() {
		return largeModel.isCustomRenderer();
	}

	@Override
	public TextureAtlasSprite getParticleIcon() {
		return largeModel.getParticleIcon();
	}

	@Override
	public ItemTransforms getTransforms() {
		return largeModel.getTransforms();
	}

	@Override
	public ItemOverrides getOverrides() {
		return largeModel.getOverrides();
	}
}