package com.github.hummel.legendarium.material;

import net.minecraft.init.Items;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterials implements IItemTier {
	STEEL(3, 1561, 8.0f, 3.0f, 10, Ingredient.fromItems(Items.IRON_INGOT));

	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final Ingredient repairMaterial;

	ToolMaterials(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Ingredient repairMaterial) {
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public float getAttackDamage() {
		return attackDamage;
	}

	@Override
	public float getEfficiency() {
		return efficiency;
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public int getHarvestLevel() {
		return harvestLevel;
	}

	@Override
	public int getMaxUses() {
		return maxUses;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return repairMaterial;
	}
}