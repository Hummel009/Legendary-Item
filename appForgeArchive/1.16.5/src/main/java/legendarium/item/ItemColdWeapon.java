package legendarium.item;

import legendarium.init.ItemGroups;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;

public class ItemColdWeapon extends SwordItem {
	public ItemColdWeapon() {
		super(ItemTier.DIAMOND, 3, -2.4f, new Properties().tab(ItemGroups.TAB_ARTIFACTS));
	}
}