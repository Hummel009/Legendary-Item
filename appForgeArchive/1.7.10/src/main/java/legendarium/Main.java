package legendarium;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventBus;
import legendarium.handler.EventHandler;
import legendarium.init.Items;
import legendarium.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "legendarium", useMetadata = true)
public class Main {
	public static final String DISABLE_CURSEFORGE_DUPLICATE_NOTICE = "131829122023";

	@SidedProxy(clientSide = "legendarium.proxy.ClientProxy", serverSide = "legendarium.proxy.ServerProxy")
	private static CommonProxy proxy;

	public Main() {
		EventBus forgeEventBus = MinecraftForge.EVENT_BUS;
		EventBus fmlEventBus = FMLCommonHandler.instance().bus();
		EventHandler eventHandler = new EventHandler();
		forgeEventBus.register(eventHandler);
		fmlEventBus.register(eventHandler);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Items.preInit();
	}

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		proxy.onInit();
	}
}