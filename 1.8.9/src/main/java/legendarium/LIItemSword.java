package legendarium;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class LIItemSword extends ItemSword {
	public LIItemSword() {
		super(Item.ToolMaterial.EMERALD);
		setCreativeTab(LICreativeTabs.TAB_ARTIFACTS);
	}
}