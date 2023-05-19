package legendarium;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum LIMaterial implements ArmorMaterial {
	ANARION("anarion", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ARPHARAZON("arpharazon", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ARVEDUI("arvedui", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), BOROMIR("boromir", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ELENDIL("elendil", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ELROS("elros", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), FEANOR("feanor", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), GILGALAD("gilgalad", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), GIMLI("gimli", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ISILDUR("isildur", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), JIINDUR("jiindur", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), KHAMUL("khamul", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), KHOMMURAT("khommurat", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), MORGOMIR("morgomir", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), THEODEN("theoden", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), TURGON("turgon", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT));

	public static final int[] DURABILITY_FOR_SLOT = {13, 15, 16, 11};
	public final String name;
	public final int maxDamageFactor;
	public final int[] defenceForSlot;
	public final int enchantmentValue;
	public final SoundEvent equipSound;
	public final float toughness;
	public final Ingredient repairIngredient;

	LIMaterial(String name, int maxDamageFactor, int[] defenceForSlot, int enchantmentValue, SoundEvent equipSound, float toughness, Ingredient repairIngredient) {
		this.name = name;
		this.maxDamageFactor = maxDamageFactor;
		this.defenceForSlot = defenceForSlot;
		this.enchantmentValue = enchantmentValue;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.repairIngredient = repairIngredient;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot equipmentSlot) {
		return defenceForSlot[equipmentSlot.getIndex()];
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlot equipmentSlot) {
		return DURABILITY_FOR_SLOT[equipmentSlot.getIndex()] * maxDamageFactor;
	}

	@Override
	public int getEnchantmentValue() {
		return enchantmentValue;
	}

	@Override
	public SoundEvent getEquipSound() {
		return equipSound;
	}

	@Override
	public float getKnockbackResistance() {
		return 0;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return repairIngredient;
	}

	@Override
	public float getToughness() {
		return toughness;
	}
}