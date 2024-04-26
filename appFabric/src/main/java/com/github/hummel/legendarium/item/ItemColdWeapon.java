package com.github.hummel.legendarium.item;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class ItemColdWeapon extends SwordItem {
	public ItemColdWeapon() {
		super(Tiers.DIAMOND, new Properties().attributes(createAttributes(Tiers.DIAMOND, 3, -2.4F)));
	}
}