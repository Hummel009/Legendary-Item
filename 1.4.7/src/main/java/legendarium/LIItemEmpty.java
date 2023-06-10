package legendarium;

import net.minecraft.item.Item;

public class LIItemEmpty extends Item {
	public LIItemEmpty(int id) {
		super(id);
		setCreativeTab(LICreativeTabs.TAB_ARTIFACTS);
		setMaxStackSize(1);
	}
}