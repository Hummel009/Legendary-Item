package legendarium;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "legendarium")
public class LI {
	@SidedProxy(serverSide = "legendarium.LIServerProxy", clientSide = "legendarium.LIClientProxy")
	public static LIServerProxy proxy;

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		LIArmor.onInit();
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LIRegistry.preInit();
		proxy.preInit(event);
	}
}
