package legendarium.content;

import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;

public class LIItemSword extends SwordItem {
	public LIItemSword() {
		super(ItemTier.DIAMOND, 3, -2.4F, new Properties().group(LICreativeTabs.TAB_ARTIFACTS));
	}
}