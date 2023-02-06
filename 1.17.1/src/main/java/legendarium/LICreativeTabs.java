package legendarium;

import net.minecraft.world.item.*;

public class LICreativeTabs {
	public static CreativeModeTab tabWeapons = new CreativeModeTab("weapons") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(LI.weapon_faramir.get());
		}
	};
}
