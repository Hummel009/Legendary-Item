package legendarium;

import com.google.common.base.CaseFormat;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashSet;
import java.util.Set;

@Mod(modid = "legendarium")
public class LI {
	public static final Set<Item> CONTENT = new HashSet<>();

	@SidedProxy(serverSide = "legendarium.LICommonProxy", clientSide = "legendarium.LIClientProxy")
	public static LICommonProxy proxy;

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
		item.setUnlocalizedName(name);
		item.setRegistryName(name);
		GameRegistry.registerItem(item, name);
		CONTENT.add(item);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		armorAnarionHelmet = new LIItemArmor(LIMaterial.ANARION, 0);
		armorAnarionChestplate = new LIItemArmor(LIMaterial.ANARION, 1);
		armorAnarionLegs = new LIItemArmor(LIMaterial.ANARION, 2);
		armorAnarionBoots = new LIItemArmor(LIMaterial.ANARION, 3);

		armorArpharazonHelmet = new LIItemArmor(LIMaterial.ARPHARAZON, 0);
		armorArpharazonChestplate = new LIItemArmor(LIMaterial.ARPHARAZON, 1);
		armorArpharazonLegs = new LIItemArmor(LIMaterial.ARPHARAZON, 2);
		armorArpharazonBoots = new LIItemArmor(LIMaterial.ARPHARAZON, 3);

		armorArveduiHelmet = new LIItemArmor(LIMaterial.ARVEDUI, 0);
		armorArveduiChestplate = new LIItemArmor(LIMaterial.ARVEDUI, 1);
		armorArveduiLegs = new LIItemArmor(LIMaterial.ARVEDUI, 2);
		armorArveduiBoots = new LIItemArmor(LIMaterial.ARVEDUI, 3);

		armorBoromirChestplate = new LIItemArmor(LIMaterial.BOROMIR, 1);
		armorBoromirLegs = new LIItemArmor(LIMaterial.BOROMIR, 2);
		armorBoromirBoots = new LIItemArmor(LIMaterial.BOROMIR, 3);

		armorElendilHelmet = new LIItemArmor(LIMaterial.ELENDIL, 0);
		armorElendilChestplate = new LIItemArmor(LIMaterial.ELENDIL, 1);
		armorElendilLegs = new LIItemArmor(LIMaterial.ELENDIL, 2);
		armorElendilBoots = new LIItemArmor(LIMaterial.ELENDIL, 3);

		armorElrosHelmet = new LIItemArmor(LIMaterial.ELROS, 0);
		armorElrosChestplate = new LIItemArmor(LIMaterial.ELROS, 1);
		armorElrosLegs = new LIItemArmor(LIMaterial.ELROS, 2);
		armorElrosBoots = new LIItemArmor(LIMaterial.ELROS, 3);

		armorFeanorHelmet = new LIItemArmor(LIMaterial.FEANOR, 0);
		armorFeanorChestplate = new LIItemArmor(LIMaterial.FEANOR, 1);
		armorFeanorLegs = new LIItemArmor(LIMaterial.FEANOR, 2);
		armorFeanorBoots = new LIItemArmor(LIMaterial.FEANOR, 3);

		armorGilgaladHelmet = new LIItemArmor(LIMaterial.GILGALAD, 0);
		armorGilgaladChestplate = new LIItemArmor(LIMaterial.GILGALAD, 1);
		armorGilgaladLegs = new LIItemArmor(LIMaterial.GILGALAD, 2);
		armorGilgaladBoots = new LIItemArmor(LIMaterial.GILGALAD, 3);

		armorGimliHelmet = new LIItemArmor(LIMaterial.GIMLI, 0);
		armorGimliChestplate = new LIItemArmor(LIMaterial.GIMLI, 1);
		armorGimliLegs = new LIItemArmor(LIMaterial.GIMLI, 2);
		armorGimliBoots = new LIItemArmor(LIMaterial.GIMLI, 3);

		armorIsildurHelmet = new LIItemArmor(LIMaterial.ISILDUR, 0);
		armorIsildurChestplate = new LIItemArmor(LIMaterial.ISILDUR, 1);
		armorIsildurLegs = new LIItemArmor(LIMaterial.ISILDUR, 2);
		armorIsildurBoots = new LIItemArmor(LIMaterial.ISILDUR, 3);

		armorJiindurHelmet = new LIItemArmor(LIMaterial.JIINDUR, 0);
		armorJiindurChestplate = new LIItemArmor(LIMaterial.JIINDUR, 1);
		armorJiindurLegs = new LIItemArmor(LIMaterial.JIINDUR, 2);
		armorJiindurBoots = new LIItemArmor(LIMaterial.JIINDUR, 3);

		armorKhamulHelmet = new LIItemArmor(LIMaterial.KHAMUL, 0);
		armorKhamulChestplate = new LIItemArmor(LIMaterial.KHAMUL, 1);
		armorKhamulLegs = new LIItemArmor(LIMaterial.KHAMUL, 2);
		armorKhamulBoots = new LIItemArmor(LIMaterial.KHAMUL, 3);

		armorKhommuratHelmet = new LIItemArmor(LIMaterial.KHOMMURAT, 0);
		armorKhommuratChestplate = new LIItemArmor(LIMaterial.KHOMMURAT, 1);
		armorKhommuratLegs = new LIItemArmor(LIMaterial.KHOMMURAT, 2);
		armorKhommuratBoots = new LIItemArmor(LIMaterial.KHOMMURAT, 3);

		armorMorgomirHelmet = new LIItemArmor(LIMaterial.MORGOMIR, 0);
		armorMorgomirChestplate = new LIItemArmor(LIMaterial.MORGOMIR, 1);
		armorMorgomirLegs = new LIItemArmor(LIMaterial.MORGOMIR, 2);
		armorMorgomirBoots = new LIItemArmor(LIMaterial.MORGOMIR, 3);

		armorTheodenHelmet = new LIItemArmor(LIMaterial.THEODEN, 0);
		armorTheodenChestplate = new LIItemArmor(LIMaterial.THEODEN, 1);
		armorTheodenLegs = new LIItemArmor(LIMaterial.THEODEN, 2);
		armorTheodenBoots = new LIItemArmor(LIMaterial.THEODEN, 3);

		armorTurgonHelmet = new LIItemArmor(LIMaterial.TURGON, 0);
		armorTurgonChestplate = new LIItemArmor(LIMaterial.TURGON, 1);
		armorTurgonLegs = new LIItemArmor(LIMaterial.TURGON, 2);
		armorTurgonBoots = new LIItemArmor(LIMaterial.TURGON, 3);

		weaponAcharn = new LIItemSword();
		weaponAeglos = new LIItemSword();
		weaponAlatar = new LIItemSword();
		weaponAngrist = new LIItemSword();
		weaponAnguirel = new LIItemSword();
		weaponAranruth = new LIItemSword();
		weaponAzog = new LIItemSword();
		weaponBalin = new LIItemSword();
		weaponBarazanthual = new LIItemSword();
		weaponBolg = new LIItemSword();
		weaponBoromir = new LIItemSword();
		weaponCeleborn = new LIItemSword();
		weaponDagmor = new LIItemSword();
		weaponDain = new LIItemSword();
		weaponDenethor = new LIItemSword();
		weaponDori = new LIItemSword();
		weaponDramborleg = new LIItemSword();
		weaponDurin = new LIItemSword();
		weaponDwalin = new LIItemSword();
		weaponEothain = new LIItemSword();
		weaponEowyn = new LIItemSword();
		weaponFaramir = new LIItemSword();
		weaponGamling = new LIItemSword();
		weaponGimli = new LIItemSword();
		weaponGirion = new LIItemSword();
		weaponGoblinking = new LIItemSword();
		weaponGorbag = new LIItemSword();
		weaponGothmog = new LIItemSword();
		weaponGrima = new LIItemSword();
		weaponGurthang = new LIItemSword();
		weaponGuthwine = new LIItemSword();
		weaponHadhafang = new LIItemSword();
		weaponHerugrim = new LIItemSword();
		weaponKhamul = new LIItemSword();
		weaponKili = new LIItemSword();
		weaponLegolas = new LIItemSword();
		weaponMelkor = new LIItemSword();
		weaponMouthofsauron = new LIItemSword();
		weaponNarcil = new LIItemSword();
		weaponNazgul = new LIItemSword();
		weaponOrcrist = new LIItemSword();
		weaponPallando = new LIItemSword();
		weaponRadagast = new LIItemSword();
		weaponSaruman = new LIItemSword();
		weaponShagrat = new LIItemSword();
		weaponThorin = new LIItemSword();
		weaponThorondun = new LIItemSword();
		weaponThrain = new LIItemSword();
		weaponThranduil = new LIItemSword();
		weaponThror = new LIItemSword();
		weaponUrfael = new LIItemSword();
		weaponWitchking = new LIItemSword();
		arkenstone = new LIItemEmpty();
		silmaril = new LIItemEmpty();

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

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		proxy.registerRenders();
	}
}