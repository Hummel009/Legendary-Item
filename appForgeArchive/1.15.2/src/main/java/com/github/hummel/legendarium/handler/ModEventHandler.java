package com.github.hummel.legendarium.handler;

import com.github.hummel.legendarium.Main;
import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.model.EpicBakedModel;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ModEventHandler {
	private static final Map<ModelResourceLocation, ModelResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	@SuppressWarnings("MethodMayBeStatic")
	public void onModelRegistry(ModelRegistryEvent event) {
		for (RegistryObject<Item> registryObject : Items.REGISTRY.getEntries()) {
			String itemName = registryObject.get().getDescriptionId().substring("item.legendarium.".length());
			String largeJsonPath = String.format("/assets/legendarium/models/item/%s_large.json", itemName);

			try (InputStream inputStream = Main.class.getResourceAsStream(largeJsonPath)) {
				if (inputStream != null) {
					String smallResourceName = String.format("%s", itemName);
					String largeResourceName = String.format("%s_large", itemName);

					ResourceLocation smallResourceLocation = new ResourceLocation("legendarium", smallResourceName);
					ResourceLocation largeResourceLocation = new ResourceLocation("legendarium", largeResourceName);

					ModelResourceLocation smallModelResourceLocation = new ModelResourceLocation(smallResourceLocation, "inventory");
					ModelResourceLocation largeModelResourceLocation = new ModelResourceLocation(largeResourceLocation, "inventory");

					COMPLIANCES.put(smallModelResourceLocation, largeModelResourceLocation);

					ModelLoader.addSpecialModel(largeModelResourceLocation);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	@SuppressWarnings("MethodMayBeStatic")
	public void onModelBake(ModelBakeEvent event) {
		Map<ResourceLocation, IBakedModel> modelRegistry = event.getModelRegistry();
		for (Map.Entry<ModelResourceLocation, ModelResourceLocation> compliance : COMPLIANCES.entrySet()) {
			ModelResourceLocation smallModelResourceLocation = compliance.getKey();
			IBakedModel smallBakedModel = modelRegistry.get(smallModelResourceLocation);
			if (smallBakedModel != null) {
				ModelResourceLocation largeModelResourceLocation = compliance.getValue();
				IBakedModel largeBakedModel = modelRegistry.get(largeModelResourceLocation);
				if (largeBakedModel != null) {
					IBakedModel epicBakedModel = new EpicBakedModel(smallBakedModel, largeBakedModel);
					modelRegistry.put(smallModelResourceLocation, epicBakedModel);
				}
			}
		}
	}
}