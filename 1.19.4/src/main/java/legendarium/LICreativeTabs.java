package legendarium;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LICreativeTabs {
	@SubscribeEvent
	public static void addCreativeTab(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("legendarium", "legendariumtab"), builder -> 
		builder.title(Component.translatable("itemGroup.weapons"))
		.icon(() -> new ItemStack(LI.weapon_faramir.get()))
		.displayItems((enabledFlags, populator) -> {
			for (Item item : LI.itemList) {
				populator.accept(item);
			}
		}));
	}
}
