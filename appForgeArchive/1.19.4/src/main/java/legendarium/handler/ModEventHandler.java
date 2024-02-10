package legendarium.handler;

import legendarium.init.Items;
import legendarium.model.EpicBakedModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

public class ModEventHandler {
	private static final Map<ResourceLocation, ResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
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

	@SubscribeEvent
	public void onCreativeModeTabRegistry(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("legendarium", "legendarium.artifacts"), builder -> builder.title(Component.translatable("itemGroup.legendarium.artifacts")).icon(() -> new ItemStack(Items.WEAPON_FARAMIR.get())).displayItems((enabledFlags, populator) -> {
			for (var item : Items.CONTENT) {
				populator.accept(item);
			}
		}));
	}
}