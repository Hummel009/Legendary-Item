package com.github.hummel.legendarium.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroups {
	public static final ItemGroup TAB_ARTIFACTS = new ItemGroup("legendarium.artifacts") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.WEAPON_FARAMIR.get());
		}
	};

	private ItemGroups() {
	}
}