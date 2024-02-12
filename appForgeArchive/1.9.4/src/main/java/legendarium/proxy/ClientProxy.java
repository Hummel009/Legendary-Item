package legendarium.proxy;

import legendarium.Main;
import legendarium.handler.ForgeEventHandler;
import legendarium.init.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import java.io.InputStream;

public class ClientProxy implements CommonProxy {
	@Override
	public void onInit() {
		for (Item item : Items.CONTENT) {
			String registryName = item.getRegistryName().toString();
			String resourceFileName = registryName.replace("legendarium:", "") + "_large.json";
			try (InputStream inputStream = Main.class.getResourceAsStream("/assets/legendarium/models/item/" + resourceFileName)) {
				ModelResourceLocation smallResourceLocation = new ModelResourceLocation(registryName, "inventory");
				ModelResourceLocation largeResourceLocation = new ModelResourceLocation(registryName + "_large", "inventory");
				if (inputStream != null) {
					ForgeEventHandler.COMPLIANCES.put(smallResourceLocation, largeResourceLocation);
					ModelBakery.registerItemVariants(item, smallResourceLocation, largeResourceLocation);
				} else {
					ModelBakery.registerItemVariants(item, smallResourceLocation);
				}
				Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, smallResourceLocation);
			} catch (Exception e) {
			}
		}
	}
}