package legendarium;

import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTier;

public class LIItemSword extends ItemSword {
	public LIItemSword() {
		super(ItemTier.DIAMOND, 12, 2.0F, new Properties().group(LICreativeTabs.TAB_ARTIFACTS));
	}
}