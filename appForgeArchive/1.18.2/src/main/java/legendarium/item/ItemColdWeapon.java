package legendarium.item;

import legendarium.init.ItemGroups;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class ItemColdWeapon extends SwordItem {
	public ItemColdWeapon() {
		super(Tiers.DIAMOND, 3, -2.4f, new Properties().tab(ItemGroups.TAB_ARTIFACTS));
	}
}