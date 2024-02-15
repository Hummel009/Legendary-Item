package com.github.hummel.legendarium.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("WeakerAccess")
public class ItemGroups {
	private static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, "legendarium");

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB_ARTIFACTS = CREATIVE_TABS.register("artifacts", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.legendarium.artifacts")).icon(() -> new ItemStack(Items.WEAPON_FARAMIR.get())).displayItems((enabledFlags, populator) -> {
		for (var item : Items.CONTENT) {
			populator.accept(item);
		}
	}).build());

	private ItemGroups() {
	}

	public static void register(IEventBus modEventBus) {
		CREATIVE_TABS.register(modEventBus);
	}
}