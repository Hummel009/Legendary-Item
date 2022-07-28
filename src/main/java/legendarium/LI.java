package legendarium;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;

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