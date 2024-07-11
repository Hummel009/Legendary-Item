package com.github.hummel.legendarium.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("WeakerAccess")
public class ItemGroups {
	public static final CreativeModeTab TAB_ARTIFACTS = FabricItemGroup.builder().icon(() -> new ItemStack(Items.WEAPON_FARAMIR)).title(Component.translatable("itemGroup.legendarium.artifacts")).displayItems((context, populator) -> {
		for (var item : Items.CONTENT) {
			populator.accept(item);
		}
	}).build();

	private ItemGroups() {
	}

	public static void register() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation("legendarium", "artifacts"), TAB_ARTIFACTS);
	}
}