package legendarium.content;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum LIMaterial implements ArmorMaterial {
	ANARION("anarion"), ARPHARAZON("arpharazon"), ARVEDUI("arvedui"), BOROMIR("boromir"), ELENDIL("elendil"), ELROS("elros"), FEANOR("feanor"), GILGALAD("gilgalad"), GIMLI("gimli"), ISILDUR("isildur"), JIINDUR("jiindur"), KHAMUL("khamul"), HOARMURATH("hoarmurath"), MORGOMIR("morgomir"), THEODEN("theoden"), TURGON("turgon");

	public static final int[] DURABILITY_FOR_SLOT = {13, 15, 16, 11};
	private final String name;
	private final int maxDamageFactor;
	private final int[] defenceForSlot;
	private final int enchantmentValue;
	private final SoundEvent equipSound;
	private final float toughness;
	private final Ingredient repairIngredient;
	private final float knockbackResistance;

	LIMaterial(String name) {
		this(name, 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, Ingredient.of(Items.IRON_INGOT), 0);
	}

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