package com.github.hummel.legendarium;

import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.model.EpicBakedModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class MainClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModelLoadingPlugin.register(pluginContext -> {
			Map<ModelResourceLocation, ModelResourceLocation> compliances = new HashMap<>();

			for (var item : Items.CONTENT) {
				var itemName = item.getDescriptionId().substring("item.legendarium.".length());
				var largeJsonPath = String.format("/assets/legendarium/models/item/%s_large.json", itemName);

				try (var inputStream = Main.class.getResourceAsStream(largeJsonPath)) {
					if (inputStream != null) {
						var smallResourceName = String.format("%s", itemName);
						var largeResourceName = String.format("item/%s_large", itemName);

						var smallResourceLocation = ResourceLocation.fromNamespaceAndPath("legendarium", smallResourceName);
						var largeResourceLocation = ResourceLocation.fromNamespaceAndPath("legendarium", largeResourceName);

						var smallModelResourceLocation = new ModelResourceLocation(smallResourceLocation, "inventory");
						var largeModelResourceLocation = new ModelResourceLocation(largeResourceLocation, "standalone");

						compliances.put(smallModelResourceLocation, largeModelResourceLocation);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			for (var modelResourceLocation : compliances.values()) {
				pluginContext.addModels(modelResourceLocation.id());
			}

			pluginContext.modifyModelAfterBake().register((smallBakedModel, bakeContext) -> {
				for (var compliance : compliances.entrySet()) {
					var smallModelResourceLocation = compliance.getKey();
					if (smallModelResourceLocation.equals(bakeContext.topLevelId())) {
						var largeModelResourceLocation = compliance.getValue();
						var largeBakedModel = bakeContext.baker().bake(largeModelResourceLocation.id(), bakeContext.settings());
						if (largeBakedModel != null) {
							return new EpicBakedModel(smallBakedModel, largeBakedModel);
						}
					}
				}
				return smallBakedModel;
			});
		});
	}
}