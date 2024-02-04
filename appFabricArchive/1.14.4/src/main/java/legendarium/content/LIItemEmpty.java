package legendarium.content;

import legendarium.LI;
import net.minecraft.world.item.Item;

public class LIItemEmpty extends Item {
	public LIItemEmpty() {
		super(new Properties().stacksTo(1).tab(LI.TAB_ARTIFACTS));
		LI.CONTENT.add(this);
	}
}