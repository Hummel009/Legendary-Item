package legendarium.content;

import legendarium.LI;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class LICreativeTabs {
	public static final CreativeTabs TAB_ARTIFACTS = new CreativeTabs("legendarium.artifacts") {
		@Override
		public Item getTabIconItem() {
			return LI.weaponFaramir;
		}
	};

	private LICreativeTabs() {
	}
}
