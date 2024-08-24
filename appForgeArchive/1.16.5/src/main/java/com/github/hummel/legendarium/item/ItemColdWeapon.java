package com.github.hummel.legendarium.item;

import com.github.hummel.legendarium.init.ItemGroups;
import com.github.hummel.legendarium.material.ToolMaterials;
import net.minecraft.item.SwordItem;

public class ItemColdWeapon extends SwordItem {
	public ItemColdWeapon() {
		super(ToolMaterials.STEEL, 3, -2.4f, new Properties().tab(ItemGroups.TAB_ARTIFACTS));
	}
}