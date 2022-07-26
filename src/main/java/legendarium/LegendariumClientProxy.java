package legendarium;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class LegendariumClientProxy extends LegendariumServerProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		LegendariumRendererManager.preInit();
	}
}