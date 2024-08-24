package com.github.hummel.legendarium.init;

import net.minecraft.src.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

@SuppressWarnings("WeakerAccess")
public class Materials {
	public static final EnumToolMaterial STEEL = EnumHelper.addToolMaterial("steel", 3, 1561, 8.0f, 3, 10);

	private Materials() {
	}
}