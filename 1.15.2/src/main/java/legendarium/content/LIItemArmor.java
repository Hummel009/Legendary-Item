package legendarium.content;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class LIItemArmor extends ArmorItem {
	private final String materialName;

	public LIItemArmor(IArmorMaterial material, EquipmentSlotType slot) {
		super(material, slot, new Properties().group(LICreativeTabs.TAB_ARTIFACTS));
		materialName = material.getName();
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlotType slot, String layer) {
		if (slot == EquipmentSlotType.LEGS) {
			return "legendarium:armor/" + materialName + "_2.png";
		}
		return "legendarium:armor/" + materialName + "_1.png";
	}
}