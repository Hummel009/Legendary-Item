package legendarium;

import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Objects;

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