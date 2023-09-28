package legendarium.proxy;

import legendarium.model.LILargeItemModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LIClientProxy extends LICommonProxy {
	public static final Map<ResourceLocation, ResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onModelBake(ModelBakeEvent event) {
		for (Map.Entry<ResourceLocation, ResourceLocation> compliance : COMPLIANCES.entrySet()) {
			ModelResourceLocation smallLocation = new ModelResourceLocation(compliance.getKey(), "inventory");
			IBakedModel smallModel = event.getModelRegistry().get(smallLocation);
			if (smallModel != null) {
				ResourceLocation largeLocation = compliance.getValue();
				IBakedModel largeModel = event.getModelRegistry().get(largeLocation);
				if (largeModel != null) {
					event.getModelRegistry().put(smallLocation, new LILargeItemModel(smallModel, largeModel));
				}
			}
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onModelRegistry(ModelRegistryEvent event) {
		Collection<ResourceLocation> resourceLocations = Minecraft.getInstance().getResourceManager().getAllResourceLocations("models", loc -> loc.endsWith("_large.json"));
		for (ResourceLocation resourceLocation : resourceLocations) {
			String itemName = resourceLocation.getPath().replace("models/item/", "").replace("_large.json", "");
			ResourceLocation smallModel = new ResourceLocation("legendarium", itemName);
			ResourceLocation largeModel = new ResourceLocation("legendarium", "item/" + itemName + "_large");
			ModelLoader.addSpecialModel(largeModel);
			COMPLIANCES.put(smallModel, largeModel);
		}
	}
}