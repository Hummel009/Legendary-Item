package legendarium;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cpw.mods.fml.relauncher.ReflectionHelper;
import lotr.client.gui.LOTRMapLabels;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRCreativeTabs;
import lotr.common.LOTRDimension;
import lotr.common.LOTRFoods;
import lotr.common.LOTRLore;
import lotr.common.LOTRShields;
import lotr.common.LOTRTitle;
import lotr.common.entity.item.LOTREntityBanner;
import lotr.common.entity.item.LOTREntityBannerWall;
import lotr.common.entity.npc.LOTREntityNPC;
import lotr.common.entity.npc.LOTRNames;
import lotr.common.entity.npc.LOTRSpeech;
import lotr.common.entity.npc.LOTRTradeEntries;
import lotr.common.fac.LOTRControlZone;
import lotr.common.fac.LOTRFaction;
import lotr.common.fac.LOTRFactionRank;
import lotr.common.fac.LOTRFactionRelations;
import lotr.common.fac.LOTRFactionRelations.Relation;
import lotr.common.fac.LOTRMapRegion;
import lotr.common.item.LOTRItemArmor;
import lotr.common.item.LOTRItemBanner;
import lotr.common.item.LOTRItemBow;
import lotr.common.item.LOTRItemMountArmor;
import lotr.common.item.LOTRItemMug;
import lotr.common.item.LOTRMaterial;
import lotr.common.quest.LOTRMiniQuest;
import lotr.common.quest.LOTRMiniQuestFactory;
import lotr.common.util.LOTRVersionChecker;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRMountains;
import lotr.common.world.map.LOTRRoads;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTRInvasions;
import lotr.common.world.spawning.LOTRSpawnEntry;
import lotr.common.world.spawning.LOTRSpawnList;
import lotr.common.world.structure.LOTRChestContents;
import lotr.common.world.structure2.scan.LOTRStructureScan;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.EnumHelper;

public class LegendariumCommander {
	  public static List < Item > getAllGOTItems() {
		   return LegendariumCommander.getObjectFieldsOfType(LegendariumRegistry.class, Item.class);
		  }

		  public static < E, T > List < T > getObjectFieldsOfType(Class < ? extends E > clazz, Class < ? extends T > type) {
		   return getObjectFieldsOfType(clazz, null, type);
		  }

		  public static < E, T > List < T > getObjectFieldsOfType(Class < ? extends E > clazz, E instance, Class < ? extends T > type) {
		   List < T > list = new ArrayList < > ();
		   try {
		    for (Field field: clazz.getDeclaredFields()) {
		     if (field != null) {
		      Object fieldObj = null;
		      if (Modifier.isStatic(field.getModifiers())) {
		       fieldObj = field.get(null);
		      } else if (instance != null) {
		       fieldObj = field.get(instance);
		      }
		      if (fieldObj != null)
		       if (type.isAssignableFrom(fieldObj.getClass()))
		        list.add((T) fieldObj);
		     }
		    }
		   } catch (IllegalArgumentException | IllegalAccessException e) {

		   }
		   return list;
		  }

		  public static Item.ToolMaterial getBowMaterial(LOTRItemBow bow) {
		   return (Item.ToolMaterial) ReflectionHelper.getPrivateValue(LOTRItemBow.class, bow, new String[] {
		    "bowMaterial"
		   });
		  }

		  public static void setMaterialCraftingItem(LOTRMaterial material, Item item) {
		   setMaterialCraftingItem(material, item, item);
		  }

		  public static void setMaterialCraftingItem(LOTRMaterial material, Item toolItem, Item armorItem) {
		   findAndInvokeMethod(new Object[] {
		    toolItem,
		    armorItem
		   }, LOTRMaterial.class, material, "setCraftingItems", new Class[] {
		    Item.class, Item.class
		   });
		  }

		  public static String getArmorName(LOTRItemArmor armor) {
		   return findAndInvokeMethod(LOTRItemArmor.class, armor, "getArmorName");
		  }

		  public static LOTRItemMountArmor.Mount getMountArmorType(LOTRItemMountArmor armor) {
		   return (LOTRItemMountArmor.Mount) ReflectionHelper.getPrivateValue(LOTRItemMountArmor.class, armor, new String[] {
		    "mountType"
		   });
		  }

		  public static void setToolMaterialRepairItem(Item.ToolMaterial material, ItemStack item) {
		   ReflectionHelper.setPrivateValue(Item.ToolMaterial.class, material, item, new String[] {
		    "repairMaterial"
		   });
		  }

		  private static < T, E > T findAndInvokeMethod(Class < ? super E > clazz, E instance, String methodName) {
		   return findAndInvokeMethod(new Object[0], clazz, instance, methodName, new Class[0]);
		  }

		  private static < T, E > T findAndInvokeMethod(Object arg, Class < ? super E > clazz, E instance, String methodName, Class < ? > ...methodTypes) {
		   return findAndInvokeMethod(new Object[] {
		    arg
		   }, clazz, instance, new String[] {
		    methodName
		   }, methodTypes);
		  }

		  private static < T, E > T findAndInvokeMethod(Object[] arg, Class < ? super E > clazz, E instance, String methodName, Class < ? > ...methodTypes) {
		   return findAndInvokeMethod(arg, clazz, instance, new String[] {
		    methodName
		   }, methodTypes);
		  }

		  private static < T, E > T findAndInvokeMethod(Object[] args, Class < ? super E > clazz, E instance, String[] methodNames, Class < ? > ...methodTypes) {
		   Method addControlZoneMethod = ReflectionHelper.findMethod(clazz, instance, methodNames, methodTypes);
		   try {
		    return (T) addControlZoneMethod.invoke(instance, args);
		   } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
		    e.printStackTrace();
		    return null;
		   }
		  }
}