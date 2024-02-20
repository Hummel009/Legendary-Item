package com.github.hummel.legendarium.init;

import com.github.hummel.legendarium.Config;
import com.github.hummel.legendarium.item.ItemColdWeapon;
import com.github.hummel.legendarium.item.ItemGem;
import com.google.common.base.CaseFormat;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Items {
	public static final Collection<Item> CONTENT = new ArrayList<Item>();

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

	private Items() {
	}

	public static void preInit() {
		weaponAcharn = new ItemColdWeapon(Config.idWeaponAcharn - 256);
		weaponAeglos = new ItemColdWeapon(Config.idWeaponAeglos - 256);
		weaponAlatar = new ItemColdWeapon(Config.idWeaponAlatar - 256);
		weaponAngrist = new ItemColdWeapon(Config.idWeaponAngrist - 256);
		weaponAnguirel = new ItemColdWeapon(Config.idWeaponAnguirel - 256);
		weaponAranruth = new ItemColdWeapon(Config.idWeaponAranruth - 256);
		weaponAzog = new ItemColdWeapon(Config.idWeaponAzog - 256);
		weaponBalin = new ItemColdWeapon(Config.idWeaponBalin - 256);
		weaponBarazanthual = new ItemColdWeapon(Config.idWeaponBarazanthual - 256);
		weaponBolg = new ItemColdWeapon(Config.idWeaponBolg - 256);
		weaponBoromir = new ItemColdWeapon(Config.idWeaponBoromir - 256);
		weaponCeleborn = new ItemColdWeapon(Config.idWeaponCeleborn - 256);
		weaponDagmor = new ItemColdWeapon(Config.idWeaponDagmor - 256);
		weaponDain = new ItemColdWeapon(Config.idWeaponDain - 256);
		weaponDenethor = new ItemColdWeapon(Config.idWeaponDenethor - 256);
		weaponDori = new ItemColdWeapon(Config.idWeaponDori - 256);
		weaponDramborleg = new ItemColdWeapon(Config.idWeaponDramborleg - 256);
		weaponDurin = new ItemColdWeapon(Config.idWeaponDurin - 256);
		weaponDwalin = new ItemColdWeapon(Config.idWeaponDwalin - 256);
		weaponEothain = new ItemColdWeapon(Config.idWeaponEothain - 256);
		weaponEowyn = new ItemColdWeapon(Config.idWeaponEowyn - 256);
		weaponFaramir = new ItemColdWeapon(Config.idWeaponFaramir - 256);
		weaponGamling = new ItemColdWeapon(Config.idWeaponGamling - 256);
		weaponGimli = new ItemColdWeapon(Config.idWeaponGimli - 256);
		weaponGirion = new ItemColdWeapon(Config.idWeaponGirion - 256);
		weaponGoblinking = new ItemColdWeapon(Config.idWeaponGoblinking - 256);
		weaponGorbag = new ItemColdWeapon(Config.idWeaponGorbag - 256);
		weaponGothmog = new ItemColdWeapon(Config.idWeaponGothmog - 256);
		weaponGrima = new ItemColdWeapon(Config.idWeaponGrima - 256);
		weaponGurthang = new ItemColdWeapon(Config.idWeaponGurthang - 256);
		weaponGuthwine = new ItemColdWeapon(Config.idWeaponGuthwine - 256);
		weaponHadhafang = new ItemColdWeapon(Config.idWeaponHadhafang - 256);
		weaponHerugrim = new ItemColdWeapon(Config.idWeaponHerugrim - 256);
		weaponKhamul = new ItemColdWeapon(Config.idWeaponKhamul - 256);
		weaponKili = new ItemColdWeapon(Config.idWeaponKili - 256);
		weaponLegolas = new ItemColdWeapon(Config.idWeaponLegolas - 256);
		weaponMelkor = new ItemColdWeapon(Config.idWeaponMelkor - 256);
		weaponMouthofsauron = new ItemColdWeapon(Config.idWeaponMouthofsauron - 256);
		weaponNarcil = new ItemColdWeapon(Config.idWeaponNarcil - 256);
		weaponNazgul = new ItemColdWeapon(Config.idWeaponNazgul - 256);
		weaponOrcrist = new ItemColdWeapon(Config.idWeaponOrcrist - 256);
		weaponPallando = new ItemColdWeapon(Config.idWeaponPallando - 256);
		weaponRadagast = new ItemColdWeapon(Config.idWeaponRadagast - 256);
		weaponSaruman = new ItemColdWeapon(Config.idWeaponSaruman - 256);
		weaponShagrat = new ItemColdWeapon(Config.idWeaponShagrat - 256);
		weaponThorin = new ItemColdWeapon(Config.idWeaponThorin - 256);
		weaponThorondun = new ItemColdWeapon(Config.idWeaponThorondun - 256);
		weaponThrain = new ItemColdWeapon(Config.idWeaponThrain - 256);
		weaponThranduil = new ItemColdWeapon(Config.idWeaponThranduil - 256);
		weaponThror = new ItemColdWeapon(Config.idWeaponThror - 256);
		weaponUrfael = new ItemColdWeapon(Config.idWeaponUrfael - 256);
		weaponWitchking = new ItemColdWeapon(Config.idWeaponWitchking - 256);

		arkenstone = new ItemGem(Config.idArkenstone - 256);
		silmaril = new ItemGem(Config.idSilmaril - 256);

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

	private static void register(Item item, String name) {
		String itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		item.setUnlocalizedName(itemName);
		GameRegistry.registerItem(item, itemName);
		CONTENT.add(item);
	}
}