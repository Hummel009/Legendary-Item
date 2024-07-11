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
			Map<ResourceLocation, ResourceLocation> compliances = new HashMap<>();

			for (var item : Items.CONTENT) {
				var itemName = item.getDescriptionId().substring("item.legendarium.".length());
				var largeJsonPath = String.format("/assets/legendarium/models/item/%s_large.json", itemName);

				try (var inputStream = Main.class.getResourceAsStream(largeJsonPath)) {
					if (inputStream != null) {
						var smallResourceName = String.format("legendarium:%s", itemName);
						var largeResourceName = String.format("legendarium:%s_large", itemName);

						var smallResourceLocation = new ResourceLocation(smallResourceName);
						var largeResourceLocation = new ResourceLocation(largeResourceName);

						var smallModelResourceLocation = new ModelResourceLocation(smallResourceLocation, "inventory");
						var largeModelResourceLocation = new ModelResourceLocation(largeResourceLocation, "inventory");

						compliances.put(smallModelResourceLocation, largeModelResourceLocation);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			pluginContext.addModels(compliances.values());

			pluginContext.modifyModelAfterBake().register((smallBakedModel, bakeContext) -> {
				for (var compliance : compliances.entrySet()) {
					var smallModelResourceLocation = compliance.getKey();
					if (bakeContext.id().equals(smallModelResourceLocation)) {
						var largeModelResourceLocation = compliance.getValue();
						var largeBakedModel = bakeContext.baker().bake(largeModelResourceLocation, bakeContext.settings());
						if (largeBakedModel != null) {
							var epicBakedModel = new EpicBakedModel(smallBakedModel, largeBakedModel);
							return new EpicBakedModel(smallBakedModel, epicBakedModel);
						}
					}
				}
				return smallBakedModel;
			});
		});
	}
}