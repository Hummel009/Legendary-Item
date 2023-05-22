package legendarium;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class LICreativeTabs {
	public static final CreativeTabs tabWeapons = new CreativeTabs("weapons") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(LI.weaponFaramir).getItem();
		}
		
		@Override
		public String getTranslatedTabLabel() {
			return "Middle-Earth Artifacts";
		}
	};
}
