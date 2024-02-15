package com.github.hummel.legendarium.item;

import com.github.hummel.legendarium.init.ItemGroups;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTier;

public class ItemColdWeapon extends ItemSword {
	public ItemColdWeapon() {
		super(ItemTier.DIAMOND, 3, -2.4f, new Properties().group(ItemGroups.TAB_ARTIFACTS));
	}
}