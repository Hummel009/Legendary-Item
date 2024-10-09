package com.github.hummel.legendarium.init;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

@SuppressWarnings("WeakerAccess")
public class Materials {
	public static final Item.ToolMaterial STEEL;

	private Materials() {
	}

	static {
		STEEL = EnumHelper.addToolMaterial("steel", 3, 1561, 8.0f, 3.0f, 10);
		STEEL.setRepairItem(new ItemStack(Items.IRON_INGOT));
	}
}