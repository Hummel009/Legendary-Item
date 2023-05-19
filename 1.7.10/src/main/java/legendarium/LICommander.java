package legendarium;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.ReflectionHelper;
import lotr.common.item.LOTRItemArmor;
import lotr.common.item.LOTRItemBow;
import lotr.common.item.LOTRItemMountArmor;
import lotr.common.item.LOTRMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LICommander {
	public static <T, E> T findAndInvokeMethod(Class<? super E> clazz, E instance, String methodName) {
		return LICommander.findAndInvokeMethod(new Object[0], clazz, instance, methodName);
	}

	public static <T, E> T findAndInvokeMethod(Object[] arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
		return LICommander.findAndInvokeMethod(arg, clazz, instance, new String[] { methodName }, methodTypes);
	}

	public static <T, E> T findAndInvokeMethod(Object[] args, Class<? super E> clazz, E instance, String[] methodNames, Class<?>... methodTypes) {
		Method addControlZoneMethod = ReflectionHelper.findMethod(clazz, instance, methodNames, (Class[]) methodTypes);
		try {
			return (T) addControlZoneMethod.invoke(instance, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getArmorName(LOTRItemArmor armor) {
		return (String) LICommander.findAndInvokeMethod(LOTRItemArmor.class, armor, "getArmorName");
	}

	public static Item.ToolMaterial getBowMaterial(LOTRItemBow bow) {
		return (Item.ToolMaterial) ReflectionHelper.getPrivateValue(LOTRItemBow.class, bow, "bowMaterial");
	}

	public static LOTRItemMountArmor.Mount getMountArmorType(LOTRItemMountArmor armor) {
		return (LOTRItemMountArmor.Mount) ReflectionHelper.getPrivateValue(LOTRItemMountArmor.class, armor, "mountType");
	}

	public static <E, T> List<T> getObjectFieldsOfType(Class<? extends E> clazz, Class<? extends T> type) {
		return LICommander.getObjectFieldsOfType(clazz, null, type);
	}

	public static <E, T> List<T> getObjectFieldsOfType(Class<? extends E> clazz, E instance, Class<? extends T> type) {
		ArrayList<Object> list = new ArrayList<>();
		try {
			for (Field field : clazz.getDeclaredFields()) {
				if (field == null) {
					continue;
				}
				Object fieldObj = null;
				if (Modifier.isStatic(field.getModifiers())) {
					fieldObj = field.get(null);
				} else if (instance != null) {
					fieldObj = field.get(instance);
				}
				if (fieldObj == null || !type.isAssignableFrom(fieldObj.getClass())) {
					continue;
				}
				list.add(fieldObj);
			}
		} catch (IllegalAccessException | IllegalArgumentException exception) {
		}
		return (List<T>) list;
	}

	public static void setMaterialCraftingItem(LOTRMaterial material, Item item) {
		LICommander.setMaterialCraftingItem(material, item, item);
	}

	public static void setMaterialCraftingItem(LOTRMaterial material, Item toolItem, Item armorItem) {
		LICommander.findAndInvokeMethod(new Object[] { toolItem, armorItem }, LOTRMaterial.class, material, "setCraftingItems", Item.class, Item.class);
	}

	public static void setToolMaterialRepairItem(Item.ToolMaterial material, ItemStack item) {
		ReflectionHelper.setPrivateValue(Item.ToolMaterial.class, material, (Object) item, "repairMaterial");
	}
}
