package legendarium;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class LIClientProxy extends LIServerProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		LIRendererManager.preInit();
	}
}
