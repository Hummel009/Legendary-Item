package com.github.hummel.legendarium.handler;

import com.github.hummel.legendarium.Main;
import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.model.EpicBakedModel;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.IRegistry;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ForgeEventHandler {
	private static final Map<ModelResourceLocation, ModelResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	public void onItemRegistry(RegistryEvent.Register<Item> event) {
		Items.register();
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onModelRegistry(ModelRegistryEvent event) {
		for (Item item : Items.CONTENT) {
			String itemName = item.getUnlocalizedName().substring("item.".length());
			String smallResourceName = String.format("legendarium:%s", itemName);
			String largeResourceName = String.format("legendarium:%s_large", itemName);
			String largeJsonPath = String.format("/assets/legendarium/models/item/%s_large.json", itemName);

			ResourceLocation smallResourceLocation = new ResourceLocation(smallResourceName);
			ModelResourceLocation smallModelResourceLocation = new ModelResourceLocation(smallResourceLocation, "inventory");

			ResourceLocation largeResourceLocation = null;
			ModelResourceLocation largeModelResourceLocation = null;

			try (InputStream inputStream = Main.class.getResourceAsStream(largeJsonPath)) {
				if (inputStream != null) {
					largeResourceLocation = new ResourceLocation(largeResourceName);
					largeModelResourceLocation = new ModelResourceLocation(largeResourceLocation, "inventory");

					COMPLIANCES.put(smallModelResourceLocation, largeModelResourceLocation);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (largeResourceLocation != null && largeModelResourceLocation != null) {
				ModelBakery.registerItemVariants(item, smallModelResourceLocation, largeModelResourceLocation);
			} else {
				ModelBakery.registerItemVariants(item, smallModelResourceLocation);
			}

			ModelLoader.setCustomModelResourceLocation(item, 0, smallModelResourceLocation);
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onModelBake(ModelBakeEvent event) {
		IRegistry<ModelResourceLocation, IBakedModel> modelRegistry = event.getModelRegistry();
		for (Map.Entry<ModelResourceLocation, ModelResourceLocation> compliance : COMPLIANCES.entrySet()) {
			ModelResourceLocation smallModelResourceLocation = compliance.getKey();
			IBakedModel smallBakedModel = modelRegistry.getObject(smallModelResourceLocation);
			if (smallBakedModel != null) {
				ModelResourceLocation largeModelResourceLocation = compliance.getValue();
				IBakedModel largeBakedModel = modelRegistry.getObject(largeModelResourceLocation);
				if (largeBakedModel != null) {
					IBakedModel epicBakedModel = new EpicBakedModel(smallBakedModel, largeBakedModel);
					modelRegistry.putObject(smallModelResourceLocation, epicBakedModel);
				}
			}
		}
	}
}