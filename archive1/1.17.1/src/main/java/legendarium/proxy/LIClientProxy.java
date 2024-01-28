package legendarium.proxy;

import legendarium.model.LILargeItemModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

public class LIClientProxy extends LICommonProxy {
	private static final Map<ResourceLocation, ResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onModelBake(ModelBakeEvent event) {
		for (var compliance : COMPLIANCES.entrySet()) {
			var smallLocation = new ModelResourceLocation(compliance.getKey(), "inventory");
			var smallModel = event.getModelRegistry().get(smallLocation);
			if (smallModel != null) {
				var largeLocation = compliance.getValue();
				var largeModel = event.getModelRegistry().get(largeLocation);
				if (largeModel != null) {
					event.getModelRegistry().put(smallLocation, new LILargeItemModel(smallModel, largeModel));
				}
			}
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onModelRegistry(ModelRegistryEvent event) {
		var resourceLocations = Minecraft.getInstance().getResourceManager().listResources("models", loc -> loc.endsWith("_large.json"));
		for (var resourceLocation : resourceLocations) {
			var itemName = resourceLocation.getPath().replace("models/item/", "").replace("_large.json", "");
			var smallModel = new ResourceLocation("legendarium", itemName);
			var largeModel = new ResourceLocation("legendarium", "item/" + itemName + "_large");
			ModelLoader.addSpecialModel(largeModel);
			COMPLIANCES.put(smallModel, largeModel);
		}
	}
}