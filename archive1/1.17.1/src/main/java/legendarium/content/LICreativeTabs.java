package legendarium.content;

import legendarium.LI;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class LICreativeTabs {
	public static final CreativeModeTab TAB_ARTIFACTS = new CreativeModeTab("artifacts") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(LI.WEAPON_FARAMIR.get());
		}
	};

	private LICreativeTabs() {
	}
}