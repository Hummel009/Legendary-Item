package legendarium.proxy;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import legendarium.render.LIRenderManager;

public class LIClientProxy extends LICommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		LIRenderManager.preInit();
	}
}
