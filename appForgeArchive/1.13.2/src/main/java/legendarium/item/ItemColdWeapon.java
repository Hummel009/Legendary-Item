package legendarium.item;

import legendarium.init.ItemGroups;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTier;

public class ItemColdWeapon extends ItemSword {
	public ItemColdWeapon() {
		super(ItemTier.DIAMOND, 3, -2.4f, new Properties().group(ItemGroups.TAB_ARTIFACTS));
	}
}