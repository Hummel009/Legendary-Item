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
	ANARION("anarion", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), ARPHARAZON("arpharazon", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), ARVEDUI("arvedui", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), BOROMIR("boromir", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), ELENDIL("elendil", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), ELROS("elros", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), FEANOR("feanor", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), GILGALAD("gilgalad", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), GIMLI("gimli", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), ISILDUR("isildur", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), JIINDUR("jiindur", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), KHAMUL("khamul", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), KHOMMURAT("khommurat", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), MORGOMIR("morgomir", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), THEODEN("theoden", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT)), TURGON("turgon", 25, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.fromItems(Items.IRON_INGOT));

	public static final int[] DURABILITY = {13, 15, 16, 11};
	public final String name;
	public final int maxDamageFactor;
	public final int[] damageReductionAmount;
	public final int enchantability;
	public final SoundEvent soundEvent;
	public final float toughness;
	public final Ingredient repairMaterial;

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
		return DURABILITY[equipmentSlotType.getIndex()] * maxDamageFactor;
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