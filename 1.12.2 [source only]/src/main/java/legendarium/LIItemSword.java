package legendarium;

import net.minecraft.item.*;

public class LIItemSword extends ItemSword {
	public LIItemSword() {
		super(Item.ToolMaterial.DIAMOND);
		setCreativeTab(LICreativeTabs.tabWeapons);
	}
}