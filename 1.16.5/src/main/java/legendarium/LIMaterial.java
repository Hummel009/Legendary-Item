package legendarium;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum LIMaterial implements IArmorMaterial {
	ANARION("anarion", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ARPHARAZON("arpharazon", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ARVEDUI("arvedui", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), BOROMIR("boromir", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ELENDIL("elendil", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ELROS("elros", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), FEANOR("feanor", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), GILGALAD("gilgalad", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), GIMLI("gimli", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), ISILDUR("isildur", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), JIINDUR("jiindur", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), KHAMUL("khamul", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), KHOMMURAT("khommurat", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), MORGOMIR("morgomir", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), THEODEN("theoden", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT)), TURGON("turgon", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, Ingredient.of(Items.IRON_INGOT));

	public static final int[] MAX_DAMAGE_ARRAY = {13, 15, 16, 11};
	public final String name;
	public final int maxDamageFactor;
	public final int[] damageReductionAmount;
	public final int enchantability;
	public final SoundEvent soundEvent;
	public final float toughness;
	public final Ingredient repairMaterial;

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
	public int getDefenseForSlot(EquipmentSlotType p_200902_1_) {
		return damageReductionAmount[p_200902_1_.getIndex()];
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlotType p_200896_1_) {
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