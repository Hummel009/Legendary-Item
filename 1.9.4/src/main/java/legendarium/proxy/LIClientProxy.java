package legendarium.proxy;

import legendarium.LI;
import legendarium.model.LILargeItemModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class LIClientProxy extends LICommonProxy {
	public static final Map<ModelResourceLocation, ModelResourceLocation> COMPLIANCES = new HashMap<>();

	@Override
	@SideOnly(Side.CLIENT)
	public void onInit() {
		for (Item item : LI.CONTENT) {
			ResourceLocation itemName = item.getRegistryName();
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
			IBakedModel smallModel = event.getModelRegistry().getObject(smallLocation);
			if (smallModel != null) {
				ModelResourceLocation largeLocation = compliance.getValue();
				IBakedModel largeModel = event.getModelRegistry().getObject(largeLocation);
				if (largeModel != null) {
					event.getModelRegistry().putObject(smallLocation, new LILargeItemModel(smallModel, largeModel));
				}
			}
		}
	}
}