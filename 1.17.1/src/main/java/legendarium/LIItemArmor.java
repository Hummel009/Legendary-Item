package legendarium;

import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;

public class LIItemArmor extends ArmorItem {
	public String materialName;

	public LIItemArmor(ArmorMaterial material, EquipmentSlot slot) {
		super(material, slot, new Properties().tab(LICreativeTabs.tabWeapons));
		materialName = material.getName();
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot slot, String layer) {
		if (slot == EquipmentSlot.LEGS) {
			return "legendarium:armor/" + materialName + "_2.png";
		}
		return "legendarium:armor/" + materialName + "_1.png";
	}
}