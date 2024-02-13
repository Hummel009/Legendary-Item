package legendarium.item;

import legendarium.init.ItemGroups;
import net.minecraft.item.ItemSword;

public class ItemColdWeapon extends ItemSword {
	public ItemColdWeapon() {
		super(ToolMaterial.EMERALD);
		setCreativeTab(ItemGroups.TAB_ARTIFACTS);
	}
}