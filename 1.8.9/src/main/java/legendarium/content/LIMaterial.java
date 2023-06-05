package legendarium.content;

import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class LIMaterial {
	public static final ArmorMaterial ANARION = EnumHelper.addArmorMaterial("anarion", "anarion", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial ARPHARAZON = EnumHelper.addArmorMaterial("arpharazon", "arpharazon", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial ARVEDUI = EnumHelper.addArmorMaterial("arvedui", "arvedui", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial BOROMIR = EnumHelper.addArmorMaterial("boromir", "boromir", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial ELENDIL = EnumHelper.addArmorMaterial("elendil", "elendil", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial ELROS = EnumHelper.addArmorMaterial("elros", "elros", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial FEANOR = EnumHelper.addArmorMaterial("feanor", "feanor", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial GILGALAD = EnumHelper.addArmorMaterial("gilgalad", "gilgalad", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial GIMLI = EnumHelper.addArmorMaterial("gimli", "gimli", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial ISILDUR = EnumHelper.addArmorMaterial("isildur", "isildur", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial JIINDUR = EnumHelper.addArmorMaterial("jiindur", "jiindur", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial KHAMUL = EnumHelper.addArmorMaterial("khamul", "khamul", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial KHOMMURAT = EnumHelper.addArmorMaterial("khommurat", "khommurat", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial MORGOMIR = EnumHelper.addArmorMaterial("morgomir", "morgomir", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial THEODEN = EnumHelper.addArmorMaterial("theoden", "theoden", 33, new int[]{3, 8, 6, 3}, 10);
	public static final ArmorMaterial TURGON = EnumHelper.addArmorMaterial("turgon", "turgon", 33, new int[]{3, 8, 6, 3}, 10);

	static {
		ANARION.customCraftingMaterial = Items.iron_ingot;
		ARPHARAZON.customCraftingMaterial = Items.iron_ingot;
		ARVEDUI.customCraftingMaterial = Items.iron_ingot;
		BOROMIR.customCraftingMaterial = Items.iron_ingot;
		ELENDIL.customCraftingMaterial = Items.iron_ingot;
		ELROS.customCraftingMaterial = Items.iron_ingot;
		FEANOR.customCraftingMaterial = Items.iron_ingot;
		GILGALAD.customCraftingMaterial = Items.iron_ingot;
		GIMLI.customCraftingMaterial = Items.iron_ingot;
		ISILDUR.customCraftingMaterial = Items.iron_ingot;
		JIINDUR.customCraftingMaterial = Items.iron_ingot;
		KHAMUL.customCraftingMaterial = Items.iron_ingot;
		KHOMMURAT.customCraftingMaterial = Items.iron_ingot;
		MORGOMIR.customCraftingMaterial = Items.iron_ingot;
		THEODEN.customCraftingMaterial = Items.iron_ingot;
		TURGON.customCraftingMaterial = Items.iron_ingot;
	}
}