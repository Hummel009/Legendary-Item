package legendarium;

import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class LIMaterial {
	public static final ArmorMaterial ANARION = EnumHelper.addArmorMaterial("anarion", "anarion", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial ARPHARAZON = EnumHelper.addArmorMaterial("arpharazon", "arpharazon", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial ARVEDUI = EnumHelper.addArmorMaterial("arvedui", "arvedui", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial BOROMIR = EnumHelper.addArmorMaterial("boromir", "boromir", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial ELENDIL = EnumHelper.addArmorMaterial("elendil", "elendil", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial ELROS = EnumHelper.addArmorMaterial("elros", "elros", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial FEANOR = EnumHelper.addArmorMaterial("feanor", "feanor", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial GILGALAD = EnumHelper.addArmorMaterial("gilgalad", "gilgalad", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial GIMLI = EnumHelper.addArmorMaterial("gimli", "gimli", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial ISILDUR = EnumHelper.addArmorMaterial("isildur", "isildur", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial JIINDUR = EnumHelper.addArmorMaterial("jiindur", "jiindur", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial KHAMUL = EnumHelper.addArmorMaterial("khamul", "khamul", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial KHOMMURAT = EnumHelper.addArmorMaterial("khommurat", "khommurat", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial MORGOMIR = EnumHelper.addArmorMaterial("morgomir", "morgomir", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial THEODEN = EnumHelper.addArmorMaterial("theoden", "theoden", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial TURGON = EnumHelper.addArmorMaterial("turgon", "turgon", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);

	static {
		ANARION.customCraftingMaterial = Items.IRON_INGOT;
		ARPHARAZON.customCraftingMaterial = Items.IRON_INGOT;
		ARVEDUI.customCraftingMaterial = Items.IRON_INGOT;
		BOROMIR.customCraftingMaterial = Items.IRON_INGOT;
		ELENDIL.customCraftingMaterial = Items.IRON_INGOT;
		ELROS.customCraftingMaterial = Items.IRON_INGOT;
		FEANOR.customCraftingMaterial = Items.IRON_INGOT;
		GILGALAD.customCraftingMaterial = Items.IRON_INGOT;
		GIMLI.customCraftingMaterial = Items.IRON_INGOT;
		ISILDUR.customCraftingMaterial = Items.IRON_INGOT;
		JIINDUR.customCraftingMaterial = Items.IRON_INGOT;
		KHAMUL.customCraftingMaterial = Items.IRON_INGOT;
		KHOMMURAT.customCraftingMaterial = Items.IRON_INGOT;
		MORGOMIR.customCraftingMaterial = Items.IRON_INGOT;
		THEODEN.customCraftingMaterial = Items.IRON_INGOT;
		TURGON.customCraftingMaterial = Items.IRON_INGOT;
	}
}