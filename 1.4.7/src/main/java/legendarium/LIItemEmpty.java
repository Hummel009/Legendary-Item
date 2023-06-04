package legendarium;

import net.minecraft.item.Item;

public class LIItemEmpty extends Item {
	public LIItemEmpty(int id) {
		super(id);
		LIObfuscationHelper.setCreativeTab(this, LICreativeTabs.TAB_ARTIFACTS);
	}
}