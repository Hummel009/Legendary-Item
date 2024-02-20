package com.github.hummel.legendarium;

import com.github.hummel.legendarium.handler.ForgeEventHandler;
import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.init.Langs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.EventBus;

@Mod(modid = "legendarium", useMetadata = true)
public class Main {
	public static final String DISABLE_CURSEFORGE_DUPLICATE_NOTICE = "131829122023";

	public Main() {
		EventBus forgeEventBus = MinecraftForge.EVENT_BUS;
		ForgeEventHandler forgeEventHandler = new ForgeEventHandler();
		forgeEventBus.register(forgeEventHandler);
	}

	@Mod.PreInit
	public void preInit(FMLPreInitializationEvent event) {
		Config.preInit(event);

		Items.preInit();
		Langs.preInit();
	}
}