package com.github.hummel.legendarium.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroups {
	public static final ItemGroup TAB_ARTIFACTS = new ItemGroup("com.github.hummel.legendarium.artifacts") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(Items.weaponFaramir);
		}
	};

	private ItemGroups() {
	}
}