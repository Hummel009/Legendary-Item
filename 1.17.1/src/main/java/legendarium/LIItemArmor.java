package legendarium;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class LIItemArmor extends ArmorItem {
	public final String materialName;

	public LIItemArmor(ArmorMaterial material, EquipmentSlot slot) {
		super(material, slot, new Properties().tab(LICreativeTabs.TAB_ARTIFACTS));
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