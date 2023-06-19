package legendarium.content;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class LIItemArmor extends ItemArmor {
	private final String materialName;

	public LIItemArmor(ItemArmor.ArmorMaterial material, int slot) {
		this(material, slot, slot == 2 ? 2 : 1);
	}

	public LIItemArmor(ItemArmor.ArmorMaterial material, int slot, int renderId) {
		super(material, renderId, slot);
		setCreativeTab(LICreativeTabs.TAB_ARTIFACTS);
		materialName = material.getName();
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String layer) {
		if (slot == 2) {
			return "legendarium:armor/" + materialName + "_2.png";
		}
		return "legendarium:armor/" + materialName + "_1.png";
	}
}