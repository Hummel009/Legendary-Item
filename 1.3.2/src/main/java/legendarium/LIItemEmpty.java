package legendarium;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class LIItemEmpty extends Item {
	private EnumRarity rarity;

	public LIItemEmpty(int id, EnumRarity rarity) {
		super(id);
		setCreativeTab(LICreativeTabs.TAB_ARTIFACTS);
		setMaxStackSize(1);
		this.rarity = rarity;
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack var1) {
		return rarity;
	}
}