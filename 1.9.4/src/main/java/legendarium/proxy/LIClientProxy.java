package legendarium.proxy;

import legendarium.LI;
import legendarium.content.LIItemSword;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.util.*;

public class LIClientProxy extends LICommonProxy {
	public static final Map<ModelResourceLocation, ModelResourceLocation> COMPLIANCES = new HashMap<>();

	@Override
	@SideOnly(Side.CLIENT)
	public void onInit() {
		Collection<Item> inapplicable = new HashSet<>();
		inapplicable.add(LI.weaponAngrist);
		inapplicable.add(LI.weaponLegolas);
		inapplicable.add(LI.weaponGrima);
		for (Item item : LI.CONTENT) {
			ResourceLocation itemName = item.getRegistryName();
			ModelResourceLocation smallModel = new ModelResourceLocation(itemName, "inventory");
			ModelResourceLocation largeModel = new ModelResourceLocation(itemName + "_large", "inventory");
			if (item instanceof LIItemSword && !inapplicable.contains(item)) {
				COMPLIANCES.put(smallModel, largeModel);
				ModelBakery.registerItemVariants(item, smallModel, largeModel);
			} else {
				ModelBakery.registerItemVariants(item, smallModel);
			}
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, smallModel);
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onModelBake(ModelBakeEvent event) {
		for (Map.Entry<ModelResourceLocation, ModelResourceLocation> compliance : COMPLIANCES.entrySet()) {
			ModelResourceLocation smallLocation = compliance.getKey();
			IBakedModel smallModel = event.getModelRegistry().getObject(smallLocation);
			if (smallModel != null) {
				ModelResourceLocation largeLocation = compliance.getValue();
				IBakedModel largeModel = event.getModelRegistry().getObject(largeLocation);
				if (largeModel != null) {
					event.getModelRegistry().putObject(smallLocation, new LargeItemModel(smallModel, largeModel));
				}
			}
		}
	}

	public static class LargeItemModel implements IPerspectiveAwareModel {
		public final IBakedModel smallModel;
		public final IBakedModel largeModel;

		public LargeItemModel(IBakedModel smallModel, IBakedModel largeModel) {
			this.smallModel = smallModel;
			this.largeModel = largeModel;
		}

		@Override
		public ItemCameraTransforms getItemCameraTransforms() {
			return smallModel.getItemCameraTransforms();
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
		public List<BakedQuad> getQuads(IBlockState blockState, EnumFacing facing, long l) {
			return smallModel.getQuads(blockState, facing, l);
		}

		@Override
		public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType transformType) {
			IBakedModel bakedModel = smallModel;
			if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND) {
				bakedModel = largeModel;
			}
			return ((IPerspectiveAwareModel) bakedModel).handlePerspective(transformType);
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
}