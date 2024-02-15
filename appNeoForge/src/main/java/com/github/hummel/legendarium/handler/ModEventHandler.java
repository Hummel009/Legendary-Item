package com.github.hummel.legendarium.handler;

import com.github.hummel.legendarium.model.EpicBakedModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.ModelEvent;

import java.util.HashMap;
import java.util.Map;

public class ModEventHandler {
	private static final Map<ResourceLocation, ResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	public void onRegisterAdditional(ModelEvent.RegisterAdditional event) {
		if (!FMLEnvironment.dist.isClient()) {
			return;
		}
		var resourceLocations = Minecraft.getInstance().getResourceManager().listResources("models", loc -> "legendarium".equals(loc.getNamespace()) && loc.getPath().endsWith("_large.json")).keySet();
		for (var resourceLocation : resourceLocations) {
			var itemName = resourceLocation.getPath().replace("models/item/", "").replace("_large.json", "");
			var smallResourceLocation = new ResourceLocation("legendarium", itemName);
			var largeResourceLocation = new ResourceLocation("legendarium", "item/" + itemName + "_large");
			COMPLIANCES.put(smallResourceLocation, largeResourceLocation);
			event.register(largeResourceLocation);
		}
	}

	@SubscribeEvent
	public void onModifyBakingResult(ModelEvent.ModifyBakingResult event) {
		if (!FMLEnvironment.dist.isClient()) {
			return;
		}
		var models = event.getModels();
		for (var compliance : COMPLIANCES.entrySet()) {
			var smallResourceLocation = new ModelResourceLocation(compliance.getKey(), "inventory");
			var smallBakedModel = models.get(smallResourceLocation);
			if (smallBakedModel != null) {
				var largeResourceLocation = compliance.getValue();
				var largeBakedModel = models.get(largeResourceLocation);
				if (largeBakedModel != null) {
					var epicBakedModel = new EpicBakedModel(smallBakedModel, largeBakedModel);
					models.put(smallResourceLocation, epicBakedModel);
				}
			}
		}
	}
}