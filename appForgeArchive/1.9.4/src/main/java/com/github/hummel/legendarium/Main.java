package com.github.hummel.legendarium;

import com.github.hummel.legendarium.handler.ForgeEventHandler;
import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;

@SuppressWarnings({"PublicField", "WeakerAccess"})
@Mod(modid = "legendarium", useMetadata = true)
public class Main {
	public static final String DISABLE_CURSEFORGE_DUPLICATE_NOTICE = "111229022024";

	@SidedProxy(clientSide = "com.github.hummel.legendarium.proxy.ClientProxy", serverSide = "com.github.hummel.legendarium.proxy.ServerProxy")
	public static CommonProxy proxy;

	public Main() {
		EventBus forgeEventBus = MinecraftForge.EVENT_BUS;
		ForgeEventHandler forgeEventHandler = new ForgeEventHandler();
		forgeEventBus.register(forgeEventHandler);
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