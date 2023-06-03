package legendarium;

import net.minecraft.src.Item;

public class LIItemEmpty extends Item {
	public LIItemEmpty(int id) {
		super(id);
		LIReflectionHelper.setCreativeTab(this, LICreativeTabs.TAB_ARTIFACTS);
	}
}