package com.github.hummel.legendarium.item;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class ItemColdWeapon extends SwordItem {
	public ItemColdWeapon() {
		super(Tiers.DIAMOND, 3, -2.4f, new Properties());
	}
}