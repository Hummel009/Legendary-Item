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
	ANARION("anarion", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ARPHARAZON("arpharazon", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ARVEDUI("arvedui", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), BOROMIR("boromir", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ELENDIL("elendil", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ELROS("elros", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), FEANOR("feanor", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), GILGALAD("gilgalad", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), GIMLI("gimli", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ISILDUR("isildur", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), JIINDUR("jiindur", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), KHAMUL("khamul", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), KHOMMURAT("khommurat", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), MORGOMIR("morgomir", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), THEODEN("theoden", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), TURGON("turgon", 25, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT));

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
	public int getDefenseForSlot(EquipmentSlot p_200902_1_) {
		return damageReductionAmount[p_200902_1_.getIndex()];
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlot p_200896_1_) {
		return MAX_DAMAGE_ARRAY[p_200896_1_.getIndex()] * maxDamageFactor;
	}

	@Override
	public int getEnchantmentValue() {
		return enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return soundEvent;
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
		return repairMaterial;
	}

	@Override
	public float getToughness() {
		return toughness;
	}
}