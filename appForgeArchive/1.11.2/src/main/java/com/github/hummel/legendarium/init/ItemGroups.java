package com.github.hummel.legendarium.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ItemGroups {
	public static final CreativeTabs TAB_ARTIFACTS = new CreativeTabs("legendarium.artifacts") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.weaponFaramir);
		}
	};

	private ItemGroups() {
	}
}