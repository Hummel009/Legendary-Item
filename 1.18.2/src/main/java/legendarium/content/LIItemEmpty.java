package legendarium.content;

import net.minecraft.world.item.Item;

public class LIItemEmpty extends Item {
	public LIItemEmpty() {
		super(new Properties().stacksTo(1).tab(LICreativeTabs.TAB_ARTIFACTS));
	}
}