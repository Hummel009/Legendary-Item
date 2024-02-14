package legendarium.item;

import legendarium.init.ItemGroups;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemGem extends Item {
	private final EnumRarity rarity;

	public ItemGem(int id, EnumRarity rarity) {
		super(id);
		setMaxStackSize(1);
		setCreativeTab(ItemGroups.TAB_ARTIFACTS);
		this.rarity = rarity;
	}

	@Override
	public EnumRarity getRarity(ItemStack var1) {
		return rarity;
	}
}