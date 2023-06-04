package legendarium;

import com.google.common.base.CaseFormat;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Item;

@Mod(modid = "legendarium", useMetadata = true)
public class LI {
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

	public static Item arkenstone;
	public static Item silmaril;

	public static void register(Item item, String field) {
		String name = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field);
		item.setTextureFile("/assets/legendarium/textures/items.png");
		LIObfuscationHelper.setItemName(item, name);
		LIObfuscationHelper.setCreativeTab(item, LICreativeTabs.TAB_ARTIFACTS);
		LanguageRegistry.instance().addNameForObject(item, "ru_RU", LILang.ruRU.get("item." + name + ".name"));
		LanguageRegistry.instance().addNameForObject(item, "en_US", LILang.enUS.get("item." + name + ".name"));
	}

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		LIConfig.preInit(event);
	}

	@Init
	public void onInit(FMLInitializationEvent event) {
		armorAnarionHelmet = new LIItemArmor(LIConfig.idArmorAnarionHelmet - 256, LIMaterial.ANARION, 0);
		armorAnarionChestplate = new LIItemArmor(LIConfig.idArmorAnarionChestplate - 256, LIMaterial.ANARION, 1);
		armorAnarionLegs = new LIItemArmor(LIConfig.idArmorAnarionLegs - 256, LIMaterial.ANARION, 2);
		armorAnarionBoots = new LIItemArmor(LIConfig.idArmorAnarionBoots - 256, LIMaterial.ANARION, 3);

		armorArpharazonHelmet = new LIItemArmor(LIConfig.idArmorArpharazonHelmet - 256, LIMaterial.ARPHARAZON, 0);
		armorArpharazonChestplate = new LIItemArmor(LIConfig.idArmorArpharazonChestplate - 256, LIMaterial.ARPHARAZON, 1);
		armorArpharazonLegs = new LIItemArmor(LIConfig.idArmorArpharazonLegs - 256, LIMaterial.ARPHARAZON, 2);
		armorArpharazonBoots = new LIItemArmor(LIConfig.idArmorArpharazonBoots - 256, LIMaterial.ARPHARAZON, 3);

		armorArveduiHelmet = new LIItemArmor(LIConfig.idArmorArveduiHelmet - 256, LIMaterial.ARVEDUI, 0);
		armorArveduiChestplate = new LIItemArmor(LIConfig.idArmorArveduiChestplate - 256, LIMaterial.ARVEDUI, 1);
		armorArveduiLegs = new LIItemArmor(LIConfig.idArmorArveduiLegs - 256, LIMaterial.ARVEDUI, 2);
		armorArveduiBoots = new LIItemArmor(LIConfig.idArmorArveduiBoots - 256, LIMaterial.ARVEDUI, 3);

		armorBoromirChestplate = new LIItemArmor(LIConfig.idArmorBoromirChestplate - 256, LIMaterial.BOROMIR, 1);
		armorBoromirLegs = new LIItemArmor(LIConfig.idArmorBoromirLegs - 256, LIMaterial.BOROMIR, 2);
		armorBoromirBoots = new LIItemArmor(LIConfig.idArmorBoromirBoots - 256, LIMaterial.BOROMIR, 3);

		armorElendilHelmet = new LIItemArmor(LIConfig.idArmorElendilHelmet - 256, LIMaterial.ELENDIL, 0);
		armorElendilChestplate = new LIItemArmor(LIConfig.idArmorElendilChestplate - 256, LIMaterial.ELENDIL, 1);
		armorElendilLegs = new LIItemArmor(LIConfig.idArmorElendilLegs - 256, LIMaterial.ELENDIL, 2);
		armorElendilBoots = new LIItemArmor(LIConfig.idArmorElendilBoots - 256, LIMaterial.ELENDIL, 3);

		armorElrosHelmet = new LIItemArmor(LIConfig.idArmorElrosHelmet - 256, LIMaterial.ELROS, 0);
		armorElrosChestplate = new LIItemArmor(LIConfig.idArmorElrosChestplate - 256, LIMaterial.ELROS, 1);
		armorElrosLegs = new LIItemArmor(LIConfig.idArmorElrosLegs - 256, LIMaterial.ELROS, 2);
		armorElrosBoots = new LIItemArmor(LIConfig.idArmorElrosBoots - 256, LIMaterial.ELROS, 3);

		armorFeanorHelmet = new LIItemArmor(LIConfig.idArmorFeanorHelmet - 256, LIMaterial.FEANOR, 0);
		armorFeanorChestplate = new LIItemArmor(LIConfig.idArmorFeanorChestplate - 256, LIMaterial.FEANOR, 1);
		armorFeanorLegs = new LIItemArmor(LIConfig.idArmorFeanorLegs - 256, LIMaterial.FEANOR, 2);
		armorFeanorBoots = new LIItemArmor(LIConfig.idArmorFeanorBoots - 256, LIMaterial.FEANOR, 3);

		armorGilgaladHelmet = new LIItemArmor(LIConfig.idArmorGilgaladHelmet - 256, LIMaterial.GILGALAD, 0);
		armorGilgaladChestplate = new LIItemArmor(LIConfig.idArmorGilgaladChestplate - 256, LIMaterial.GILGALAD, 1);
		armorGilgaladLegs = new LIItemArmor(LIConfig.idArmorGilgaladLegs - 256, LIMaterial.GILGALAD, 2);
		armorGilgaladBoots = new LIItemArmor(LIConfig.idArmorGilgaladBoots - 256, LIMaterial.GILGALAD, 3);

		armorGimliHelmet = new LIItemArmor(LIConfig.idArmorGimliHelmet - 256, LIMaterial.GIMLI, 0);
		armorGimliChestplate = new LIItemArmor(LIConfig.idArmorGimliChestplate - 256, LIMaterial.GIMLI, 1);
		armorGimliLegs = new LIItemArmor(LIConfig.idArmorGimliLegs - 256, LIMaterial.GIMLI, 2);
		armorGimliBoots = new LIItemArmor(LIConfig.idArmorGimliBoots - 256, LIMaterial.GIMLI, 3);

		armorIsildurHelmet = new LIItemArmor(LIConfig.idArmorIsildurHelmet - 256, LIMaterial.ISILDUR, 0);
		armorIsildurChestplate = new LIItemArmor(LIConfig.idArmorIsildurChestplate - 256, LIMaterial.ISILDUR, 1);
		armorIsildurLegs = new LIItemArmor(LIConfig.idArmorIsildurLegs - 256, LIMaterial.ISILDUR, 2);
		armorIsildurBoots = new LIItemArmor(LIConfig.idArmorIsildurBoots - 256, LIMaterial.ISILDUR, 3);

		armorJiindurHelmet = new LIItemArmor(LIConfig.idArmorJiindurHelmet - 256, LIMaterial.JIINDUR, 0);
		armorJiindurChestplate = new LIItemArmor(LIConfig.idArmorJiindurChestplate - 256, LIMaterial.JIINDUR, 1);
		armorJiindurLegs = new LIItemArmor(LIConfig.idArmorJiindurLegs - 256, LIMaterial.JIINDUR, 2);
		armorJiindurBoots = new LIItemArmor(LIConfig.idArmorJiindurBoots - 256, LIMaterial.JIINDUR, 3);

		armorKhamulHelmet = new LIItemArmor(LIConfig.idArmorKhamulHelmet - 256, LIMaterial.KHAMUL, 0);
		armorKhamulChestplate = new LIItemArmor(LIConfig.idArmorKhamulChestplate - 256, LIMaterial.KHAMUL, 1);
		armorKhamulLegs = new LIItemArmor(LIConfig.idArmorKhamulLegs - 256, LIMaterial.KHAMUL, 2);
		armorKhamulBoots = new LIItemArmor(LIConfig.idArmorKhamulBoots - 256, LIMaterial.KHAMUL, 3);

		armorKhommuratHelmet = new LIItemArmor(LIConfig.idArmorKhommuratHelmet - 256, LIMaterial.KHOMMURAT, 0);
		armorKhommuratChestplate = new LIItemArmor(LIConfig.idArmorKhommuratChestplate - 256, LIMaterial.KHOMMURAT, 1);
		armorKhommuratLegs = new LIItemArmor(LIConfig.idArmorKhommuratLegs - 256, LIMaterial.KHOMMURAT, 2);
		armorKhommuratBoots = new LIItemArmor(LIConfig.idArmorKhommuratBoots - 256, LIMaterial.KHOMMURAT, 3);

		armorMorgomirHelmet = new LIItemArmor(LIConfig.idArmorMorgomirHelmet - 256, LIMaterial.MORGOMIR, 0);
		armorMorgomirChestplate = new LIItemArmor(LIConfig.idArmorMorgomirChestplate - 256, LIMaterial.MORGOMIR, 1);
		armorMorgomirLegs = new LIItemArmor(LIConfig.idArmorMorgomirLegs - 256, LIMaterial.MORGOMIR, 2);
		armorMorgomirBoots = new LIItemArmor(LIConfig.idArmorMorgomirBoots - 256, LIMaterial.MORGOMIR, 3);

		armorTheodenHelmet = new LIItemArmor(LIConfig.idArmorTheodenHelmet - 256, LIMaterial.THEODEN, 0);
		armorTheodenChestplate = new LIItemArmor(LIConfig.idArmorTheodenChestplate - 256, LIMaterial.THEODEN, 1);
		armorTheodenLegs = new LIItemArmor(LIConfig.idArmorTheodenLegs - 256, LIMaterial.THEODEN, 2);
		armorTheodenBoots = new LIItemArmor(LIConfig.idArmorTheodenBoots - 256, LIMaterial.THEODEN, 3);

		armorTurgonHelmet = new LIItemArmor(LIConfig.idArmorTurgonHelmet - 256, LIMaterial.TURGON, 0);
		armorTurgonChestplate = new LIItemArmor(LIConfig.idArmorTurgonChestplate - 256, LIMaterial.TURGON, 1);
		armorTurgonLegs = new LIItemArmor(LIConfig.idArmorTurgonLegs - 256, LIMaterial.TURGON, 2);
		armorTurgonBoots = new LIItemArmor(LIConfig.idArmorTurgonBoots - 256, LIMaterial.TURGON, 3);

		weaponAcharn = new LIItemSword(LIConfig.idWeaponAcharn - 256);
		weaponAeglos = new LIItemSword(LIConfig.idWeaponAeglos - 256);
		weaponAlatar = new LIItemSword(LIConfig.idWeaponAlatar - 256);
		weaponAngrist = new LIItemSword(LIConfig.idWeaponAngrist - 256);
		weaponAnguirel = new LIItemSword(LIConfig.idWeaponAnguirel - 256);
		weaponAranruth = new LIItemSword(LIConfig.idWeaponAranruth - 256);
		weaponAzog = new LIItemSword(LIConfig.idWeaponAzog - 256);
		weaponBalin = new LIItemSword(LIConfig.idWeaponBalin - 256);
		weaponBarazanthual = new LIItemSword(LIConfig.idWeaponBarazanthual - 256);
		weaponBolg = new LIItemSword(LIConfig.idWeaponBolg - 256);
		weaponBoromir = new LIItemSword(LIConfig.idWeaponBoromir - 256);
		weaponCeleborn = new LIItemSword(LIConfig.idWeaponCeleborn - 256);
		weaponDagmor = new LIItemSword(LIConfig.idWeaponDagmor - 256);
		weaponDain = new LIItemSword(LIConfig.idWeaponDain - 256);
		weaponDenethor = new LIItemSword(LIConfig.idWeaponDenethor - 256);
		weaponDori = new LIItemSword(LIConfig.idWeaponDori - 256);
		weaponDramborleg = new LIItemSword(LIConfig.idWeaponDramborleg - 256);
		weaponDurin = new LIItemSword(LIConfig.idWeaponDurin - 256);
		weaponDwalin = new LIItemSword(LIConfig.idWeaponDwalin - 256);
		weaponEothain = new LIItemSword(LIConfig.idWeaponEothain - 256);
		weaponEowyn = new LIItemSword(LIConfig.idWeaponEowyn - 256);
		weaponFaramir = new LIItemSword(LIConfig.idWeaponFaramir - 256);
		weaponGamling = new LIItemSword(LIConfig.idWeaponGamling - 256);
		weaponGimli = new LIItemSword(LIConfig.idWeaponGimli - 256);
		weaponGirion = new LIItemSword(LIConfig.idWeaponGirion - 256);
		weaponGoblinking = new LIItemSword(LIConfig.idWeaponGoblinking - 256);
		weaponGorbag = new LIItemSword(LIConfig.idWeaponGorbag - 256);
		weaponGothmog = new LIItemSword(LIConfig.idWeaponGothmog - 256);
		weaponGrima = new LIItemSword(LIConfig.idWeaponGrima - 256);
		weaponGurthang = new LIItemSword(LIConfig.idWeaponGurthang - 256);
		weaponGuthwine = new LIItemSword(LIConfig.idWeaponGuthwine - 256);
		weaponHadhafang = new LIItemSword(LIConfig.idWeaponHadhafang - 256);
		weaponHerugrim = new LIItemSword(LIConfig.idWeaponHerugrim - 256);
		weaponKhamul = new LIItemSword(LIConfig.idWeaponKhamul - 256);
		weaponKili = new LIItemSword(LIConfig.idWeaponKili - 256);
		weaponLegolas = new LIItemSword(LIConfig.idWeaponLegolas - 256);
		weaponMelkor = new LIItemSword(LIConfig.idWeaponMelkor - 256);
		weaponMouthofsauron = new LIItemSword(LIConfig.idWeaponMouthofsauron - 256);
		weaponNarcil = new LIItemSword(LIConfig.idWeaponNarcil - 256);
		weaponNazgul = new LIItemSword(LIConfig.idWeaponNazgul - 256);
		weaponOrcrist = new LIItemSword(LIConfig.idWeaponOrcrist - 256);
		weaponPallando = new LIItemSword(LIConfig.idWeaponPallando - 256);
		weaponRadagast = new LIItemSword(LIConfig.idWeaponRadagast - 256);
		weaponSaruman = new LIItemSword(LIConfig.idWeaponSaruman - 256);
		weaponShagrat = new LIItemSword(LIConfig.idWeaponShagrat - 256);
		weaponThorin = new LIItemSword(LIConfig.idWeaponThorin - 256);
		weaponThorondun = new LIItemSword(LIConfig.idWeaponThorondun - 256);
		weaponThrain = new LIItemSword(LIConfig.idWeaponThrain - 256);
		weaponThranduil = new LIItemSword(LIConfig.idWeaponThranduil - 256);
		weaponThror = new LIItemSword(LIConfig.idWeaponThror - 256);
		weaponUrfael = new LIItemSword(LIConfig.idWeaponUrfael - 256);
		weaponWitchking = new LIItemSword(LIConfig.idWeaponWitchking - 256);
		arkenstone = new LIItemEmpty(LIConfig.idArkenstone - 256);
		silmaril = new LIItemEmpty(LIConfig.idSilmaril - 256);

		LIObfuscationHelper.setIconIndex(arkenstone, 0);
		LIObfuscationHelper.setIconIndex(armorAnarionBoots, 1);
		LIObfuscationHelper.setIconIndex(armorAnarionChestplate, 2);
		LIObfuscationHelper.setIconIndex(armorAnarionHelmet, 3);
		LIObfuscationHelper.setIconIndex(armorAnarionLegs, 4);
		LIObfuscationHelper.setIconIndex(armorArpharazonBoots, 5);
		LIObfuscationHelper.setIconIndex(armorArpharazonChestplate, 6);
		LIObfuscationHelper.setIconIndex(armorArpharazonHelmet, 7);
		LIObfuscationHelper.setIconIndex(armorArpharazonLegs, 8);
		LIObfuscationHelper.setIconIndex(armorArveduiBoots, 9);
		LIObfuscationHelper.setIconIndex(armorArveduiChestplate, 10);
		LIObfuscationHelper.setIconIndex(armorArveduiHelmet, 11);
		LIObfuscationHelper.setIconIndex(armorArveduiLegs, 12);
		LIObfuscationHelper.setIconIndex(armorBoromirBoots, 13);
		LIObfuscationHelper.setIconIndex(armorBoromirChestplate, 14);
		LIObfuscationHelper.setIconIndex(armorBoromirLegs, 15);
		LIObfuscationHelper.setIconIndex(armorElendilBoots, 16);
		LIObfuscationHelper.setIconIndex(armorElendilChestplate, 17);
		LIObfuscationHelper.setIconIndex(armorElendilHelmet, 18);
		LIObfuscationHelper.setIconIndex(armorElendilLegs, 19);
		LIObfuscationHelper.setIconIndex(armorElrosBoots, 20);
		LIObfuscationHelper.setIconIndex(armorElrosChestplate, 21);
		LIObfuscationHelper.setIconIndex(armorElrosHelmet, 22);
		LIObfuscationHelper.setIconIndex(armorElrosLegs, 23);
		LIObfuscationHelper.setIconIndex(armorFeanorBoots, 24);
		LIObfuscationHelper.setIconIndex(armorFeanorChestplate, 25);
		LIObfuscationHelper.setIconIndex(armorFeanorHelmet, 26);
		LIObfuscationHelper.setIconIndex(armorFeanorLegs, 27);
		LIObfuscationHelper.setIconIndex(armorGilgaladBoots, 28);
		LIObfuscationHelper.setIconIndex(armorGilgaladChestplate, 29);
		LIObfuscationHelper.setIconIndex(armorGilgaladHelmet, 30);
		LIObfuscationHelper.setIconIndex(armorGilgaladLegs, 31);
		LIObfuscationHelper.setIconIndex(armorGimliBoots, 32);
		LIObfuscationHelper.setIconIndex(armorGimliChestplate, 33);
		LIObfuscationHelper.setIconIndex(armorGimliHelmet, 34);
		LIObfuscationHelper.setIconIndex(armorGimliLegs, 35);
		LIObfuscationHelper.setIconIndex(armorIsildurBoots, 36);
		LIObfuscationHelper.setIconIndex(armorIsildurChestplate, 37);
		LIObfuscationHelper.setIconIndex(armorIsildurHelmet, 38);
		LIObfuscationHelper.setIconIndex(armorIsildurLegs, 39);
		LIObfuscationHelper.setIconIndex(armorJiindurBoots, 40);
		LIObfuscationHelper.setIconIndex(armorJiindurChestplate, 41);
		LIObfuscationHelper.setIconIndex(armorJiindurHelmet, 42);
		LIObfuscationHelper.setIconIndex(armorJiindurLegs, 43);
		LIObfuscationHelper.setIconIndex(armorKhamulBoots, 44);
		LIObfuscationHelper.setIconIndex(armorKhamulChestplate, 45);
		LIObfuscationHelper.setIconIndex(armorKhamulHelmet, 46);
		LIObfuscationHelper.setIconIndex(armorKhamulLegs, 47);
		LIObfuscationHelper.setIconIndex(armorKhommuratBoots, 48);
		LIObfuscationHelper.setIconIndex(armorKhommuratChestplate, 49);
		LIObfuscationHelper.setIconIndex(armorKhommuratHelmet, 50);
		LIObfuscationHelper.setIconIndex(armorKhommuratLegs, 51);
		LIObfuscationHelper.setIconIndex(armorMorgomirBoots, 52);
		LIObfuscationHelper.setIconIndex(armorMorgomirChestplate, 53);
		LIObfuscationHelper.setIconIndex(armorMorgomirHelmet, 54);
		LIObfuscationHelper.setIconIndex(armorMorgomirLegs, 55);
		LIObfuscationHelper.setIconIndex(armorTheodenBoots, 56);
		LIObfuscationHelper.setIconIndex(armorTheodenChestplate, 57);
		LIObfuscationHelper.setIconIndex(armorTheodenHelmet, 58);
		LIObfuscationHelper.setIconIndex(armorTheodenLegs, 59);
		LIObfuscationHelper.setIconIndex(armorTurgonBoots, 60);
		LIObfuscationHelper.setIconIndex(armorTurgonChestplate, 61);
		LIObfuscationHelper.setIconIndex(armorTurgonHelmet, 62);
		LIObfuscationHelper.setIconIndex(armorTurgonLegs, 63);
		LIObfuscationHelper.setIconIndex(silmaril, 64);
		LIObfuscationHelper.setIconIndex(weaponAcharn, 65);
		LIObfuscationHelper.setIconIndex(weaponAeglos, 66);
		LIObfuscationHelper.setIconIndex(weaponAlatar, 67);
		LIObfuscationHelper.setIconIndex(weaponAngrist, 68);
		LIObfuscationHelper.setIconIndex(weaponAnguirel, 69);
		LIObfuscationHelper.setIconIndex(weaponAranruth, 70);
		LIObfuscationHelper.setIconIndex(weaponAzog, 71);
		LIObfuscationHelper.setIconIndex(weaponBalin, 72);
		LIObfuscationHelper.setIconIndex(weaponBarazanthual, 73);
		LIObfuscationHelper.setIconIndex(weaponBolg, 74);
		LIObfuscationHelper.setIconIndex(weaponBoromir, 75);
		LIObfuscationHelper.setIconIndex(weaponCeleborn, 76);
		LIObfuscationHelper.setIconIndex(weaponDagmor, 77);
		LIObfuscationHelper.setIconIndex(weaponDain, 78);
		LIObfuscationHelper.setIconIndex(weaponDenethor, 79);
		LIObfuscationHelper.setIconIndex(weaponDori, 80);
		LIObfuscationHelper.setIconIndex(weaponDramborleg, 81);
		LIObfuscationHelper.setIconIndex(weaponDurin, 82);
		LIObfuscationHelper.setIconIndex(weaponDwalin, 83);
		LIObfuscationHelper.setIconIndex(weaponEothain, 84);
		LIObfuscationHelper.setIconIndex(weaponEowyn, 85);
		LIObfuscationHelper.setIconIndex(weaponFaramir, 86);
		LIObfuscationHelper.setIconIndex(weaponGamling, 87);
		LIObfuscationHelper.setIconIndex(weaponGimli, 88);
		LIObfuscationHelper.setIconIndex(weaponGirion, 89);
		LIObfuscationHelper.setIconIndex(weaponGoblinking, 90);
		LIObfuscationHelper.setIconIndex(weaponGorbag, 91);
		LIObfuscationHelper.setIconIndex(weaponGothmog, 92);
		LIObfuscationHelper.setIconIndex(weaponGrima, 93);
		LIObfuscationHelper.setIconIndex(weaponGurthang, 94);
		LIObfuscationHelper.setIconIndex(weaponGuthwine, 95);
		LIObfuscationHelper.setIconIndex(weaponHadhafang, 96);
		LIObfuscationHelper.setIconIndex(weaponHerugrim, 97);
		LIObfuscationHelper.setIconIndex(weaponKhamul, 98);
		LIObfuscationHelper.setIconIndex(weaponKili, 99);
		LIObfuscationHelper.setIconIndex(weaponLegolas, 100);
		LIObfuscationHelper.setIconIndex(weaponMelkor, 101);
		LIObfuscationHelper.setIconIndex(weaponMouthofsauron, 102);
		LIObfuscationHelper.setIconIndex(weaponNarcil, 103);
		LIObfuscationHelper.setIconIndex(weaponNazgul, 104);
		LIObfuscationHelper.setIconIndex(weaponOrcrist, 105);
		LIObfuscationHelper.setIconIndex(weaponPallando, 106);
		LIObfuscationHelper.setIconIndex(weaponRadagast, 107);
		LIObfuscationHelper.setIconIndex(weaponSaruman, 108);
		LIObfuscationHelper.setIconIndex(weaponShagrat, 109);
		LIObfuscationHelper.setIconIndex(weaponThorin, 110);
		LIObfuscationHelper.setIconIndex(weaponThorondun, 111);
		LIObfuscationHelper.setIconIndex(weaponThrain, 112);
		LIObfuscationHelper.setIconIndex(weaponThranduil, 113);
		LIObfuscationHelper.setIconIndex(weaponThror, 114);
		LIObfuscationHelper.setIconIndex(weaponUrfael, 115);
		LIObfuscationHelper.setIconIndex(weaponWitchking, 116);

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

		register(arkenstone, "arkenstone");
		register(silmaril, "silmaril");
	}
}