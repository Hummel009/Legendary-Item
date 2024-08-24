package com.github.hummel.legendarium.item;

import com.github.hummel.legendarium.init.ItemGroups;
import com.github.hummel.legendarium.material.ToolMaterials;
import net.minecraft.item.ItemSword;

public class ItemColdWeapon extends ItemSword {
	public ItemColdWeapon() {
		super(ToolMaterials.STEEL, 3, -2.4f, new Properties().group(ItemGroups.TAB_ARTIFACTS));
	}
}