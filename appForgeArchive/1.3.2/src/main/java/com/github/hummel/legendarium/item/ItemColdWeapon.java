package com.github.hummel.legendarium.item;

import com.github.hummel.legendarium.init.ItemGroups;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemSword;

public class ItemColdWeapon extends ItemSword {
	public ItemColdWeapon(int id) {
		super(id, EnumToolMaterial.EMERALD);
		setCreativeTab(ItemGroups.TAB_ARTIFACTS);
	}
}