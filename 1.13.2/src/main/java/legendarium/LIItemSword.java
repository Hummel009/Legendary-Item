package legendarium;

import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTier;

public class LIItemSword extends ItemSword {
	public LIItemSword() {
		super(ItemTier.DIAMOND, 12, 2F, new Properties().group(LICreativeTabs.tabWeapons));
	}
}