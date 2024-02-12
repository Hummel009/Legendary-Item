package legendarium.handler;

import legendarium.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEventHandler {
	@SubscribeEvent
	public void onItemRegistry(RegistryEvent.Register<Item> event) {
		Items.register();
	}
}