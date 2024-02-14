package legendarium.handler;

import legendarium.model.EpicBakedModel;
import net.minecraft.client.Minecraft;
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
	private static final Map<ResourceLocation, ResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onModelRegistry(ModelRegistryEvent event) {
		var resourceLocations = Minecraft.getInstance().getResourceManager().listResources("models", loc -> loc.endsWith("_large.json"));
		for (var resourceLocation : resourceLocations) {
			var itemName = resourceLocation.getPath().replace("models/item/", "").replace("_large.json", "");
			var smallResourceLocation = new ResourceLocation("legendarium", itemName);
			var largeResourceLocation = new ResourceLocation("legendarium", "item/" + itemName + "_large");
			COMPLIANCES.put(smallResourceLocation, largeResourceLocation);
			ForgeModelBakery.addSpecialModel(largeResourceLocation);
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onModelBake(ModelBakeEvent event) {
		var modelRegistry = event.getModelRegistry();
		for (var compliance : COMPLIANCES.entrySet()) {
			var smallResourceLocation = new ModelResourceLocation(compliance.getKey(), "inventory");
			var smallBakedModel = modelRegistry.get(smallResourceLocation);
			if (smallBakedModel != null) {
				var largeResourceLocation = compliance.getValue();
				var largeBakedModel = modelRegistry.get(largeResourceLocation);
				if (largeBakedModel != null) {
					var epicBakedModel = new EpicBakedModel(smallBakedModel, largeBakedModel);
					modelRegistry.put(smallResourceLocation, epicBakedModel);
				}
			}
		}
	}
}