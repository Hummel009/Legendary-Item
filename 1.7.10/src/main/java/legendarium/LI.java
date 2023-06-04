package legendarium;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import legendarium.content.LIRegistry;
import legendarium.lotr.LIRegistryLOTR;
import legendarium.proxy.LIServerProxy;

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
}
