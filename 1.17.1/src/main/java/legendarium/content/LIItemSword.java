package legendarium.content;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class LIItemSword extends SwordItem {
	public LIItemSword() {
		super(Tiers.DIAMOND, 3, -2.4F, new Properties().tab(LICreativeTabs.TAB_ARTIFACTS));
	}
}