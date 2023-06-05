package legendarium.content;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum LIMaterial implements IArmorMaterial {
	ANARION("anarion"), ARPHARAZON("arpharazon"), ARVEDUI("arvedui"), BOROMIR("boromir"), ELENDIL("elendil"), ELROS("elros"), FEANOR("feanor"), GILGALAD("gilgalad"), GIMLI("gimli"), ISILDUR("isildur"), JIINDUR("jiindur"), KHAMUL("khamul"), KHOMMURAT("khommurat"), MORGOMIR("morgomir"), THEODEN("theoden"), TURGON("turgon");

	public static final int[] DURABILITY_FOR_SLOT = {13, 15, 16, 11};
	public final String name;
	public final int maxDamageFactor;
	public final int[] defenceForSlot;
	public final int enchantmentValue;
	public final SoundEvent equipSound;
	public final float toughness;
	public final Ingredient repairIngredient;
	public final float knockbackResistance;

	LIMaterial(String name) {
		this(name, 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.of(Items.IRON_INGOT), 0);
	}

	LIMaterial(String name, int maxDamageFactor, int[] defenceForSlot, int enchantmentValue, SoundEvent equipSound, float toughness, Ingredient repairIngredient, int knockbackResistance) {
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
	public int getDefenseForSlot(EquipmentSlotType equipmentSlotType) {
		return defenceForSlot[equipmentSlotType.getIndex()];
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlotType equipmentSlotType) {
		return DURABILITY_FOR_SLOT[equipmentSlotType.getIndex()] * maxDamageFactor;
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
		return knockbackResistance;
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