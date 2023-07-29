package legendarium;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class LIItemArmor extends ItemArmor implements IArmorTextureProvider {
	private final String materialName;

	public LIItemArmor(int id, EnumArmorMaterial material, int slot) {
		this(id, material, slot, slot == 2 ? 2 : 1);
	}

	public LIItemArmor(int id, EnumArmorMaterial material, int slot, int renderId) {
		super(id, material, renderId, slot);
		setCreativeTab(LICreativeTabs.TAB_ARTIFACTS);
		materialName = material.name();
	}

	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		if (armorType == 2) {
			return "/assets/legendarium/armor/" + materialName + "_2.png";
		}
		return "/assets/legendarium/armor/" + materialName + "_1.png";
	}
}