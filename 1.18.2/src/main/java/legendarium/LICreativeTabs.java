package legendarium;

import org.jetbrains.annotations.NotNull;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class LICreativeTabs {
	public static final CreativeModeTab tabWeapons = new CreativeModeTab("weapons") {
		@Override
		public @NotNull ItemStack makeIcon() {
			return new ItemStack(LI.WEAPON_FARAMIR.get());
		}
	};
}
