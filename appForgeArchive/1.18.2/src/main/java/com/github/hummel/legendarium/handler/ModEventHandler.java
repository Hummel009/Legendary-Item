package com.github.hummel.legendarium.handler;

import com.github.hummel.legendarium.Main;
import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.model.EpicBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ForgeModelBakery;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

public class ModEventHandler {
	private static final Map<ModelResourceLocation, ModelResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onModelRegistry(ModelRegistryEvent event) {
		for (var registryObject : Items.REGISTRY.getEntries()) {
			var itemName = registryObject.get().getDescriptionId().substring("item.legendarium.".length());
			var smallResourceName = String.format("legendarium:%s", itemName);
			var largeResourceName = String.format("legendarium:%s_large", itemName);
			var largeJsonPath = String.format("/assets/legendarium/models/item/%s_large.json", itemName);

			try (var inputStream = Main.class.getResourceAsStream(largeJsonPath)) {
				if (inputStream != null) {
					var smallResourceLocation = new ResourceLocation(smallResourceName);
					var largeResourceLocation = new ResourceLocation(largeResourceName);
					var smallModelResourceLocation = new ModelResourceLocation(smallResourceLocation, "inventory");
					var largeModelResourceLocation = new ModelResourceLocation(largeResourceLocation, "inventory");

					COMPLIANCES.put(smallModelResourceLocation, largeModelResourceLocation);

					ForgeModelBakery.addSpecialModel(largeResourceLocation);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onModelBake(ModelBakeEvent event) {
		var modelRegistry = event.getModelRegistry();
		for (var compliance : COMPLIANCES.entrySet()) {
			var smallModelResourceLocation = compliance.getKey();
			var smallBakedModel = modelRegistry.get(smallModelResourceLocation);
			if (smallBakedModel != null) {
				var largeModelResourceLocation = compliance.getValue();
				var largeBakedModel = modelRegistry.get(largeModelResourceLocation);
				if (largeBakedModel != null) {
					var epicBakedModel = new EpicBakedModel(smallBakedModel, largeBakedModel);
					modelRegistry.put(smallModelResourceLocation, epicBakedModel);
				}
			}
		}
	}
}