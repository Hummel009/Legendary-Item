package legendarium;

import java.lang.reflect.*;
import java.util.*;

import cpw.mods.fml.relauncher.ReflectionHelper;
import lotr.common.item.*;
import net.minecraft.item.*;

public class LICommander {
	private static <T, E> T findAndInvokeMethod(Class<? super E> clazz, E instance, String methodName) {
		return findAndInvokeMethod(new Object[0], clazz, instance, methodName);
	}

	private static <T, E> T findAndInvokeMethod(Object[] arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
		return findAndInvokeMethod(arg, clazz, instance, new String[] { methodName }, methodTypes);
	}

	private static <T, E> T findAndInvokeMethod(Object[] args, Class<? super E> clazz, E instance, String[] methodNames, Class<?>... methodTypes) {
		Method addControlZoneMethod = ReflectionHelper.findMethod(clazz, instance, methodNames, methodTypes);
		try {
			return (T) addControlZoneMethod.invoke(instance, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getArmorName(LOTRItemArmor armor) {
		return findAndInvokeMethod(LOTRItemArmor.class, armor, "getArmorName");
	}

	public static Item.ToolMaterial getBowMaterial(LOTRItemBow bow) {
		return (Item.ToolMaterial) ReflectionHelper.getPrivateValue(LOTRItemBow.class, bow, "bowMaterial");
	}

	public static LOTRItemMountArmor.Mount getMountArmorType(LOTRItemMountArmor armor) {
		return (LOTRItemMountArmor.Mount) ReflectionHelper.getPrivateValue(LOTRItemMountArmor.class, armor, "mountType");
	}

	public static <E, T> List<T> getObjectFieldsOfType(Class<? extends E> clazz, Class<? extends T> type) {
		return getObjectFieldsOfType(clazz, null, type);
	}

	public static <E, T> List<T> getObjectFieldsOfType(Class<? extends E> clazz, E instance, Class<? extends T> type) {
		List<T> list = new ArrayList<>();
		try {
			for (Field field : clazz.getDeclaredFields()) {
				if (field != null) {
					Object fieldObj = null;
					if (Modifier.isStatic(field.getModifiers())) {
						fieldObj = field.get(null);
					} else if (instance != null) {
						fieldObj = field.get(instance);
					}
					if ((fieldObj != null) && type.isAssignableFrom(fieldObj.getClass())) {
						list.add((T) fieldObj);
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {

		}
		return list;
	}

	public static void setMaterialCraftingItem(LOTRMaterial material, Item item) {
		setMaterialCraftingItem(material, item, item);
	}

	public static void setMaterialCraftingItem(LOTRMaterial material, Item toolItem, Item armorItem) {
		findAndInvokeMethod(new Object[] { toolItem, armorItem }, LOTRMaterial.class, material, "setCraftingItems", Item.class, Item.class);
	}

	public static void setToolMaterialRepairItem(Item.ToolMaterial material, ItemStack item) {
		ReflectionHelper.setPrivateValue(Item.ToolMaterial.class, material, item, "repairMaterial");
	}
}