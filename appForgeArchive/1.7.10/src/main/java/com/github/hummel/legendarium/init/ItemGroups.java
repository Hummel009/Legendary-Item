package com.github.hummel.legendarium.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemGroups {
	public static final CreativeTabs TAB_ARTIFACTS = new CreativeTabs("legendarium.artifacts") {
		@Override
		public Item getTabIconItem() {
			return Items.weaponFaramir;
		}
	};

	private ItemGroups() {
	}
}