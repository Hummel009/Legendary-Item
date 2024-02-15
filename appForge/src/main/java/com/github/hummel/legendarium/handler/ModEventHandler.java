package com.github.hummel.legendarium.handler;

import com.github.hummel.legendarium.model.EpicBakedModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

public class ModEventHandler {
	private static final Map<ResourceLocation, ResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onRegisterAdditional(ModelEvent.RegisterAdditional event) {
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
	@OnlyIn(Dist.CLIENT)
	public void onModifyBakingResult(ModelEvent.ModifyBakingResult event) {
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