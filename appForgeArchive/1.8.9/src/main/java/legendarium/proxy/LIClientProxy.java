package legendarium.proxy;

import legendarium.LI;
import legendarium.model.LILargeItemModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class LIClientProxy extends LICommonProxy {
	private static final Map<ModelResourceLocation, ModelResourceLocation> COMPLIANCES = new HashMap<>();

	@Override
	@SideOnly(Side.CLIENT)
	public void onInit() {
		for (Item item : LI.CONTENT) {
			String registryName = item.getRegistryName();
			String resourceFileName = (registryName + "_large.json").replace("legendarium:", "");
			try (InputStream inputStream = LI.class.getResourceAsStream("/assets/legendarium/models/item/" + resourceFileName)) {
				ModelResourceLocation smallResourceLocation = new ModelResourceLocation(registryName, "inventory");
				ModelResourceLocation largeResourceLocation = new ModelResourceLocation(registryName + "_large", "inventory");
				if (inputStream != null) {
					COMPLIANCES.put(smallResourceLocation, largeResourceLocation);
					ModelBakery.registerItemVariants(item, smallResourceLocation, largeResourceLocation);
				} else {
					ModelBakery.registerItemVariants(item, smallResourceLocation);
				}
				Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, smallResourceLocation);
			} catch (Exception e) {
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onModelBake(ModelBakeEvent event) {
		for (Map.Entry<ModelResourceLocation, ModelResourceLocation> compliance : COMPLIANCES.entrySet()) {
			ModelResourceLocation smallResourceLocation = compliance.getKey();
			IBakedModel smallBakedModel = event.modelRegistry.getObject(smallResourceLocation);
			if (smallBakedModel != null) {
				ModelResourceLocation largeResourceLocation = compliance.getValue();
				IBakedModel largeBakedModel = event.modelRegistry.getObject(largeResourceLocation);
				if (largeBakedModel != null) {
					event.modelRegistry.putObject(smallResourceLocation, new LILargeItemModel(smallBakedModel, largeBakedModel));
				}
			}
		}
	}
}