package com.github.hummel.legendarium.item;

import com.github.hummel.legendarium.init.ItemGroups;
import net.minecraft.world.item.Item;

public class ItemGem extends Item {
	public ItemGem() {
		super(new Properties().stacksTo(1).tab(ItemGroups.TAB_ARTIFACTS));
	}
}