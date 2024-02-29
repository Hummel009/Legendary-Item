package com.github.hummel.legendarium;

import com.github.hummel.legendarium.handler.ModEventHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("legendarium")
public class Main {
	public static final String DISABLE_CURSEFORGE_DUPLICATE_NOTICE = "111229022024";

	public Main() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModEventHandler modEventHandler = new ModEventHandler();
		modEventBus.register(modEventHandler);
	}
}