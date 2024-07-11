package com.github.hummel.legendarium.handler;

import com.github.hummel.legendarium.Main;
import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.model.EpicBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

public class ModEventHandler {
	private static final Map<ModelResourceLocation, ModelResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	@SuppressWarnings("MethodMayBeStatic")
	public void onRegisterAdditional(ModelEvent.RegisterAdditional event) {
		for (var registryObject : Items.REGISTRY.getEntries()) {
			var itemName = registryObject.get().getDescriptionId().substring("item.legendarium.".length());
			var largeJsonPath = String.format("/assets/legendarium/models/item/%s_large.json", itemName);

			try (var inputStream = Main.class.getResourceAsStream(largeJsonPath)) {
				if (inputStream != null) {
					var smallResourceName = String.format("%s", itemName);
					var largeResourceName = String.format("%s_large", itemName);

					var smallResourceLocation = new ResourceLocation("legendarium", smallResourceName);
					var largeResourceLocation = new ResourceLocation("legendarium", largeResourceName);

					var smallModelResourceLocation = new ModelResourceLocation(smallResourceLocation, "inventory");
					var largeModelResourceLocation = new ModelResourceLocation(largeResourceLocation, "inventory");

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

	@SubscribeEvent
	@SuppressWarnings("MethodMayBeStatic")
	public void onCreativeModeTabRegistry(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("legendarium", "legendarium.artifacts"), builder -> builder.title(Component.translatable("itemGroup.legendarium.artifacts")).icon(() -> new ItemStack(Items.WEAPON_FARAMIR.get())).displayItems((enabledFlags, populator) -> {
			for (var item : Items.REGISTRY.getEntries()) {
				populator.accept(item.get());
			}
		}));
	}
}