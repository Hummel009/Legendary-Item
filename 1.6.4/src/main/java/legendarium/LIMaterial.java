package legendarium;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;

public class LIMaterial {
	public static final EnumArmorMaterial ANARION = EnumHelper.addArmorMaterial("anarion", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial ARPHARAZON = EnumHelper.addArmorMaterial("arpharazon", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial ARVEDUI = EnumHelper.addArmorMaterial("arvedui", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial BOROMIR = EnumHelper.addArmorMaterial("boromir", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial ELENDIL = EnumHelper.addArmorMaterial("elendil", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial ELROS = EnumHelper.addArmorMaterial("elros", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial FEANOR = EnumHelper.addArmorMaterial("feanor", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial GILGALAD = EnumHelper.addArmorMaterial("gilgalad", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial GIMLI = EnumHelper.addArmorMaterial("gimli", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial ISILDUR = EnumHelper.addArmorMaterial("isildur", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial JIINDUR = EnumHelper.addArmorMaterial("jiindur", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial KHAMUL = EnumHelper.addArmorMaterial("khamul", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial KHOMMURAT = EnumHelper.addArmorMaterial("khommurat", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial MORGOMIR = EnumHelper.addArmorMaterial("morgomir", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial THEODEN = EnumHelper.addArmorMaterial("theoden", 25, new int[]{2, 5, 6, 2}, 9);
	public static final EnumArmorMaterial TURGON = EnumHelper.addArmorMaterial("turgon", 25, new int[]{2, 5, 6, 2}, 9);

	static {
		ANARION.customCraftingMaterial = Item.ingotIron;
		ARPHARAZON.customCraftingMaterial = Item.ingotIron;
		ARVEDUI.customCraftingMaterial = Item.ingotIron;
		BOROMIR.customCraftingMaterial = Item.ingotIron;
		ELENDIL.customCraftingMaterial = Item.ingotIron;
		ELROS.customCraftingMaterial = Item.ingotIron;
		FEANOR.customCraftingMaterial = Item.ingotIron;
		GILGALAD.customCraftingMaterial = Item.ingotIron;
		GIMLI.customCraftingMaterial = Item.ingotIron;
		ISILDUR.customCraftingMaterial = Item.ingotIron;
		JIINDUR.customCraftingMaterial = Item.ingotIron;
		KHAMUL.customCraftingMaterial = Item.ingotIron;
		KHOMMURAT.customCraftingMaterial = Item.ingotIron;
		MORGOMIR.customCraftingMaterial = Item.ingotIron;
		THEODEN.customCraftingMaterial = Item.ingotIron;
		TURGON.customCraftingMaterial = Item.ingotIron;
	}
}