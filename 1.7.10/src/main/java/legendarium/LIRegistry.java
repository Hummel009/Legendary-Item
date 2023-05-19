package legendarium;

import java.util.ArrayList;

import com.google.common.base.CaseFormat;

import cpw.mods.fml.common.registry.GameRegistry;
import legendarium.replacer.LIItemMace;
import legendarium.replacer.LIItemSpear;
import legendarium.replacer.LIItemStaff;
import legendarium.replacer.LIItemSwordGlowing;
import legendarium.replacer.LIItemSwordUsual;
import lotr.common.LOTRCreativeTabs;
import lotr.common.item.LOTRItemBow;
import lotr.common.item.LOTRItemCrossbow;
import lotr.common.item.LOTRMaterial;
import net.minecraft.item.Item;

public class LIRegistry {
	public static final ArrayList<Item> CONTENT = new ArrayList<>();

	public static Item armorAnarionHelmet;
	public static Item armorAnarionChestplate;
	public static Item armorAnarionLegs;
	public static Item armorAnarionBoots;

	public static Item armorArpharazonHelmet;
	public static Item armorArpharazonChestplate;
	public static Item armorArpharazonLegs;
	public static Item armorArpharazonBoots;

	public static Item armorArveduiHelmet;
	public static Item armorArveduiChestplate;
	public static Item armorArveduiLegs;
	public static Item armorArveduiBoots;

	public static Item armorBoromirChestplate;
	public static Item armorBoromirLegs;
	public static Item armorBoromirBoots;

	public static Item armorElendilHelmet;
	public static Item armorElendilChestplate;
	public static Item armorElendilLegs;
	public static Item armorElendilBoots;

	public static Item armorElrosHelmet;
	public static Item armorElrosChestplate;
	public static Item armorElrosLegs;
	public static Item armorElrosBoots;

	public static Item armorFeanorHelmet;
	public static Item armorFeanorChestplate;
	public static Item armorFeanorLegs;
	public static Item armorFeanorBoots;

	public static Item armorGilgaladHelmet;
	public static Item armorGilgaladChestplate;
	public static Item armorGilgaladLegs;
	public static Item armorGilgaladBoots;

	public static Item armorGimliHelmet;
	public static Item armorGimliChestplate;
	public static Item armorGimliLegs;
	public static Item armorGimliBoots;

	public static Item armorIsildurHelmet;
	public static Item armorIsildurChestplate;
	public static Item armorIsildurLegs;
	public static Item armorIsildurBoots;

	public static Item armorJiindurHelmet;
	public static Item armorJiindurChestplate;
	public static Item armorJiindurLegs;
	public static Item armorJiindurBoots;

	public static Item armorKhamulHelmet;
	public static Item armorKhamulChestplate;
	public static Item armorKhamulLegs;
	public static Item armorKhamulBoots;

	public static Item armorKhommuratHelmet;
	public static Item armorKhommuratChestplate;
	public static Item armorKhommuratLegs;
	public static Item armorKhommuratBoots;

	public static Item armorMorgomirHelmet;
	public static Item armorMorgomirChestplate;
	public static Item armorMorgomirLegs;
	public static Item armorMorgomirBoots;

	public static Item armorTheodenHelmet;
	public static Item armorTheodenChestplate;
	public static Item armorTheodenLegs;
	public static Item armorTheodenBoots;

	public static Item armorTurgonHelmet;
	public static Item armorTurgonChestplate;
	public static Item armorTurgonLegs;
	public static Item armorTurgonBoots;

	public static Item weaponAcharn;
	public static Item weaponAeglos;
	public static Item weaponAlatar;
	public static Item weaponAngrist;
	public static Item weaponAnguirel;
	public static Item weaponAranruth;
	public static Item weaponAzog;
	public static Item weaponBalin;
	public static Item weaponBarazanthual;
	public static Item weaponBolg;
	public static Item weaponBoromir;
	public static Item weaponCeleborn;
	public static Item weaponDagmor;
	public static Item weaponDain;
	public static Item weaponDenethor;
	public static Item weaponDori;
	public static Item weaponDramborleg;
	public static Item weaponDurin;
	public static Item weaponDwalin;
	public static Item weaponEothain;
	public static Item weaponEowyn;
	public static Item weaponFaramir;
	public static Item weaponGamling;
	public static Item weaponGimli;
	public static Item weaponGirion;
	public static Item weaponGoblinking;
	public static Item weaponGorbag;
	public static Item weaponGothmog;
	public static Item weaponGrima;
	public static Item weaponGurthang;
	public static Item weaponGuthwine;
	public static Item weaponHadhafang;
	public static Item weaponHerugrim;
	public static Item weaponKhamul;
	public static Item weaponKili;
	public static Item weaponLegolas;
	public static Item weaponMelkor;
	public static Item weaponMouthofsauron;
	public static Item weaponNarcil;
	public static Item weaponNazgul;
	public static Item weaponOrcrist;
	public static Item weaponPallando;
	public static Item weaponRadagast;
	public static Item weaponSaruman;
	public static Item weaponShagrat;
	public static Item weaponThorin;
	public static Item weaponThorondun;
	public static Item weaponThrain;
	public static Item weaponThranduil;
	public static Item weaponThror;
	public static Item weaponUrfael;
	public static Item weaponWitchking;

	public static Item rangedAzkar;
	public static Item rangedBard;
	public static Item rangedBelthronding;
	public static Item rangedBregor;
	public static Item rangedHaldir;
	public static Item rangedLegolas;
	public static Item rangedLurtz;

	public static Item arkenstone;
	public static Item silmaril;

	public static void preInit() {
		armorAnarionBoots = new LIArmor(LIArmor.ANARION, 3);
		armorAnarionChestplate = new LIArmor(LIArmor.ANARION, 1);
		armorAnarionHelmet = new LIArmor(LIArmor.ANARION, 0);
		armorAnarionLegs = new LIArmor(LIArmor.ANARION, 2);

		armorArpharazonBoots = new LIArmor(LIArmor.ARPHARAZON, 3);
		armorArpharazonChestplate = new LIArmor(LIArmor.ARPHARAZON, 1);
		armorArpharazonHelmet = new LIArmor(LIArmor.ARPHARAZON, 0);
		armorArpharazonLegs = new LIArmor(LIArmor.ARPHARAZON, 2);

		armorArveduiBoots = new LIArmor(LIArmor.ARVEDUI, 3);
		armorArveduiChestplate = new LIArmor(LIArmor.ARVEDUI, 1);
		armorArveduiHelmet = new LIArmor(LIArmor.ARVEDUI, 0);
		armorArveduiLegs = new LIArmor(LIArmor.ARVEDUI, 2);

		armorBoromirBoots = new LIArmor(LIArmor.BOROMIR, 3);
		armorBoromirChestplate = new LIArmor(LIArmor.BOROMIR, 1);
		armorBoromirLegs = new LIArmor(LIArmor.BOROMIR, 2);

		armorElendilBoots = new LIArmor(LIArmor.ELENDIL, 3);
		armorElendilChestplate = new LIArmor(LIArmor.ELENDIL, 1);
		armorElendilHelmet = new LIArmor(LIArmor.ELENDIL, 0);
		armorElendilLegs = new LIArmor(LIArmor.ELENDIL, 2);

		armorElrosBoots = new LIArmor(LIArmor.ELROS, 3);
		armorElrosChestplate = new LIArmor(LIArmor.ELROS, 1);
		armorElrosHelmet = new LIArmor(LIArmor.ELROS, 0);
		armorElrosLegs = new LIArmor(LIArmor.ELROS, 2);

		armorFeanorBoots = new LIArmor(LIArmor.FEANOR, 3);
		armorFeanorChestplate = new LIArmor(LIArmor.FEANOR, 1);
		armorFeanorHelmet = new LIArmor(LIArmor.FEANOR, 0);
		armorFeanorLegs = new LIArmor(LIArmor.FEANOR, 2);

		armorGilgaladBoots = new LIArmor(LIArmor.GILGALAD, 3);
		armorGilgaladChestplate = new LIArmor(LIArmor.GILGALAD, 1);
		armorGilgaladHelmet = new LIArmor(LIArmor.GILGALAD, 0);
		armorGilgaladLegs = new LIArmor(LIArmor.GILGALAD, 2);

		armorGimliBoots = new LIArmor(LIArmor.GIMLI, 3);
		armorGimliChestplate = new LIArmor(LIArmor.GIMLI, 1);
		armorGimliHelmet = new LIArmor(LIArmor.GIMLI, 0);
		armorGimliLegs = new LIArmor(LIArmor.GIMLI, 2);

		armorIsildurBoots = new LIArmor(LIArmor.ISILDUR, 3);
		armorIsildurChestplate = new LIArmor(LIArmor.ISILDUR, 1);
		armorIsildurHelmet = new LIArmor(LIArmor.ISILDUR, 0);
		armorIsildurLegs = new LIArmor(LIArmor.ISILDUR, 2);

		armorJiindurBoots = new LIArmor(LIArmor.JIINDUR, 3);
		armorJiindurChestplate = new LIArmor(LIArmor.JIINDUR, 1);
		armorJiindurHelmet = new LIArmor(LIArmor.JIINDUR, 0);
		armorJiindurLegs = new LIArmor(LIArmor.JIINDUR, 2);

		armorKhamulBoots = new LIArmor(LIArmor.KHAMUL, 3);
		armorKhamulChestplate = new LIArmor(LIArmor.KHAMUL, 1);
		armorKhamulHelmet = new LIArmor(LIArmor.KHAMUL, 0);
		armorKhamulLegs = new LIArmor(LIArmor.KHAMUL, 2);

		armorKhommuratBoots = new LIArmor(LIArmor.KHOMMURAT, 3);
		armorKhommuratChestplate = new LIArmor(LIArmor.KHOMMURAT, 1);
		armorKhommuratHelmet = new LIArmor(LIArmor.KHOMMURAT, 0);
		armorKhommuratLegs = new LIArmor(LIArmor.KHOMMURAT, 2);

		armorMorgomirBoots = new LIArmor(LIArmor.MORGOMIR, 3);
		armorMorgomirChestplate = new LIArmor(LIArmor.MORGOMIR, 1);
		armorMorgomirHelmet = new LIArmor(LIArmor.MORGOMIR, 0);
		armorMorgomirLegs = new LIArmor(LIArmor.MORGOMIR, 2);

		armorTheodenBoots = new LIArmor(LIArmor.THEODEN, 3);
		armorTheodenChestplate = new LIArmor(LIArmor.THEODEN, 1);
		armorTheodenHelmet = new LIArmor(LIArmor.THEODEN, 0);
		armorTheodenLegs = new LIArmor(LIArmor.THEODEN, 2);

		armorTurgonBoots = new LIArmor(LIArmor.TURGON, 3);
		armorTurgonChestplate = new LIArmor(LIArmor.TURGON, 1);
		armorTurgonHelmet = new LIArmor(LIArmor.TURGON, 0);
		armorTurgonLegs = new LIArmor(LIArmor.TURGON, 2);

		weaponAcharn = new LIItemSwordUsual();
		weaponAeglos = new LIItemSpear();
		weaponAlatar = new LIItemStaff();
		weaponAngrist = new LIItemSwordUsual();
		weaponAnguirel = new LIItemSwordUsual();
		weaponAranruth = new LIItemSwordGlowing();
		weaponAzog = new LIItemSwordUsual();
		weaponBalin = new LIItemSwordUsual();
		weaponBarazanthual = new LIItemSwordUsual();
		weaponBolg = new LIItemSwordUsual();
		weaponBoromir = new LIItemSwordUsual();
		weaponCeleborn = new LIItemSwordGlowing();
		weaponDagmor = new LIItemSwordUsual();
		weaponDain = new LIItemSwordUsual();
		weaponDenethor = new LIItemSwordUsual();
		weaponDori = new LIItemSwordUsual();
		weaponDramborleg = new LIItemSwordUsual();
		weaponDurin = new LIItemSwordUsual();
		weaponDwalin = new LIItemSwordUsual();
		weaponEothain = new LIItemSwordUsual();
		weaponEowyn = new LIItemSwordUsual();
		weaponFaramir = new LIItemSwordUsual();
		weaponGamling = new LIItemSwordUsual();
		weaponGimli = new LIItemSwordUsual();
		weaponGirion = new LIItemSwordUsual();
		weaponGoblinking = new LIItemMace();
		weaponGorbag = new LIItemSwordUsual();
		weaponGothmog = new LIItemSwordUsual();
		weaponGrima = new LIItemSwordUsual();
		weaponGurthang = new LIItemSwordUsual();
		weaponGuthwine = new LIItemSwordUsual();
		weaponHadhafang = new LIItemSwordGlowing();
		weaponHerugrim = new LIItemSwordUsual();
		weaponKhamul = new LIItemSwordUsual();
		weaponKili = new LIItemSwordUsual();
		weaponLegolas = new LIItemSwordUsual();
		weaponMelkor = new LIItemMace();
		weaponMouthofsauron = new LIItemSwordUsual();
		weaponNarcil = new LIItemSwordUsual();
		weaponNazgul = new LIItemSwordUsual();
		weaponOrcrist = new LIItemSwordGlowing();
		weaponPallando = new LIItemStaff();
		weaponRadagast = new LIItemStaff();
		weaponSaruman = new LIItemMace();
		weaponShagrat = new LIItemSwordUsual();
		weaponThorin = new LIItemSwordUsual();
		weaponThorondun = new LIItemSwordGlowing();
		weaponThrain = new LIItemSwordUsual();
		weaponThranduil = new LIItemSwordGlowing();
		weaponThror = new LIItemSwordUsual();
		weaponUrfael = new LIItemSwordUsual();
		weaponWitchking = new LIItemMace();

		rangedAzkar = new LOTRItemBow(LOTRMaterial.HIGH_ELVEN, 1.25).setDrawTime(16).setCreativeTab(LOTRCreativeTabs.tabStory);
		rangedBard = new LOTRItemBow(LOTRMaterial.DALE, 1.25).setDrawTime(16).setCreativeTab(LOTRCreativeTabs.tabStory);
		rangedBelthronding = new LOTRItemBow(LOTRMaterial.HIGH_ELVEN, 1.25).setDrawTime(16).setCreativeTab(LOTRCreativeTabs.tabStory);
		rangedBregor = new LOTRItemBow(LOTRMaterial.RANGER, 1.25).setDrawTime(16).setCreativeTab(LOTRCreativeTabs.tabStory);
		rangedHaldir = new LOTRItemBow(LOTRMaterial.GALADHRIM, 1.25).setDrawTime(16).setCreativeTab(LOTRCreativeTabs.tabStory);
		rangedLegolas = new LOTRItemBow(LOTRMaterial.HIGH_ELVEN, 1.25).setDrawTime(16).setCreativeTab(LOTRCreativeTabs.tabStory);
		rangedLurtz = new LOTRItemCrossbow(LOTRMaterial.URUK).setCreativeTab(LOTRCreativeTabs.tabStory);

		silmaril = new Item().setCreativeTab(LOTRCreativeTabs.tabStory).setMaxStackSize(1);
		arkenstone = new Item().setCreativeTab(LOTRCreativeTabs.tabStory).setMaxStackSize(1);

		register(armorAnarionHelmet, "armorAnarionHelmet");
		register(armorAnarionChestplate, "armorAnarionChestplate");
		register(armorAnarionLegs, "armorAnarionLegs");
		register(armorAnarionBoots, "armorAnarionBoots");

		register(armorArpharazonHelmet, "armorArpharazonHelmet");
		register(armorArpharazonChestplate, "armorArpharazonChestplate");
		register(armorArpharazonLegs, "armorArpharazonLegs");
		register(armorArpharazonBoots, "armorArpharazonBoots");

		register(armorArveduiHelmet, "armorArveduiHelmet");
		register(armorArveduiChestplate, "armorArveduiChestplate");
		register(armorArveduiLegs, "armorArveduiLegs");
		register(armorArveduiBoots, "armorArveduiBoots");

		register(armorBoromirChestplate, "armorBoromirChestplate");
		register(armorBoromirLegs, "armorBoromirLegs");
		register(armorBoromirBoots, "armorBoromirBoots");

		register(armorElendilHelmet, "armorElendilHelmet");
		register(armorElendilChestplate, "armorElendilChestplate");
		register(armorElendilLegs, "armorElendilLegs");
		register(armorElendilBoots, "armorElendilBoots");

		register(armorElrosHelmet, "armorElrosHelmet");
		register(armorElrosChestplate, "armorElrosChestplate");
		register(armorElrosLegs, "armorElrosLegs");
		register(armorElrosBoots, "armorElrosBoots");

		register(armorFeanorHelmet, "armorFeanorHelmet");
		register(armorFeanorChestplate, "armorFeanorChestplate");
		register(armorFeanorLegs, "armorFeanorLegs");
		register(armorFeanorBoots, "armorFeanorBoots");

		register(armorGilgaladHelmet, "armorGilgaladHelmet");
		register(armorGilgaladChestplate, "armorGilgaladChestplate");
		register(armorGilgaladLegs, "armorGilgaladLegs");
		register(armorGilgaladBoots, "armorGilgaladBoots");

		register(armorGimliHelmet, "armorGimliHelmet");
		register(armorGimliChestplate, "armorGimliChestplate");
		register(armorGimliLegs, "armorGimliLegs");
		register(armorGimliBoots, "armorGimliBoots");

		register(armorIsildurHelmet, "armorIsildurHelmet");
		register(armorIsildurChestplate, "armorIsildurChestplate");
		register(armorIsildurLegs, "armorIsildurLegs");
		register(armorIsildurBoots, "armorIsildurBoots");

		register(armorJiindurHelmet, "armorJiindurHelmet");
		register(armorJiindurChestplate, "armorJiindurChestplate");
		register(armorJiindurLegs, "armorJiindurLegs");
		register(armorJiindurBoots, "armorJiindurBoots");

		register(armorKhamulHelmet, "armorKhamulHelmet");
		register(armorKhamulChestplate, "armorKhamulChestplate");
		register(armorKhamulLegs, "armorKhamulLegs");
		register(armorKhamulBoots, "armorKhamulBoots");

		register(armorKhommuratHelmet, "armorKhommuratHelmet");
		register(armorKhommuratChestplate, "armorKhommuratChestplate");
		register(armorKhommuratLegs, "armorKhommuratLegs");
		register(armorKhommuratBoots, "armorKhommuratBoots");

		register(armorMorgomirHelmet, "armorMorgomirHelmet");
		register(armorMorgomirChestplate, "armorMorgomirChestplate");
		register(armorMorgomirLegs, "armorMorgomirLegs");
		register(armorMorgomirBoots, "armorMorgomirBoots");

		register(armorTheodenHelmet, "armorTheodenHelmet");
		register(armorTheodenChestplate, "armorTheodenChestplate");
		register(armorTheodenLegs, "armorTheodenLegs");
		register(armorTheodenBoots, "armorTheodenBoots");

		register(armorTurgonHelmet, "armorTurgonHelmet");
		register(armorTurgonChestplate, "armorTurgonChestplate");
		register(armorTurgonLegs, "armorTurgonLegs");
		register(armorTurgonBoots, "armorTurgonBoots");

		register(weaponAcharn, "weaponAcharn");
		register(weaponAeglos, "weaponAeglos");
		register(weaponAlatar, "weaponAlatar");
		register(weaponAngrist, "weaponAngrist");
		register(weaponAnguirel, "weaponAnguirel");
		register(weaponAranruth, "weaponAranruth");
		register(weaponAzog, "weaponAzog");
		register(weaponBalin, "weaponBalin");
		register(weaponBarazanthual, "weaponBarazanthual");
		register(weaponBolg, "weaponBolg");
		register(weaponBoromir, "weaponBoromir");
		register(weaponCeleborn, "weaponCeleborn");
		register(weaponDagmor, "weaponDagmor");
		register(weaponDain, "weaponDain");
		register(weaponDenethor, "weaponDenethor");
		register(weaponDori, "weaponDori");
		register(weaponDramborleg, "weaponDramborleg");
		register(weaponDurin, "weaponDurin");
		register(weaponDwalin, "weaponDwalin");
		register(weaponEothain, "weaponEothain");
		register(weaponEowyn, "weaponEowyn");
		register(weaponFaramir, "weaponFaramir");
		register(weaponGamling, "weaponGamling");
		register(weaponGimli, "weaponGimli");
		register(weaponGirion, "weaponGirion");
		register(weaponGoblinking, "weaponGoblinking");
		register(weaponGorbag, "weaponGorbag");
		register(weaponGothmog, "weaponGothmog");
		register(weaponGrima, "weaponGrima");
		register(weaponGurthang, "weaponGurthang");
		register(weaponGuthwine, "weaponGuthwine");
		register(weaponHadhafang, "weaponHadhafang");
		register(weaponHerugrim, "weaponHerugrim");
		register(weaponKhamul, "weaponKhamul");
		register(weaponKili, "weaponKili");
		register(weaponLegolas, "weaponLegolas");
		register(weaponMelkor, "weaponMelkor");
		register(weaponMouthofsauron, "weaponMouthofsauron");
		register(weaponNarcil, "weaponNarcil");
		register(weaponNazgul, "weaponNazgul");
		register(weaponOrcrist, "weaponOrcrist");
		register(weaponPallando, "weaponPallando");
		register(weaponRadagast, "weaponRadagast");
		register(weaponSaruman, "weaponSaruman");
		register(weaponShagrat, "weaponShagrat");
		register(weaponThorin, "weaponThorin");
		register(weaponThorondun, "weaponThorondun");
		register(weaponThrain, "weaponThrain");
		register(weaponThranduil, "weaponThranduil");
		register(weaponThror, "weaponThror");
		register(weaponUrfael, "weaponUrfael");
		register(weaponWitchking, "weaponWitchking");

		register(rangedAzkar, "rangedAzkar");
		register(rangedBard, "rangedBard");
		register(rangedBelthronding, "rangedBelthronding");
		register(rangedBregor, "rangedBregor");
		register(rangedHaldir, "rangedHaldir");
		register(rangedLegolas, "rangedLegolas");
		register(rangedLurtz, "rangedLurtz");

		register(arkenstone, "arkenstone");
		register(silmaril, "silmaril");
	}

	public static void register(Item item, String field) {
		String name = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field);
		item.setUnlocalizedName(name);
		item.setTextureName("legendarium:" + name);
		GameRegistry.registerItem(item, name);
	}
}
