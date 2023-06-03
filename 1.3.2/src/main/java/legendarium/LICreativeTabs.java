package legendarium;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class LICreativeTabs {
	public static final CreativeTabs TAB_ARTIFACTS = new CreativeTabs("weapons") {

		public Item d() {
			return getTabIconItem();
		}

		public Item getTabIconItem() {
			return LI.weaponFaramir;
		}

		@Override
		public String getTranslatedTabLabel() {
			return "Middle-Earth Artifacts";
		}
	};
}
