package legendarium.handler;

import legendarium.model.EpicBakedModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ModEventHandler {
	private static final Map<ResourceLocation, ResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	public void onRegisterAdditional(ModelRegistryEvent event) {
		Collection<ResourceLocation> resourceLocations = Minecraft.getInstance().getResourceManager().listResources("models", loc -> loc.endsWith("_large.json"));
		for (ResourceLocation resourceLocation : resourceLocations) {
			String itemName = resourceLocation.getPath().replace("models/item/", "").replace("_large.json", "");
			ResourceLocation smallResourceLocation = new ResourceLocation("legendarium", itemName);
			ResourceLocation largeResourceLocation = new ResourceLocation("legendarium", "item/" + itemName + "_large");
			COMPLIANCES.put(smallResourceLocation, largeResourceLocation);
			ModelLoader.addSpecialModel(largeResourceLocation);
		}
	}

	@SubscribeEvent
	public void onModifyBakingResult(ModelBakeEvent event) {
		Map<ResourceLocation, IBakedModel> modelRegistry = event.getModelRegistry();
		for (Map.Entry<ResourceLocation, ResourceLocation> compliance : COMPLIANCES.entrySet()) {
			ModelResourceLocation smallResourceLocation = new ModelResourceLocation(compliance.getKey(), "inventory");
			IBakedModel smallBakedModel = modelRegistry.get(smallResourceLocation);
			if (smallBakedModel != null) {
				ResourceLocation largeResourceLocation = compliance.getValue();
				IBakedModel largeBakedModel = modelRegistry.get(largeResourceLocation);
				if (largeBakedModel != null) {
					IBakedModel epicBakedModel = new EpicBakedModel(smallBakedModel, largeBakedModel);
					modelRegistry.put(smallResourceLocation, epicBakedModel);
				}
			}
		}
	}
}