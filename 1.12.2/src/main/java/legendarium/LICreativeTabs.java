package legendarium;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class LICreativeTabs {
	public static CreativeTabs tabWeapons = new CreativeTabs("weapons") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(LI.weapon_faramir);
		}
	};
}
