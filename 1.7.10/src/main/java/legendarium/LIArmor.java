package legendarium;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import cpw.mods.fml.relauncher.ReflectionHelper;
import lotr.common.LOTRCreativeTabs;
import lotr.common.item.LOTRItemArmor;
import lotr.common.item.LOTRMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LIArmor extends LOTRItemArmor {
	public static boolean setup;
	public static Constructor<LOTRMaterial> constructor;
	public static final LOTRMaterial ANARION = newLOTRMaterial("ANARION", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial ARPHARAZON = newLOTRMaterial("ARPHARAZON", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial ARVEDUI = newLOTRMaterial("ARVEDUI", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial BOROMIR = newLOTRMaterial("BOROMIR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial ELENDIL = newLOTRMaterial("ELENDIL", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial ELROS = newLOTRMaterial("ELROS", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial FEANOR = newLOTRMaterial("FEANOR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial GILGALAD = newLOTRMaterial("GILGALAD", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial GIMLI = newLOTRMaterial("GIMLI", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial ISILDUR = newLOTRMaterial("ISILDUR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial JIINDUR = newLOTRMaterial("JIINDUR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial KHAMUL = newLOTRMaterial("KHAMUL", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial KHOMMURAT = newLOTRMaterial("KHOMMURAT", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial MORGOMIR = newLOTRMaterial("MORGOMIR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial THEODEN = newLOTRMaterial("THEODEN", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static final LOTRMaterial TURGON = newLOTRMaterial("TURGON", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static Method setUses;
	public static Method setDamage;
	public static Method setProtection;
	public static Method setSpeed;
	public static Method setHarvestLevel;
	public static Method setEnchantibility;
	public static Method setCraftingMaterial;
	public static Method setUndamageable;
	public static Method setManFlesh;

	public LIArmor(LOTRMaterial material, int slotType) {
		super(material, slotType);
		setCreativeTab(LOTRCreativeTabs.tabStory);
	}

	public static LOTRMaterial editLOTRMaterial(LOTRMaterial material, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterialTool, Item craftingMaterialArmor, boolean manFlesh, boolean undamageable) {
		setup();
		try {
			if (uses != -1) {
				setUses.invoke(material, uses);
			}
			if (damage != -1.0f) {
				setDamage.invoke(material, damage);
			}
			if (protection != -1.0f) {
				setProtection.invoke(material, protection);
			}
			if (speed != -1.0f) {
				setSpeed.invoke(material, speed);
			}
			if (harvestLevel != -1) {
				setHarvestLevel.invoke(material, harvestLevel);
			}
			if (enchantability != -1) {
				setEnchantibility.invoke(material, enchantability);
			}
			if (craftingMaterialTool != null && craftingMaterialArmor != null) {
				setCraftingMaterial.invoke(material, craftingMaterialTool, craftingMaterialArmor);
			}
			if (undamageable) {
				setUndamageable.invoke(material);
			}
			if (manFlesh) {
				setManFlesh.invoke(material);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return material;
	}

	public static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterial) {
		return newLOTRMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterial, false);
	}

	public static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterial, boolean manFlesh) {
		return newLOTRMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterial, craftingMaterial, manFlesh, false);
	}

	public static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterialTool, Item craftingMaterialArmor, boolean manFlesh, boolean undamageable) {
		setup();
		LOTRMaterial material = null;
		try {
			material = constructor.newInstance(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return editLOTRMaterial(material, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterialTool, craftingMaterialArmor, manFlesh, undamageable);
	}

	public static void onInit() {
		setMaterialCraftingItem(ANARION, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(ARPHARAZON, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(ARVEDUI, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(BOROMIR, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(ELENDIL, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(ELROS, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(FEANOR, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(GILGALAD, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(GIMLI, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(ISILDUR, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(JIINDUR, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(KHAMUL, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(KHOMMURAT, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(MORGOMIR, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(THEODEN, Items.iron_ingot, Items.leather);
		setMaterialCraftingItem(TURGON, Items.iron_ingot, Items.leather);
	}

	public static void setup() {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getArmorName(LOTRItemArmor armor) {
		return findAndInvokeMethod(LOTRItemArmor.class, armor, "getArmorName");
	}

	public static <T, E> T findAndInvokeMethod(Object[] arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
		return findAndInvokeMethod(arg, clazz, instance, new String[]{methodName}, methodTypes);
	}

	public static <T, E> T findAndInvokeMethod(Object[] args, Class<? super E> clazz, E instance, String[] methodNames, Class<?>... methodTypes) {
		Method addControlZoneMethod = ReflectionHelper.findMethod(clazz, instance, methodNames, methodTypes);
		try {
			return (T) addControlZoneMethod.invoke(instance, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T, E> T findAndInvokeMethod(Class<? super E> clazz, E instance, String methodName) {
		return findAndInvokeMethod(new Object[0], clazz, instance, methodName);
	}

	public static void setMaterialCraftingItem(LOTRMaterial material, Item toolItem, Item armorItem) {
		findAndInvokeMethod(new Object[]{toolItem, armorItem}, LOTRMaterial.class, material, "setCraftingItems", Item.class, Item.class);
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		StringBuilder texture = new StringBuilder("legendarium:armor/").append(getArmorName(this));
		if (type != null) {
			texture.append("_").append(type);
		}
		return texture.append(".png").toString();
	}
}
