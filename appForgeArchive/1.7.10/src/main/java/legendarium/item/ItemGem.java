package legendarium.item;

import legendarium.init.ItemGroups;
import net.minecraft.item.Item;

public class ItemGem extends Item {
	public ItemGem() {
		setMaxStackSize(1);
		setCreativeTab(ItemGroups.TAB_ARTIFACTS);
	}
}