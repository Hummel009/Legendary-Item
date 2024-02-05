package legendarium.content;

import legendarium.LI;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class LICreativeTabs {
	public static final ItemGroup TAB_ARTIFACTS = new ItemGroup("legendarium.artifacts") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(LI.WEAPON_FARAMIR.get());
		}
	};

	private LICreativeTabs() {
	}
}