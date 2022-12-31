package legendarium;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegistryObject;

public class LICreativeTabs {
	@SubscribeEvent
	public static void addCreativeTab(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("xtraarrows", "xtraarrowstab"), builder -> builder.title(Component.translatable("itemGroup.weapons")).icon(() -> new ItemStack(LI.weapon_faramir.get())).displayItems((enabledFlags, populator, hasPermissions) -> {
			for (RegistryObject<Item> amogus : LI.sus) {
				populator.accept(amogus.get());
			}
		}));
	}
}
