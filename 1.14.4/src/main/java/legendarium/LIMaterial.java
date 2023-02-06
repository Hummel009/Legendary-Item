package legendarium;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

public enum LIMaterial implements IArmorMaterial {
	ANARION("anarion", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), ARPHARAZON("arpharazon", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), ARVEDUI("arvedui", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), BOROMIR("boromir", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), ELENDIL("elendil", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), ELROS("elros", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), FEANOR("feanor", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), GILGALAD("gilgalad", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), GIMLI("gimli", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), ISILDUR("isildur", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), JIINDUR("jiindur", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), KHAMUL("khamul", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), KHOMMURAT("khommurat", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), MORGOMIR("morgomir", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), THEODEN("theoden", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT)), TURGON("turgon", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.fromItems(Items.IRON_INGOT));

	public static int[] MAX_DAMAGE_ARRAY = { 13, 15, 16, 11 };
	public String name;
	public int maxDamageFactor;
	public int[] damageReductionAmount;
	public int enchantability;
	public SoundEvent soundEvent;
	public float toughness;
	public Ingredient repairMaterial;

	LIMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchIn, SoundEvent equipSoundIn, float toughnessIn, Ingredient repMaterial) {
		name = nameIn;
		maxDamageFactor = maxDamageFactorIn;
		damageReductionAmount = damageReductionAmountsIn;
		enchantability = enchIn;
		soundEvent = equipSoundIn;
		toughness = toughnessIn;
		repairMaterial = repMaterial;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return damageReductionAmount[slotIn.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * maxDamageFactor;
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return repairMaterial;
	}

	@Override
	public SoundEvent getSoundEvent() {
		return soundEvent;
	}

	@Override
	public float getToughness() {
		return toughness;
	}
}