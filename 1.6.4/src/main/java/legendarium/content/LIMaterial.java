package legendarium.content;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;

public class LIMaterial {
	public static final EnumArmorMaterial ANARION = EnumHelper.addArmorMaterial("anarion", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial ARPHARAZON = EnumHelper.addArmorMaterial("arpharazon", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial ARVEDUI = EnumHelper.addArmorMaterial("arvedui", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial BOROMIR = EnumHelper.addArmorMaterial("boromir", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial ELENDIL = EnumHelper.addArmorMaterial("elendil", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial ELROS = EnumHelper.addArmorMaterial("elros", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial FEANOR = EnumHelper.addArmorMaterial("feanor", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial GILGALAD = EnumHelper.addArmorMaterial("gilgalad", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial GIMLI = EnumHelper.addArmorMaterial("gimli", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial ISILDUR = EnumHelper.addArmorMaterial("isildur", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial JIINDUR = EnumHelper.addArmorMaterial("jiindur", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial KHAMUL = EnumHelper.addArmorMaterial("khamul", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial KHOMMURAT = EnumHelper.addArmorMaterial("khommurat", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial MORGOMIR = EnumHelper.addArmorMaterial("morgomir", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial THEODEN = EnumHelper.addArmorMaterial("theoden", 33, new int[]{3, 8, 6, 3}, 10);
	public static final EnumArmorMaterial TURGON = EnumHelper.addArmorMaterial("turgon", 33, new int[]{3, 8, 6, 3}, 10);

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