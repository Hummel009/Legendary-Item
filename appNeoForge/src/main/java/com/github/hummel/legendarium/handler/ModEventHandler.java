package com.github.hummel.legendarium.handler;

import com.github.hummel.legendarium.Main;
import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.model.EpicBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ModelEvent;

import java.util.HashMap;
import java.util.Map;

public class ModEventHandler {
	private static final Map<ModelResourceLocation, ModelResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	@SuppressWarnings("MethodMayBeStatic")
	public void onRegisterAdditional(ModelEvent.RegisterAdditional event) {
		for (var deferredHolder : Items.REGISTRY.getEntries()) {
			var itemName = deferredHolder.get().getDescriptionId().substring("item.legendarium.".length());
			var largeJsonPath = String.format("/assets/legendarium/models/item/%s_large.json", itemName);

			try (var inputStream = Main.class.getResourceAsStream(largeJsonPath)) {
				if (inputStream != null) {
					var smallResourceName = String.format("%s", itemName);
					var largeResourceName = String.format("item/%s_large", itemName);

					var smallResourceLocation = ResourceLocation.fromNamespaceAndPath("legendarium", smallResourceName);
					var largeResourceLocation = ResourceLocation.fromNamespaceAndPath("legendarium", largeResourceName);

					var smallModelResourceLocation = new ModelResourceLocation(smallResourceLocation, "inventory");
					var largeModelResourceLocation = new ModelResourceLocation(largeResourceLocation, "standalone");

					COMPLIANCES.put(smallModelResourceLocation, largeModelResourceLocation);

					event.register(largeModelResourceLocation);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	@SuppressWarnings("MethodMayBeStatic")
	public void onModifyBakingResult(ModelEvent.ModifyBakingResult event) {
		var models = event.getModels();
		for (var compliance : COMPLIANCES.entrySet()) {
			var smallModelResourceLocation = compliance.getKey();
			var smallBakedModel = models.get(smallModelResourceLocation);
			if (smallBakedModel != null) {
				var largeModelResourceLocation = compliance.getValue();
				var largeBakedModel = models.get(largeModelResourceLocation);
				if (largeBakedModel != null) {
					var epicBakedModel = new EpicBakedModel(smallBakedModel, largeBakedModel);
					models.put(smallModelResourceLocation, epicBakedModel);
				}
			}
		}
	}
}