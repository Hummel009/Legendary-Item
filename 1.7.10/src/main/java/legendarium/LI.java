package legendarium;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import legendarium.content.LIRegistry;
import legendarium.lotr.LIRegistryLOTR;
import legendarium.proxy.LIServerProxy;
import net.minecraft.item.Item;

@Mod(modid = "legendarium")
public class LI {
	@SidedProxy(serverSide = "legendarium.proxy.LIServerProxy", clientSide = "legendarium.proxy.LIClientProxy")
	public static LIServerProxy proxy;
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

	@Mod.EventHandler
	public void onMissingMappings(FMLMissingMappingsEvent event) {
		Map<String, Item> renamed = new HashMap<>();
		renamed.put("armor_khommurat_helmet", ringHoarmurath);
		renamed.put("armor_khommurat_chestplate", ringHoarmurath);
		renamed.put("armor_khommurat_leggings", ringHoarmurath);
		renamed.put("armor_khommurat_boots", ringHoarmurath);
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
}
