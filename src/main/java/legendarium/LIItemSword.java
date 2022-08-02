package legendarium;

import net.minecraft.item.*;

public class LIItemSword extends SwordItem {
	public LIItemSword() {
		super(ItemTier.NETHERITE, 12, 2F, new Properties().tab(LICreativeTabs.tabWeapons));
	}
}