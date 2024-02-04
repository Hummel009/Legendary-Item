package legendarium.proxy;

import legendarium.model.LILargeItemModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class LIClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModelLoadingPlugin.register(pluginContext -> {
			Map<ResourceLocation, ResourceLocation> compliances = new HashMap<>();

			var resourceLocations = Minecraft.getInstance().getResourceManager().listResources("models", loc -> "legendarium".equals(loc.getNamespace()) && loc.getPath().endsWith("_large.json")).keySet();
			for (var resourceLocation : resourceLocations) {
				var itemName = resourceLocation.getPath().replace("models/item/", "").replace("_large.json", "");
				var smallResourceLocation = new ResourceLocation("legendarium", itemName);
				var largeResourceLocation = new ResourceLocation("legendarium", "item/" + itemName + "_large");
				compliances.put(smallResourceLocation, largeResourceLocation);
			}

			pluginContext.addModels(compliances.values());

			pluginContext.modifyModelAfterBake().register((original, bakeContext) -> {
				for (var compliance : compliances.entrySet()) {
					var smallResourceLocation = compliance.getKey();
					var largeResourceLocation = compliance.getValue();

					if (bakeContext.id().getPath().equals(smallResourceLocation.getPath())) {
						var largeBakedModel = bakeContext.baker().bake(largeResourceLocation, bakeContext.settings());
						return new LILargeItemModel(original, largeBakedModel);
					}
				}
				return original;
			});
		});
	}
}