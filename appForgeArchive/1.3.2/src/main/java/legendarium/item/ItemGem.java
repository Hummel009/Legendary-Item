package legendarium.item;

import legendarium.init.ItemGroups;
import net.minecraft.src.Item;

public class ItemGem extends Item {
	public ItemGem(int id) {
		super(id);
		setMaxStackSize(1);
		setCreativeTab(ItemGroups.TAB_ARTIFACTS);
	}
}