package legendarium.content;

import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class LIItemArmor extends ItemArmor {
	public final String materialName;

	public LIItemArmor(int id, EnumArmorMaterial material, int slot) {
		this(id, material, slot, slot == 2 ? 2 : 1);
	}

	public LIItemArmor(int id, EnumArmorMaterial material, int slot, int renderId) {
		super(id, material, renderId, slot);
		setCreativeTab(LICreativeTabs.TAB_ARTIFACTS);
		materialName = material.name();
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String layer) {
		if (slot == 2) {
			return "legendarium:armor/" + materialName + "_2.png";
		}
		return "legendarium:armor/" + materialName + "_1.png";
	}
}