package legendarium;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class LIItemSword extends SwordItem {
	public LIItemSword() {
		super(Tiers.DIAMOND, 12, 2F, new Properties());
		initialize();
	}

	public void initialize() {
		LI.itemList.add(this);
	}
}