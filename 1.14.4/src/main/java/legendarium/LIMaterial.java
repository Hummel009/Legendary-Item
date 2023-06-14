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
	ANARION("anarion"), ARPHARAZON("arpharazon"), ARVEDUI("arvedui"), BOROMIR("boromir"), ELENDIL("elendil"), ELROS("elros"), FEANOR("feanor"), GILGALAD("gilgalad"), GIMLI("gimli"), ISILDUR("isildur"), JIINDUR("jiindur"), KHAMUL("khamul"), HOARMURATH("hoarmurath"), MORGOMIR("morgomir"), THEODEN("theoden"), TURGON("turgon");

	public static final int[] DURABILITY_FOR_SLOT = {13, 15, 16, 11};
	public final String name;
	public final int maxDamageFactor;
	public final int[] damageReductionAmount;
	public final int enchantability;
	public final SoundEvent soundEvent;
	public final float toughness;
	public final Ingredient repairMaterial;

	LIMaterial(String name) {
		this(name, 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT));
	}

	LIMaterial(String name, int maxDamageFactor, int[] damageReductionAmount, int enchantability, SoundEvent soundEvent, float toughness, Ingredient repairMaterial) {
		this.name = name;
		this.maxDamageFactor = maxDamageFactor;
		this.damageReductionAmount = damageReductionAmount;
		this.enchantability = enchantability;
		this.soundEvent = soundEvent;
		this.toughness = toughness;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
		return damageReductionAmount[equipmentSlotType.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType equipmentSlotType) {
		return DURABILITY_FOR_SLOT[equipmentSlotType.getIndex()] * maxDamageFactor;
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