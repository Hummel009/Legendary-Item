package com.github.hummel.legendarium.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ItemGroups {
	public static final CreativeModeTab TAB_ARTIFACTS = new CreativeModeTab("com.github.hummel.legendarium.artifacts") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.WEAPON_FARAMIR.get());
		}
	};

	private ItemGroups() {
	}
}