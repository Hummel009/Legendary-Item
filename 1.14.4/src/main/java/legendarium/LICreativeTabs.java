package legendarium;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class LICreativeTabs {
	public static final ItemGroup TAB_ARTIFACTS = new ItemGroup("artifacts") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(LI.weaponFaramir);
		}
	};
}