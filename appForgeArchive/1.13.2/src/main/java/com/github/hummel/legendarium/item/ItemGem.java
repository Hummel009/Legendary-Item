package com.github.hummel.legendarium.item;

import com.github.hummel.legendarium.init.ItemGroups;
import net.minecraft.item.Item;

public class ItemGem extends Item {
	public ItemGem() {
		super(new Properties().maxStackSize(1).group(ItemGroups.TAB_ARTIFACTS));
	}
}