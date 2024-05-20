package com.github.hummel.legendarium;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

import java.util.logging.Level;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Config {
	private static Configuration configuration;

	private static boolean loaded;

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

	private Config() {
	}

	public static void preInit(FMLPreInitializationEvent event) {
		if (!loaded) {
			configuration = new Configuration(event.getSuggestedConfigurationFile());
			setDefaultValues();
		}
	}

	private static void setDefaultValues() {
		try {
			configuration.load();

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
			FMLLog.log(Level.SEVERE, e, "Mod has a problem loading it's configuration");
		} finally {
			configuration.save();
			loaded = true;
		}
	}
}