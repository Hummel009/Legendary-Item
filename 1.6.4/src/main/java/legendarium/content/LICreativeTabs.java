package legendarium.content;

import legendarium.LI;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LICreativeTabs {
	public static final CreativeTabs TAB_ARTIFACTS = new CreativeTabs("artifacts") {
		@Override
		public Item getTabIconItem() {
			return LI.weaponFaramir;
		}
	};
}
