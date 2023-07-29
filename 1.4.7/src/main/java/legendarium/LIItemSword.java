package legendarium;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class LIItemSword extends ItemSword {
	public LIItemSword(int id) {
		super(id, EnumToolMaterial.EMERALD);
		setCreativeTab(LICreativeTabs.TAB_ARTIFACTS);
	}
}