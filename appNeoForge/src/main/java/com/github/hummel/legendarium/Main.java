package com.github.hummel.legendarium;

import com.github.hummel.legendarium.handler.ModEventHandler;
import com.github.hummel.legendarium.init.ItemGroups;
import com.github.hummel.legendarium.init.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod("legendarium")
public class Main {
	public static final String DISABLE_CURSEFORGE_DUPLICATE_NOTICE = "111229022024";

	public Main(IEventBus modEventBus) {
		try {
			var modEventHandler = new ModEventHandler();
			modEventBus.register(modEventHandler);
		} catch (IllegalArgumentException e) {
			System.err.println("Hummel009: Prevent NeoForge from crash on client-side event handler.");
		}

		Items.register(modEventBus);
		ItemGroups.register(modEventBus);
	}
}