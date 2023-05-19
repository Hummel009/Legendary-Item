package legendarium;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class LICreativeTabs {
	public static final ItemGroup tabWeapons = new ItemGroup("weapons") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(LI.weapon_faramir.get());
		}
	};
}
