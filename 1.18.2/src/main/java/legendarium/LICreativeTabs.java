package legendarium;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class LICreativeTabs {
	public static final CreativeModeTab tabWeapons = new CreativeModeTab("weapons") {
		@Override
		public @NotNull ItemStack makeIcon() {
			return new ItemStack(LI.weapon_faramir.get());
		}
	};
}
