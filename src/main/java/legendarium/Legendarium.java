package legendarium;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;

@Mod(modid = Legendarium.MODID, version = Legendarium.VERSION, dependencies = "required-after:lotr")
public class Legendarium {
	public static final String MODID = "legendarium";
	public static final String VERSION = "Version 4";
	@SidedProxy(serverSide = "legendarium.LegendariumServerProxy", clientSide = "legendarium.LegendariumClientProxy")
	public static LegendariumServerProxy proxy;

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		LegendariumArmor.onInit();
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LegendariumRegistry.preInit();
		proxy.preInit(event);
	}
}