package legendarium.content;

import legendarium.LI;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class LIItemArmor extends ArmorItem {
	private final String materialName;

	public LIItemArmor(ArmorMaterial material, Type slot) {
		super(material, slot, new Properties());
		materialName = material.getName();
		initialize();
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot slot, String layer) {
		if (slot == EquipmentSlot.LEGS) {
			return "legendarium:armor/" + materialName + "_2.png";
		}
		return "legendarium:armor/" + materialName + "_1.png";
	}

	public void initialize() {
		LI.CONTENT.add(this);
	}
}