package com.github.hummel.legendarium;

import com.github.hummel.legendarium.handler.ModEventHandler;
import com.github.hummel.legendarium.init.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("legendarium")
public class Main {
	public static final String DISABLE_CURSEFORGE_DUPLICATE_NOTICE = "111229022024";

	public Main() {
		var modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		var modEventHandler = new ModEventHandler();
		modEventBus.register(modEventHandler);

		Items.register(modEventBus);
	}
}