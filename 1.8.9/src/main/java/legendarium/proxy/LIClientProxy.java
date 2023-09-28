package legendarium.proxy;

import legendarium.LI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LIClientProxy extends LICommonProxy {
	public static final Map<ModelResourceLocation, ModelResourceLocation> COMPLIANCES = new HashMap<>();

	@Override
	@SideOnly(Side.CLIENT)
	public void onInit() {
		for (Item item : LI.CONTENT) {
			String itemName = item.getRegistryName();
			String resourceFileName = (itemName + "_large.json").replace("legendarium:", "");
			try (InputStream imageStream = LI.class.getResourceAsStream("/assets/legendarium/models/item/" + resourceFileName)) {
				ModelResourceLocation smallModel = new ModelResourceLocation(itemName, "inventory");
				ModelResourceLocation largeModel = new ModelResourceLocation(itemName + "_large", "inventory");
				if (imageStream != null) {
					COMPLIANCES.put(smallModel, largeModel);
					ModelBakery.registerItemVariants(item, smallModel, largeModel);
				} else {
					ModelBakery.registerItemVariants(item, smallModel);
				}
				Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, smallModel);
			} catch (Exception e) {
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onModelBake(ModelBakeEvent event) {
		for (Map.Entry<ModelResourceLocation, ModelResourceLocation> compliance : COMPLIANCES.entrySet()) {
			ModelResourceLocation smallLocation = compliance.getKey();
			IBakedModel smallModel = event.modelRegistry.getObject(smallLocation);
			if (smallModel != null) {
				ModelResourceLocation largeLocation = compliance.getValue();
				IBakedModel largeModel = event.modelRegistry.getObject(largeLocation);
				if (largeModel != null) {
					event.modelRegistry.putObject(smallLocation, new LargeItemModel(smallModel, largeModel));
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
		public List<BakedQuad> getFaceQuads(EnumFacing facing) {
			return smallModel.getFaceQuads(facing);
		}

		@Override
		public VertexFormat getFormat() {
			return ((IFlexibleBakedModel) smallModel).getFormat();
		}

		@Override
		public List<BakedQuad> getGeneralQuads() {
			return smallModel.getGeneralQuads();
		}

		@Override
		public ItemCameraTransforms getItemCameraTransforms() {
			return smallModel.getItemCameraTransforms();
		}

		@Override
		public TextureAtlasSprite getParticleTexture() {
			return smallModel.getParticleTexture();
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