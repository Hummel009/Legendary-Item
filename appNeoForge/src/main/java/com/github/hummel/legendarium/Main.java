package com.github.hummel.legendarium;

import com.github.hummel.legendarium.handler.ModEventHandler;
import com.github.hummel.legendarium.init.ItemGroups;
import com.github.hummel.legendarium.init.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod("legendarium")
public class Main {
	public static final String DISABLE_CURSEFORGE_DUPLICATE_NOTICE = "131829122023";

	public Main(IEventBus modEventBus) {
		var modEventHandler = new ModEventHandler();
		modEventBus.register(modEventHandler);

		Items.register(modEventBus);
		ItemGroups.register(modEventBus);
	}
}