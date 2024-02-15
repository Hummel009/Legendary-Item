package com.github.hummel.legendarium.item;

import com.github.hummel.legendarium.init.ItemGroups;
import net.minecraft.item.ItemSword;

public class ItemColdWeapon extends ItemSword {
	public ItemColdWeapon() {
		super(ToolMaterial.EMERALD);
		setCreativeTab(ItemGroups.TAB_ARTIFACTS);
	}
}