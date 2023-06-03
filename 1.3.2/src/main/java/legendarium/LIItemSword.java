package legendarium;

import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemSword;

public class LIItemSword extends ItemSword {
	public LIItemSword(int id) {
		super(id, EnumToolMaterial.values()[3]);
		LIReflectionHelper.setCreativeTab(this, LICreativeTabs.TAB_ARTIFACTS);
	}
}