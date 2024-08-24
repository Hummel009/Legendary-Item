package com.github.hummel.legendarium.item;

import com.github.hummel.legendarium.init.ItemGroups;
import com.github.hummel.legendarium.init.Materials;
import net.minecraft.src.ItemSword;

public class ItemColdWeapon extends ItemSword {
	public ItemColdWeapon(int id) {
		super(id, Materials.STEEL);
		setCreativeTab(ItemGroups.TAB_ARTIFACTS);
	}
}