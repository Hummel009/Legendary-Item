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
	public int getDurabilityForType(Type p_266807_) {
		return MAX_DAMAGE_ARRAY[p_266807_.getSlot().getIndex()] * maxDamageFactor;
	}

	@Override
	public int getDefenseForType(Type p_267168_) {
		return damageReductionAmount[p_267168_.getSlot().getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return enchantability;
	}

	@Override
	public @NotNull SoundEvent getEquipSound() {
		return soundEvent;
	}

	@Override
	public float getKnockbackResistance() {
		return 0;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public @NotNull String getName() {
		return name;
	}

	@Override
	public @NotNull Ingredient getRepairIngredient() {
		return repairMaterial;
	}

	@Override
	public float getToughness() {
		return toughness;
	}
}