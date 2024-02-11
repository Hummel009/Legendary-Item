package legendarium;

import legendarium.handler.ModEventHandler;
import legendarium.init.ItemGroups;
import legendarium.init.Items;
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