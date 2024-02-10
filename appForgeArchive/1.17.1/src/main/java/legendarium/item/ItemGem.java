package legendarium.item;

import legendarium.init.ItemGroups;
import net.minecraft.world.item.Item;

public class ItemGem extends Item {
	public ItemGem() {
		super(new Properties().stacksTo(1).tab(ItemGroups.TAB_ARTIFACTS));
	}
}