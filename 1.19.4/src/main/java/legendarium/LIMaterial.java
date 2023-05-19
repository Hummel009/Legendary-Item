package legendarium;

import org.jetbrains.annotations.NotNull;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum LIMaterial implements ArmorMaterial {
	ANARION("anarion", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), ARPHARAZON("arpharazon", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), ARVEDUI("arvedui", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), BOROMIR("boromir", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), ELENDIL("elendil", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), ELROS("elros", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), FEANOR("feanor", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), GILGALAD("gilgalad", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), GIMLI("gimli", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), ISILDUR("isildur", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), JIINDUR("jiindur", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), KHAMUL("khamul", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), KHOMMURAT("khommurat", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), MORGOMIR("morgomir", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), THEODEN("theoden", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0), TURGON("turgon", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT), 0);

	public static final int[] DURABILITY_FOR_SLOT = {13, 15, 16, 11};
	public final String name;
	public final int maxDamageFactor;
	public final int[] defenceForSlot;
	public final int enchantmentValue;
	public final SoundEvent equipSound;
	public final float toughness;
	public final Ingredient repairIngredient;
	public final float knockbackResistance;

	LIMaterial(String name, int maxDamageFactor, int[] defenceForSlot, int enchantmentValue, SoundEvent equipSound, float toughness, Ingredient repairIngredient, float knockbackResistance) {
		this.name = name;
		this.maxDamageFactor = maxDamageFactor;
		this.defenceForSlot = defenceForSlot;
		this.enchantmentValue = enchantmentValue;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.repairIngredient = repairIngredient;
		this.knockbackResistance = knockbackResistance;
	}

	@Override
	public int getDefenseForType(Type type) {
		return defenceForSlot[type.getSlot().getIndex()];
	}

	@Override
	public int getDurabilityForType(Type type) {
		return DURABILITY_FOR_SLOT[type.getSlot().getIndex()] * maxDamageFactor;
	}

	@Override
	public int getEnchantmentValue() {
		return enchantmentValue;
	}

	@Override
	public @NotNull SoundEvent getEquipSound() {
		return equipSound;
	}

	@Override
	public float getKnockbackResistance() {
		return knockbackResistance;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public @NotNull String getName() {
		return name;
	}

	@Override
	public @NotNull Ingredient getRepairIngredient() {
		return repairIngredient;
	}

	@Override
	public float getToughness() {
		return toughness;
	}
}