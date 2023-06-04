package legendarium;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LICreativeTabs {
	public static final CreativeTabs TAB_ARTIFACTS = new CreativeTabs("artifacts") {
		public Item d() {
			return getTabIconItem();
		}

		public Item getTabIconItem() {
			return LI.weaponFaramir;
		}
	};
}
