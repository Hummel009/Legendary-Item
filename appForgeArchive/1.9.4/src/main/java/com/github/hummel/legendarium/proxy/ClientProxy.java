package com.github.hummel.legendarium.proxy;

import com.github.hummel.legendarium.Main;
import com.github.hummel.legendarium.init.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.InputStream;

import static com.github.hummel.legendarium.handler.ForgeEventHandler.COMPLIANCES;

public class ClientProxy implements CommonProxy {
	@Override
	@SideOnly(Side.CLIENT)
	public void onInit() {
		for (Item item : Items.CONTENT) {
			String itemName = item.getUnlocalizedName().substring("item.".length());
			String largeJsonPath = String.format("/assets/legendarium/models/item/%s_large.json", itemName);

			String smallResourceName = String.format("%s", itemName);
			ResourceLocation smallResourceLocation = new ResourceLocation("legendarium", smallResourceName);
			ModelResourceLocation smallModelResourceLocation = new ModelResourceLocation(smallResourceLocation, "inventory");

			try (InputStream inputStream = Main.class.getResourceAsStream(largeJsonPath)) {
				if (inputStream != null) {
					String largeResourceName = String.format("%s_large", itemName);
					ResourceLocation largeResourceLocation = new ResourceLocation("legendarium", largeResourceName);
					ModelResourceLocation largeModelResourceLocation = new ModelResourceLocation(largeResourceLocation, "inventory");

					COMPLIANCES.put(smallModelResourceLocation, largeModelResourceLocation);

					ModelBakery.registerItemVariants(item, largeModelResourceLocation);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ModelBakery.registerItemVariants(item, smallModelResourceLocation);
				Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, smallModelResourceLocation);
			}
		}
	}
}