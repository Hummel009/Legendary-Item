package legendarium;

import net.minecraft.item.*;

public class LIItemSword extends ItemSword {
	public LIItemSword() {
		super(ItemTier.DIAMOND, 12, 2F, new Properties().group(LICreativeTabs.tabWeapons));
	}
}