package com.github.hummel.legendarium.init;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;

@SuppressWarnings("WeakerAccess")
public class Materials {
	public static final EnumToolMaterial STEEL;

	private Materials() {
	}

	static {
		STEEL = EnumHelper.addToolMaterial("steel", 3, 1561, 8.0f, 3.0f, 10);
		STEEL.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
	}
}