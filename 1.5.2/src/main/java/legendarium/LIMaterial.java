package legendarium;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
		ANARION.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		ARPHARAZON.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		ARVEDUI.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		BOROMIR.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		ELENDIL.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		ELROS.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		FEANOR.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		GILGALAD.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		GIMLI.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		ISILDUR.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		JIINDUR.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		KHAMUL.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		KHOMMURAT.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		MORGOMIR.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		THEODEN.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
		TURGON.customCraftingMaterial = new ItemStack(Item.ingotIron).getItem();
	}
}