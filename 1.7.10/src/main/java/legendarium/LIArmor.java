package legendarium;

import java.lang.reflect.*;

import lotr.common.LOTRCreativeTabs;
import lotr.common.item.*;
import net.minecraft.entity.*;
import net.minecraft.init.Items;
import net.minecraft.item.*;

public class LIArmor extends LOTRItemArmor {
	public static LOTRMaterial ANARION = LIArmor.newLOTRMaterial("ANARION", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial ARPHARAZON = LIArmor.newLOTRMaterial("ARPHARAZON", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial ARVEDUI = LIArmor.newLOTRMaterial("ARVEDUI", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial BOROMIR = LIArmor.newLOTRMaterial("BOROMIR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial ELENDIL = LIArmor.newLOTRMaterial("ELENDIL", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial ELROS = LIArmor.newLOTRMaterial("ELROS", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial FEANOR = LIArmor.newLOTRMaterial("FEANOR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial GILGALAD = LIArmor.newLOTRMaterial("GILGALAD", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial GIMLI = LIArmor.newLOTRMaterial("GIMLI", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial ISILDUR = LIArmor.newLOTRMaterial("ISILDUR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial JIINDUR = LIArmor.newLOTRMaterial("JIINDUR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial KHAMUL = LIArmor.newLOTRMaterial("KHAMUL", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial KHOMMURAT = LIArmor.newLOTRMaterial("KHOMMURAT", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial MORGOMIR = LIArmor.newLOTRMaterial("MORGOMIR", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial THEODEN = LIArmor.newLOTRMaterial("THEODEN", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static LOTRMaterial TURGON = LIArmor.newLOTRMaterial("TURGON", 300, 2.5f, 0.5f, 2.0f, 6, 10, null);
	public static boolean setup;
	public static Constructor<LOTRMaterial> constructor;
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

	public LIArmor(LOTRMaterial material, int slotType, String textureSuffix) {
		super(material, slotType, textureSuffix);
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		StringBuilder texture = new StringBuilder("legendarium:armor/").append(LICommander.getArmorName(this));
		if (type != null) {
			texture.append("_").append(type);
		}
		return texture.append(".png").toString();
	}

	public static LOTRMaterial editLOTRMaterial(LOTRMaterial material, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterialTool, Item craftingMaterialArmor, boolean manFlesh, boolean undamageable) {
		LIArmor.setup();
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
				setCraftingMaterial.invoke(material, craftingMaterialTool, craftingMaterialArmor);
			}
			if (undamageable) {
				setUndamageable.invoke(material);
			}
			if (manFlesh) {
				setManFlesh.invoke(material);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception) {
			// empty catch block
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

	public static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterial) {
		return LIArmor.newLOTRMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterial, false);
	}

	public static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterial, boolean manFlesh) {
		return LIArmor.newLOTRMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterial, craftingMaterial, manFlesh, false);
	}

	public static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterialTool, Item craftingMaterialArmor, boolean manFlesh, boolean undamageable) {
		LIArmor.setup();
		LOTRMaterial material = null;
		try {
			material = constructor.newInstance(name);
		} catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException exception) {
			// empty catch block
		}
		return LIArmor.editLOTRMaterial(material, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterialTool, craftingMaterialArmor, manFlesh, undamageable);
	}

	public static void onInit() {
		LICommander.setMaterialCraftingItem(ANARION, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(ARPHARAZON, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(ARVEDUI, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(BOROMIR, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(ELENDIL, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(ELROS, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(FEANOR, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(GILGALAD, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(GIMLI, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(ISILDUR, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(JIINDUR, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(KHAMUL, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(KHOMMURAT, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(MORGOMIR, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(THEODEN, Items.iron_ingot, Items.leather);
		LICommander.setMaterialCraftingItem(TURGON, Items.iron_ingot, Items.leather);
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
		} catch (NoSuchMethodException | SecurityException clazz) {
			// empty catch block
		}
	}
}
