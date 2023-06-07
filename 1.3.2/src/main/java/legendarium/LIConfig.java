package legendarium;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

import java.util.logging.Level;

public class LIConfig {
	public static Configuration configuration;

	public static boolean loaded;

	public static int idArmorAnarionHelmet;
	public static int idArmorAnarionChestplate;
	public static int idArmorAnarionLegs;
	public static int idArmorAnarionBoots;

	public static int idArmorArpharazonHelmet;
	public static int idArmorArpharazonChestplate;
	public static int idArmorArpharazonLegs;
	public static int idArmorArpharazonBoots;

	public static int idArmorArveduiHelmet;
	public static int idArmorArveduiChestplate;
	public static int idArmorArveduiLegs;
	public static int idArmorArveduiBoots;

	public static int idArmorBoromirChestplate;
	public static int idArmorBoromirLegs;
	public static int idArmorBoromirBoots;

	public static int idArmorElendilHelmet;
	public static int idArmorElendilChestplate;
	public static int idArmorElendilLegs;
	public static int idArmorElendilBoots;

	public static int idArmorElrosHelmet;
	public static int idArmorElrosChestplate;
	public static int idArmorElrosLegs;
	public static int idArmorElrosBoots;

	public static int idArmorFeanorHelmet;
	public static int idArmorFeanorChestplate;
	public static int idArmorFeanorLegs;
	public static int idArmorFeanorBoots;

	public static int idArmorGilgaladHelmet;
	public static int idArmorGilgaladChestplate;
	public static int idArmorGilgaladLegs;
	public static int idArmorGilgaladBoots;

	public static int idArmorGimliHelmet;
	public static int idArmorGimliChestplate;
	public static int idArmorGimliLegs;
	public static int idArmorGimliBoots;

	public static int idArmorIsildurHelmet;
	public static int idArmorIsildurChestplate;
	public static int idArmorIsildurLegs;
	public static int idArmorIsildurBoots;

	public static int idArmorJiindurHelmet;
	public static int idArmorJiindurChestplate;
	public static int idArmorJiindurLegs;
	public static int idArmorJiindurBoots;

	public static int idArmorKhamulHelmet;
	public static int idArmorKhamulChestplate;
	public static int idArmorKhamulLegs;
	public static int idArmorKhamulBoots;

	public static int idArmorKhommuratHelmet;
	public static int idArmorKhommuratChestplate;
	public static int idArmorKhommuratLegs;
	public static int idArmorKhommuratBoots;

	public static int idArmorMorgomirHelmet;
	public static int idArmorMorgomirChestplate;
	public static int idArmorMorgomirLegs;
	public static int idArmorMorgomirBoots;

	public static int idArmorTheodenHelmet;
	public static int idArmorTheodenChestplate;
	public static int idArmorTheodenLegs;
	public static int idArmorTheodenBoots;

	public static int idArmorTurgonHelmet;
	public static int idArmorTurgonChestplate;
	public static int idArmorTurgonLegs;
	public static int idArmorTurgonBoots;

	public static int idWeaponAcharn;
	public static int idWeaponAeglos;
	public static int idWeaponAlatar;
	public static int idWeaponAngrist;
	public static int idWeaponAnguirel;
	public static int idWeaponAranruth;
	public static int idWeaponAzog;
	public static int idWeaponBalin;
	public static int idWeaponBarazanthual;
	public static int idWeaponBolg;
	public static int idWeaponBoromir;
	public static int idWeaponCeleborn;
	public static int idWeaponDagmor;
	public static int idWeaponDain;
	public static int idWeaponDenethor;
	public static int idWeaponDori;
	public static int idWeaponDramborleg;
	public static int idWeaponDurin;
	public static int idWeaponDwalin;
	public static int idWeaponEothain;
	public static int idWeaponEowyn;
	public static int idWeaponFaramir;
	public static int idWeaponGamling;
	public static int idWeaponGimli;
	public static int idWeaponGirion;
	public static int idWeaponGoblinking;
	public static int idWeaponGorbag;
	public static int idWeaponGothmog;
	public static int idWeaponGrima;
	public static int idWeaponGurthang;
	public static int idWeaponGuthwine;
	public static int idWeaponHadhafang;
	public static int idWeaponHerugrim;
	public static int idWeaponKhamul;
	public static int idWeaponKili;
	public static int idWeaponLegolas;
	public static int idWeaponMelkor;
	public static int idWeaponMouthofsauron;
	public static int idWeaponNarcil;
	public static int idWeaponNazgul;
	public static int idWeaponOrcrist;
	public static int idWeaponPallando;
	public static int idWeaponRadagast;
	public static int idWeaponSaruman;
	public static int idWeaponShagrat;
	public static int idWeaponThorin;
	public static int idWeaponThorondun;
	public static int idWeaponThrain;
	public static int idWeaponThranduil;
	public static int idWeaponThror;
	public static int idWeaponUrfael;
	public static int idWeaponWitchking;

	public static int idArkenstone;
	public static int idSilmaril;

	private static void setDefaultValues() {
		try {
			configuration.load();

			idArmorAnarionHelmet = configuration.get("item", "Armor Anarion Helmet", 772).getInt(772);
			idArmorAnarionChestplate = configuration.get("item", "Armor Anarion Chestplate", 773).getInt(773);
			idArmorAnarionLegs = configuration.get("item", "Armor Anarion Legs", 774).getInt(774);
			idArmorAnarionBoots = configuration.get("item", "Armor Anarion Boots", 775).getInt(775);

			idArmorArpharazonHelmet = configuration.get("item", "Armor Arpharazon Helmet", 776).getInt(776);
			idArmorArpharazonChestplate = configuration.get("item", "Armor Arpharazon Chestplate", 777).getInt(777);
			idArmorArpharazonLegs = configuration.get("item", "Armor Arpharazon Legs", 778).getInt(778);
			idArmorArpharazonBoots = configuration.get("item", "Armor Arpharazon Boots", 779).getInt(779);

			idArmorArveduiHelmet = configuration.get("item", "Armor Arvedui Helmet", 780).getInt(780);
			idArmorArveduiChestplate = configuration.get("item", "Armor Arvedui Chestplate", 781).getInt(781);
			idArmorArveduiLegs = configuration.get("item", "Armor Arvedui Legs", 782).getInt(782);
			idArmorArveduiBoots = configuration.get("item", "Armor Arvedui Boots", 783).getInt(783);

			idArmorBoromirChestplate = configuration.get("item", "Armor Boromir Chestplate", 784).getInt(784);
			idArmorBoromirLegs = configuration.get("item", "Armor Boromir Legs", 785).getInt(785);
			idArmorBoromirBoots = configuration.get("item", "Armor Boromir Boots", 786).getInt(786);

			idArmorElendilHelmet = configuration.get("item", "Armor Elendil Helmet", 787).getInt(787);
			idArmorElendilChestplate = configuration.get("item", "Armor Elendil Chestplate", 788).getInt(788);
			idArmorElendilLegs = configuration.get("item", "Armor Elendil Legs", 789).getInt(789);
			idArmorElendilBoots = configuration.get("item", "Armor Elendil Boots", 790).getInt(790);

			idArmorElrosHelmet = configuration.get("item", "Armor Elros Helmet", 791).getInt(791);
			idArmorElrosChestplate = configuration.get("item", "Armor Elros Chestplate", 792).getInt(792);
			idArmorElrosLegs = configuration.get("item", "Armor Elros Legs", 793).getInt(793);
			idArmorElrosBoots = configuration.get("item", "Armor Elros Boots", 794).getInt(794);

			idArmorFeanorHelmet = configuration.get("item", "Armor Feanor Helmet", 795).getInt(795);
			idArmorFeanorChestplate = configuration.get("item", "Armor Feanor Chestplate", 796).getInt(796);
			idArmorFeanorLegs = configuration.get("item", "Armor Feanor Legs", 797).getInt(797);
			idArmorFeanorBoots = configuration.get("item", "Armor Feanor Boots", 798).getInt(798);

			idArmorGilgaladHelmet = configuration.get("item", "Armor Gilgalad Helmet", 799).getInt(799);
			idArmorGilgaladChestplate = configuration.get("item", "Armor Gilgalad Chestplate", 800).getInt(800);
			idArmorGilgaladLegs = configuration.get("item", "Armor Gilgalad Legs", 801).getInt(801);
			idArmorGilgaladBoots = configuration.get("item", "Armor Gilgalad Boots", 802).getInt(802);

			idArmorGimliHelmet = configuration.get("item", "Armor Gimli Helmet", 803).getInt(803);
			idArmorGimliChestplate = configuration.get("item", "Armor Gimli Chestplate", 804).getInt(804);
			idArmorGimliLegs = configuration.get("item", "Armor Gimli Legs", 805).getInt(805);
			idArmorGimliBoots = configuration.get("item", "Armor Gimli Boots", 806).getInt(806);

			idArmorIsildurHelmet = configuration.get("item", "Armor Isildur Helmet", 807).getInt(807);
			idArmorIsildurChestplate = configuration.get("item", "Armor Isildur Chestplate", 808).getInt(808);
			idArmorIsildurLegs = configuration.get("item", "Armor Isildur Legs", 809).getInt(809);
			idArmorIsildurBoots = configuration.get("item", "Armor Isildur Boots", 810).getInt(810);

			idArmorJiindurHelmet = configuration.get("item", "Armor Jiindur Helmet", 811).getInt(811);
			idArmorJiindurChestplate = configuration.get("item", "Armor Jiindur Chestplate", 812).getInt(812);
			idArmorJiindurLegs = configuration.get("item", "Armor Jiindur Legs", 813).getInt(813);
			idArmorJiindurBoots = configuration.get("item", "Armor Jiindur Boots", 814).getInt(814);

			idArmorKhamulHelmet = configuration.get("item", "Armor Khamul Helmet", 815).getInt(815);
			idArmorKhamulChestplate = configuration.get("item", "Armor Khamul Chestplate", 816).getInt(816);
			idArmorKhamulLegs = configuration.get("item", "Armor Khamul Legs", 817).getInt(817);
			idArmorKhamulBoots = configuration.get("item", "Armor Khamul Boots", 818).getInt(818);

			idArmorKhommuratHelmet = configuration.get("item", "Armor Khommurat Helmet", 819).getInt(819);
			idArmorKhommuratChestplate = configuration.get("item", "Armor Khommurat Chestplate", 820).getInt(820);
			idArmorKhommuratLegs = configuration.get("item", "Armor Khommurat Legs", 821).getInt(821);
			idArmorKhommuratBoots = configuration.get("item", "Armor Khommurat Boots", 822).getInt(822);

			idArmorMorgomirHelmet = configuration.get("item", "Armor Morgomir Helmet", 823).getInt(823);
			idArmorMorgomirChestplate = configuration.get("item", "Armor Morgomir Chestplate", 824).getInt(824);
			idArmorMorgomirLegs = configuration.get("item", "Armor Morgomir Legs", 825).getInt(825);
			idArmorMorgomirBoots = configuration.get("item", "Armor Morgomir Boots", 826).getInt(826);

			idArmorTheodenHelmet = configuration.get("item", "Armor Theoden Helmet", 827).getInt(827);
			idArmorTheodenChestplate = configuration.get("item", "Armor Theoden Chestplate", 828).getInt(828);
			idArmorTheodenLegs = configuration.get("item", "Armor Theoden Legs", 829).getInt(829);
			idArmorTheodenBoots = configuration.get("item", "Armor Theoden Boots", 830).getInt(830);

			idArmorTurgonHelmet = configuration.get("item", "Armor Turgon Helmet", 831).getInt(831);
			idArmorTurgonChestplate = configuration.get("item", "Armor Turgon Chestplate", 832).getInt(832);
			idArmorTurgonLegs = configuration.get("item", "Armor Turgon Legs", 833).getInt(833);
			idArmorTurgonBoots = configuration.get("item", "Armor Turgon Boots", 834).getInt(834);

			idWeaponAcharn = configuration.get("item", "Weapon Acharn", 835).getInt(835);
			idWeaponAeglos = configuration.get("item", "Weapon Aeglos", 836).getInt(836);
			idWeaponAlatar = configuration.get("item", "Weapon Alatar", 837).getInt(837);
			idWeaponAngrist = configuration.get("item", "Weapon Angrist", 838).getInt(838);
			idWeaponAnguirel = configuration.get("item", "Weapon Anguirel", 839).getInt(839);
			idWeaponAranruth = configuration.get("item", "Weapon Aranruth", 840).getInt(840);
			idWeaponAzog = configuration.get("item", "Weapon Azog", 841).getInt(841);
			idWeaponBalin = configuration.get("item", "Weapon Balin", 842).getInt(842);
			idWeaponBarazanthual = configuration.get("item", "Weapon Barazanthual", 843).getInt(843);
			idWeaponBolg = configuration.get("item", "Weapon Bolg", 844).getInt(844);
			idWeaponBoromir = configuration.get("item", "Weapon Boromir", 845).getInt(845);
			idWeaponCeleborn = configuration.get("item", "Weapon Celeborn", 846).getInt(846);
			idWeaponDagmor = configuration.get("item", "Weapon Dagmor", 847).getInt(847);
			idWeaponDain = configuration.get("item", "Weapon Dain", 848).getInt(848);
			idWeaponDenethor = configuration.get("item", "Weapon Denethor", 849).getInt(849);
			idWeaponDori = configuration.get("item", "Weapon Dori", 850).getInt(850);
			idWeaponDramborleg = configuration.get("item", "Weapon Dramborleg", 851).getInt(851);
			idWeaponDurin = configuration.get("item", "Weapon Durin", 852).getInt(852);
			idWeaponDwalin = configuration.get("item", "Weapon Dwalin", 853).getInt(853);
			idWeaponEothain = configuration.get("item", "Weapon Eothain", 854).getInt(854);
			idWeaponEowyn = configuration.get("item", "Weapon Eowyn", 855).getInt(855);
			idWeaponFaramir = configuration.get("item", "Weapon Faramir", 856).getInt(856);
			idWeaponGamling = configuration.get("item", "Weapon Gamling", 857).getInt(857);
			idWeaponGimli = configuration.get("item", "Weapon Gimli", 858).getInt(858);
			idWeaponGirion = configuration.get("item", "Weapon Girion", 859).getInt(859);
			idWeaponGoblinking = configuration.get("item", "Weapon Goblinking", 860).getInt(860);
			idWeaponGorbag = configuration.get("item", "Weapon Gorbag", 861).getInt(861);
			idWeaponGothmog = configuration.get("item", "Weapon Gothmog", 862).getInt(862);
			idWeaponGrima = configuration.get("item", "Weapon Grima", 863).getInt(863);
			idWeaponGurthang = configuration.get("item", "Weapon Gurthang", 864).getInt(864);
			idWeaponGuthwine = configuration.get("item", "Weapon Guthwine", 865).getInt(865);
			idWeaponHadhafang = configuration.get("item", "Weapon Hadhafang", 866).getInt(866);
			idWeaponHerugrim = configuration.get("item", "Weapon Herugrim", 867).getInt(867);
			idWeaponKhamul = configuration.get("item", "Weapon Khamul", 868).getInt(868);
			idWeaponKili = configuration.get("item", "Weapon Kili", 869).getInt(869);
			idWeaponLegolas = configuration.get("item", "Weapon Legolas", 870).getInt(870);
			idWeaponMelkor = configuration.get("item", "Weapon Melkor", 871).getInt(871);
			idWeaponMouthofsauron = configuration.get("item", "Weapon Mouthofsauron", 872).getInt(872);
			idWeaponNarcil = configuration.get("item", "Weapon Narcil", 873).getInt(873);
			idWeaponNazgul = configuration.get("item", "Weapon Nazgul", 874).getInt(874);
			idWeaponOrcrist = configuration.get("item", "Weapon Orcrist", 875).getInt(875);
			idWeaponPallando = configuration.get("item", "Weapon Pallando", 876).getInt(876);
			idWeaponRadagast = configuration.get("item", "Weapon Radagast", 877).getInt(877);
			idWeaponSaruman = configuration.get("item", "Weapon Saruman", 878).getInt(878);
			idWeaponShagrat = configuration.get("item", "Weapon Shagrat", 879).getInt(879);
			idWeaponThorin = configuration.get("item", "Weapon Thorin", 880).getInt(880);
			idWeaponThorondun = configuration.get("item", "Weapon Thorondun", 881).getInt(881);
			idWeaponThrain = configuration.get("item", "Weapon Thrain", 882).getInt(882);
			idWeaponThranduil = configuration.get("item", "Weapon Thranduil", 883).getInt(883);
			idWeaponThror = configuration.get("item", "Weapon Thror", 884).getInt(884);
			idWeaponUrfael = configuration.get("item", "Weapon Urfael", 885).getInt(885);
			idWeaponWitchking = configuration.get("item", "Weapon Witchking", 886).getInt(886);

			idArkenstone = configuration.get("item", "Arkenstone", 887).getInt(887);
			idSilmaril = configuration.get("item", "Silmaril", 888).getInt(888);
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "Legendary Item has a problem loading it's configuration");
		} finally {
			configuration.save();
			loaded = true;
		}
	}

	public static void preInit(FMLPreInitializationEvent event) {
		if (!loaded) {
			configuration = new Configuration(event.getSuggestedConfigurationFile());
			setDefaultValues();
		}
	}
}