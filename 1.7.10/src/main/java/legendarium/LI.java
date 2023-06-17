package legendarium;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import legendarium.content.LIRegistry;
import legendarium.lotr.LIRegistryLOTR;
import legendarium.proxy.LICommonProxy;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

@Mod(modid = "legendarium")
public class LI {
	public static final String DISABLE_CURSEFORGE_DUPLICATE_NOTICE = "213313062023";

	@SidedProxy(serverSide = "legendarium.proxy.LICommonProxy", clientSide = "legendarium.proxy.LIClientProxy")
	public static LICommonProxy proxy;

	public static int hasLOTR = -1;
	public static LIDependencyManager registry;

	public static boolean hasLOTR() {
		if (hasLOTR == -1) {
			try {
				Class.forName("lotr.common.LOTRMod");
				hasLOTR = 1;
			} catch (ClassNotFoundException e) {
				hasLOTR = 0;
			}
		}
		return hasLOTR == 1;
	}

	@Mod.EventHandler
	public void onMissingMappings(FMLMissingMappingsEvent event) {
		Map<String, Item> renamed = new HashMap<>();
		renamed.put("armor_khommurat_helmet", LIRegistry.armorHoarmurathHelmet);
		renamed.put("armor_khommurat_chestplate", LIRegistry.armorHoarmurathChestplate);
		renamed.put("armor_khommurat_legs", LIRegistry.armorHoarmurathLeggings);
		renamed.put("armor_khommurat_boots", LIRegistry.armorHoarmurathBoots);
		renamed.put("armor_anarion_legs", LIRegistry.armorAnarionLeggings);
		renamed.put("armor_arpharazon_legs", LIRegistry.armorArpharazonLeggings);
		renamed.put("armor_arvedui_legs", LIRegistry.armorArveduiLeggings);
		renamed.put("armor_boromir_legs", LIRegistry.armorBoromirLeggings);
		renamed.put("armor_elendil_legs", LIRegistry.armorElendilLeggings);
		renamed.put("armor_elros_legs", LIRegistry.armorElrosLeggings);
		renamed.put("armor_feanor_legs", LIRegistry.armorFeanorLeggings);
		renamed.put("armor_gilgalad_legs", LIRegistry.armorGilgaladLeggings);
		renamed.put("armor_gimli_legs", LIRegistry.armorGimliLeggings);
		renamed.put("armor_isildur_legs", LIRegistry.armorIsildurLeggings);
		renamed.put("armor_jiindur_legs", LIRegistry.armorJiindurLeggings);
		renamed.put("armor_khamul_legs", LIRegistry.armorKhamulLeggings);
		renamed.put("armor_morgomir_legs", LIRegistry.armorMorgomirLeggings);
		renamed.put("armor_theoden_legs", LIRegistry.armorTheodenLeggings);
		renamed.put("armor_turgon_legs", LIRegistry.armorTurgonLeggings);
		for (FMLMissingMappingsEvent.MissingMapping mapping : event.get()) {
			if (mapping.type == GameRegistry.Type.ITEM) {
				for (Map.Entry<String, Item> entry : renamed.entrySet()) {
					if (mapping.name.contains(entry.getKey())) {
						mapping.remap(entry.getValue());
						break;
					}
				}
			}
		}
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		if (hasLOTR()) {
			registry = new LIRegistryLOTR();
		} else {
			registry = new LIRegistry();
		}
		registry.registerCommon();
		registry.registerSpecial();

		proxy.preInit(event);
	}
}
