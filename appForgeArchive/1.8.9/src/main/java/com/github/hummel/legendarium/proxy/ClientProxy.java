package com.github.hummel.legendarium.proxy;

import com.github.hummel.legendarium.Main;
import com.github.hummel.legendarium.init.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.io.InputStream;

import static com.github.hummel.legendarium.handler.ForgeEventHandler.COMPLIANCES;

public class ClientProxy implements CommonProxy {
	@Override
	public void onInit() {
		for (Item item : Items.CONTENT) {
			String itemName = item.getUnlocalizedName().substring("item.".length());
			String smallResourceName = String.format("legendarium:%s", itemName);
			String largeResourceName = String.format("legendarium:%s_large", itemName);
			String largeJsonPath = String.format("/assets/legendarium/models/item/%s_large.json", itemName);

			ResourceLocation smallResourceLocation = new ResourceLocation(smallResourceName);
			ResourceLocation largeResourceLocation = new ResourceLocation(largeResourceName);
			ModelResourceLocation smallModelResourceLocation = new ModelResourceLocation(smallResourceLocation, "inventory");
			ModelResourceLocation largeModelResourceLocation = null;

			try (InputStream inputStream = Main.class.getResourceAsStream(largeJsonPath)) {
				if (inputStream != null) {
					largeModelResourceLocation = new ModelResourceLocation(largeResourceLocation, "inventory");

					COMPLIANCES.put(smallModelResourceLocation, largeModelResourceLocation);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (largeModelResourceLocation != null) {
				ModelBakery.registerItemVariants(item, smallModelResourceLocation, largeModelResourceLocation);
			} else {
				ModelBakery.registerItemVariants(item, smallModelResourceLocation);
			}

			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, smallModelResourceLocation);
		}
	}
}