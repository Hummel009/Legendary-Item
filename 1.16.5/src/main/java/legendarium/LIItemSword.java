package legendarium;

import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;

public class LIItemSword extends SwordItem {
	public LIItemSword() {
		super(ItemTier.DIAMOND, 12, 2F, new Properties().tab(LICreativeTabs.tabWeapons));
	}
}