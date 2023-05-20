package legendarium;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class LIItemArmor extends ItemArmor {
	public final String materialName;

	public LIItemArmor(ItemArmor.ArmorMaterial material, EntityEquipmentSlot slot) {
		this(material, slot, slot == EntityEquipmentSlot.LEGS ? 2 : 1);
	}

	public LIItemArmor(ItemArmor.ArmorMaterial material, EntityEquipmentSlot slot, int renderId) {
		super(material, renderId, slot);
		setCreativeTab(LICreativeTabs.tabWeapons);
		materialName = material.getName();
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, EntityEquipmentSlot slot, String layer) {
		if (slot == EntityEquipmentSlot.LEGS) {
			return "legendarium:armor/" + materialName + "_2.png";
		}
		return "legendarium:armor/" + materialName + "_1.png";
	}
}