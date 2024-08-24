package com.github.hummel.legendarium.item;

import com.github.hummel.legendarium.material.ToolMaterials;
import net.minecraft.world.item.SwordItem;

public class ItemColdWeapon extends SwordItem {
	public ItemColdWeapon() {
		super(ToolMaterials.STEEL, new Properties().attributes(createAttributes(ToolMaterials.STEEL, 3, -2.4f)));
	}
}