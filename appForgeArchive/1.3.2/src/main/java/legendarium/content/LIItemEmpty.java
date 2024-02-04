package legendarium.content;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class LIItemEmpty extends Item {
	private final EnumRarity rarity;

	public LIItemEmpty(int id, EnumRarity rarity) {
		super(id);
		setMaxStackSize(1);
		setCreativeTab(LICreativeTabs.TAB_ARTIFACTS);
		this.rarity = rarity;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack var1) {
		return rarity;
	}
}