package legendarium;

import java.lang.reflect.*;

import lotr.common.LOTRCreativeTabs;
import lotr.common.item.*;
import net.minecraft.entity.*;
import net.minecraft.init.Items;
import net.minecraft.item.*;

public class LegendariumArmor extends LOTRItemArmor {
	public static LOTRMaterial ANARION = LegendariumArmor.newLOTRMaterial("ANARION", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial ARPHARAZON = LegendariumArmor.newLOTRMaterial("ARPHARAZON", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial ARVEDUI = LegendariumArmor.newLOTRMaterial("ARVEDUI", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial BOROMIR = LegendariumArmor.newLOTRMaterial("BOROMIR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial ELENDIL = LegendariumArmor.newLOTRMaterial("ELENDIL", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial ELROS = LegendariumArmor.newLOTRMaterial("ELROS", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial FEANOR = LegendariumArmor.newLOTRMaterial("FEANOR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial GILGALAD = LegendariumArmor.newLOTRMaterial("GILGALAD", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial GIMLI = LegendariumArmor.newLOTRMaterial("GIMLI", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial ISILDUR = LegendariumArmor.newLOTRMaterial("ISILDUR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial JIINDUR = LegendariumArmor.newLOTRMaterial("JIINDUR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial KHAMUL = LegendariumArmor.newLOTRMaterial("KHAMUL", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial KHOMMURAT = LegendariumArmor.newLOTRMaterial("KHOMMURAT", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial MORGOMIR = LegendariumArmor.newLOTRMaterial("MORGOMIR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial THEODEN = LegendariumArmor.newLOTRMaterial("THEODEN", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial TURGON = LegendariumArmor.newLOTRMaterial("TURGON", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	private static boolean setup = false;
	private static Constructor<LOTRMaterial> constructor;
	private static Method setUses;
	private static Method setDamage;
	private static Method setProtection;
	private static Method setSpeed;
	private static Method setHarvestLevel;
	private static Method setEnchantibility;
	private static Method setCraftingMaterial;
	private static Method setUndamageable;
	private static Method setManFlesh;

	public LegendariumArmor(LOTRMaterial material, int slotType) {
		super(material, slotType);
		setCreativeTab(LOTRCreativeTabs.tabStory);
	}

	public LegendariumArmor(LOTRMaterial material, int slotType, String textureSuffix) {
		super(material, slotType, textureSuffix);
	}

	private static LOTRMaterial editLOTRMaterial(LOTRMaterial material, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterialTool, Item craftingMaterialArmor, boolean manFlesh, boolean undamageable) {
		LegendariumArmor.setup();
		try {
			if (uses != -1) {
				setUses.invoke((Object) material, uses);
			}
			if (damage != -1.0f) {
				setDamage.invoke((Object) material, Float.valueOf(damage));
			}
			if (protection != -1.0f) {
				setProtection.invoke((Object) material, Float.valueOf(protection));
			}
			if (speed != -1.0f) {
				setSpeed.invoke((Object) material, Float.valueOf(speed));
			}
			if (harvestLevel != -1) {
				setHarvestLevel.invoke((Object) material, harvestLevel);
			}
			if (enchantability != -1) {
				setEnchantibility.invoke((Object) material, enchantability);
			}
			if (craftingMaterialTool != null && craftingMaterialArmor != null) {
				setCraftingMaterial.invoke((Object) material, craftingMaterialTool, craftingMaterialArmor);
			}
			if (undamageable) {
				setUndamageable.invoke((Object) material);
			}
			if (manFlesh) {
				setManFlesh.invoke((Object) material);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

		}
		return material;
	}

	public static ItemArmor.ArmorMaterial getFullArmorMaterial(EntityLivingBase entity) {
		ItemArmor.ArmorMaterial material = null;
		for (int i = 1; i <= 4; ++i) {
			ItemStack item = entity.getEquipmentInSlot(i);
			if (item == null || !(item.getItem() instanceof ItemArmor)) {
				return null;
			}
			ItemArmor.ArmorMaterial itemMaterial = ((ItemArmor) item.getItem()).getArmorMaterial();
			if (material != null && itemMaterial != material) {
				return null;
			}
			material = itemMaterial;
		}
		return material;
	}

	private static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterial) {
		return LegendariumArmor.newLOTRMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterial, false);
	}

	private static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterial, boolean manFlesh) {
		return LegendariumArmor.newLOTRMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterial, craftingMaterial, manFlesh, false);
	}

	private static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterialTool, Item craftingMaterialArmor, boolean manFlesh, boolean undamageable) {
		LegendariumArmor.setup();
		LOTRMaterial material = null;
		try {
			material = constructor.newInstance(name);
		} catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException e) {

		}
		return LegendariumArmor.editLOTRMaterial(material, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterialTool, craftingMaterialArmor, manFlesh, undamageable);
	}

	private static void setExistingCraftingItem(LOTRMaterial material, ItemStack toolItem, Item armorItem) {
		LegendariumCommander.setToolMaterialRepairItem(material.toToolMaterial(), toolItem);
		material.toArmorMaterial().customCraftingMaterial = armorItem;
	}

	private static void setup() {
		if (setup) {
			return;
		}
		try {
			Class<LOTRMaterial> clazz = LOTRMaterial.class;
			constructor = clazz.getDeclaredConstructor(String.class);
			constructor.setAccessible(true);
			setUses = clazz.getDeclaredMethod("setUses", Integer.TYPE);
			setUses.setAccessible(true);
			setDamage = clazz.getDeclaredMethod("setDamage", Float.TYPE);
			setDamage.setAccessible(true);
			setProtection = clazz.getDeclaredMethod("setProtection", Float.TYPE);
			setProtection.setAccessible(true);
			setSpeed = clazz.getDeclaredMethod("setSpeed", Float.TYPE);
			setSpeed.setAccessible(true);
			setHarvestLevel = clazz.getDeclaredMethod("setHarvestLevel", Integer.TYPE);
			setHarvestLevel.setAccessible(true);
			setEnchantibility = clazz.getDeclaredMethod("setEnchantability", Integer.TYPE);
			setEnchantibility.setAccessible(true);
			setCraftingMaterial = clazz.getDeclaredMethod("setCraftingItems", Item.class, Item.class);
			setCraftingMaterial.setAccessible(true);
			setUndamageable = clazz.getDeclaredMethod("setUndamageable");
			setUndamageable.setAccessible(true);
			setManFlesh = clazz.getDeclaredMethod("setManFlesh");
			setManFlesh.setAccessible(true);
			setup = true;
		} catch (NoSuchMethodException | SecurityException e) {

		}
	}

	public static void onInit() {
		LegendariumCommander.setMaterialCraftingItem(ANARION, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(ARPHARAZON, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(ARVEDUI, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(BOROMIR, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(ELENDIL, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(ELROS, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(FEANOR, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(GILGALAD, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(GIMLI, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(ISILDUR, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(JIINDUR, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(KHAMUL, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(KHOMMURAT, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(MORGOMIR, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(THEODEN, Items.iron_ingot, Items.leather);
		LegendariumCommander.setMaterialCraftingItem(TURGON, Items.iron_ingot, Items.leather);
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		StringBuilder texture = new StringBuilder("legendarium:armor/").append(LegendariumCommander.getArmorName(this));
		if (type != null) {
			texture.append("_").append(type);
		}
		return texture.append(".png").toString();
	}
}
