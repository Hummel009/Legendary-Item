package legendarium.content;

import legendarium.LI;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;

public class LICreativeTabs {
	private LICreativeTabs() {
	}

	public static void onCreativeModeTabRegistry(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("legendarium", "legendariumtab"), builder -> builder.title(Component.translatable("itemGroup.artifacts")).icon(() -> new ItemStack(LI.WEAPON_FARAMIR.get())).displayItems((enabledFlags, populator) -> {
			for (var item : LI.CONTENT) {
				populator.accept(item);
			}
		}));
	}
}