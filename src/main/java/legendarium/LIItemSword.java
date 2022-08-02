package legendarium;

import net.minecraft.item.*;

public class LIItemSword extends SwordItem {
	public LIItemSword() {
		super(ItemTier.DIAMOND, 12, 2F, new Properties().group(LICreativeTabs.tabWeapons));
	}
}