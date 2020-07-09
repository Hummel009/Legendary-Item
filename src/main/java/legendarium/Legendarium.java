package legendarium;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Legendarium.MODID, version=Legendarium.VERSION, dependencies="required-after:lotr")
public class Legendarium {
    public static final String MODID = "legendarium";
    public static final String VERSION = "3";
    @SidedProxy(serverSide = "legendarium.LegendariumServerProxy", clientSide = "legendarium.LegendariumClientProxy")
	public static LegendariumServerProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	LegendariumRegistry.onInit();
    	proxy.preInit(event);
    }
    
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
    	LegendariumArmor.setupCraftingItems();
    }
}