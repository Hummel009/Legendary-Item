package legendarium.item;

import legendarium.init.ItemGroups;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemColdWeapon extends ItemSword {
	public ItemColdWeapon(int id) {
		super(id, EnumToolMaterial.EMERALD);
		setCreativeTab(ItemGroups.TAB_ARTIFACTS);
	}
}