package legendarium;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class LICreativeTabs {
	public static final CreativeModeTab tabWeapons = new CreativeModeTab("weapons") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(LI.weapon_faramir.get());
		}
	};
}
