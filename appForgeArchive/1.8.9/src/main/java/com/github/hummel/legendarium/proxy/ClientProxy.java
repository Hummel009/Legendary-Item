package com.github.hummel.legendarium.proxy;

import com.github.hummel.legendarium.Main;
import com.github.hummel.legendarium.handler.ForgeEventHandler;
import com.github.hummel.legendarium.init.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;

public class ClientProxy implements CommonProxy {
	@Override
	public void onInit() {
		Collection<ModelResourceLocation> modelResourceLocations = new HashSet<>();

		for (Item item : Items.CONTENT) {
			String name = item.getUnlocalizedName().substring("item.".length());
			String smallResourceLocation = String.format("legendarium:%s", name);
			String largeResourceLocation = String.format("legendarium:%s_large", name);
			String largeJsonModelPath = String.format("/assets/legendarium/models/item/%s_large.json", name);

			ModelResourceLocation smallModelResourceLocation = new ModelResourceLocation(smallResourceLocation, "inventory");

			modelResourceLocations.clear();

			try (InputStream inputStream = Main.class.getResourceAsStream(largeJsonModelPath)) {
				if (inputStream != null) {
					ModelResourceLocation largeModelResourceLocation = new ModelResourceLocation(largeResourceLocation, "inventory");

					ForgeEventHandler.COMPLIANCES.put(smallModelResourceLocation, largeModelResourceLocation);
					modelResourceLocations.add(largeModelResourceLocation);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				modelResourceLocations.add(smallModelResourceLocation);
			}

			ModelBakery.registerItemVariants(item, modelResourceLocations.toArray(new ModelResourceLocation[0]));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, smallModelResourceLocation);
		}
	}
}