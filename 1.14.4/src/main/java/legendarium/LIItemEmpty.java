package legendarium;

import net.minecraft.item.Item;

public class LIItemEmpty extends Item {
	public LIItemEmpty() {
		super(new Properties().maxStackSize(1).group(LICreativeTabs.TAB_ARTIFACTS));
	}
}