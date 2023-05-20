package legendarium;

import java.util.Objects;

import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class LIMaterial {
	public static final ArmorMaterial ANARION = Objects.requireNonNull(EnumHelper.addArmorMaterial("anarion", "anarion", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial ARPHARAZON = Objects.requireNonNull(EnumHelper.addArmorMaterial("arpharazon", "arpharazon", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial ARVEDUI = Objects.requireNonNull(EnumHelper.addArmorMaterial("arvedui", "arvedui", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial BOROMIR = Objects.requireNonNull(EnumHelper.addArmorMaterial("boromir", "boromir", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial ELENDIL = Objects.requireNonNull(EnumHelper.addArmorMaterial("elendil", "elendil", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial ELROS = Objects.requireNonNull(EnumHelper.addArmorMaterial("elros", "elros", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial FEANOR = Objects.requireNonNull(EnumHelper.addArmorMaterial("feanor", "feanor", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial GILGALAD = Objects.requireNonNull(EnumHelper.addArmorMaterial("gilgalad", "gilgalad", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial GIMLI = Objects.requireNonNull(EnumHelper.addArmorMaterial("gimli", "gimli", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial ISILDUR = Objects.requireNonNull(EnumHelper.addArmorMaterial("isildur", "isildur", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial JIINDUR = Objects.requireNonNull(EnumHelper.addArmorMaterial("jiindur", "jiindur", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial KHAMUL = Objects.requireNonNull(EnumHelper.addArmorMaterial("khamul", "khamul", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial KHOMMURAT = Objects.requireNonNull(EnumHelper.addArmorMaterial("khommurat", "khommurat", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial MORGOMIR = Objects.requireNonNull(EnumHelper.addArmorMaterial("morgomir", "morgomir", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial THEODEN = Objects.requireNonNull(EnumHelper.addArmorMaterial("theoden", "theoden", 25, new int[]{2, 5, 6, 2}, 9));
	public static final ArmorMaterial TURGON = Objects.requireNonNull(EnumHelper.addArmorMaterial("turgon", "turgon", 25, new int[]{2, 5, 6, 2}, 9));
	
	static {
		ANARION.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		ARPHARAZON.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		ARVEDUI.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		BOROMIR.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		ELENDIL.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		ELROS.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		FEANOR.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		GILGALAD.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		GIMLI.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		ISILDUR.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		JIINDUR.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		KHAMUL.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		KHOMMURAT.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		MORGOMIR.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		THEODEN.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
		TURGON.customCraftingMaterial = new ItemStack(Items.iron_ingot).getItem();
	}
}