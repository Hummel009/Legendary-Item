package com.github.hummel.legendarium.init;

import com.github.hummel.legendarium.item.ItemColdWeapon;
import com.github.hummel.legendarium.item.ItemGem;
import com.google.common.base.CaseFormat;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Items {
	public static final Collection<Item> CONTENT = new ArrayList<>();

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
		weaponAcharn = new ItemColdWeapon();
		weaponAeglos = new ItemColdWeapon();
		weaponAlatar = new ItemColdWeapon();
		weaponAngrist = new ItemColdWeapon();
		weaponAnguirel = new ItemColdWeapon();
		weaponAranruth = new ItemColdWeapon();
		weaponAzog = new ItemColdWeapon();
		weaponBalin = new ItemColdWeapon();
		weaponBarazanthual = new ItemColdWeapon();
		weaponBolg = new ItemColdWeapon();
		weaponBoromir = new ItemColdWeapon();
		weaponCeleborn = new ItemColdWeapon();
		weaponDagmor = new ItemColdWeapon();
		weaponDain = new ItemColdWeapon();
		weaponDenethor = new ItemColdWeapon();
		weaponDori = new ItemColdWeapon();
		weaponDramborleg = new ItemColdWeapon();
		weaponDurin = new ItemColdWeapon();
		weaponDwalin = new ItemColdWeapon();
		weaponEothain = new ItemColdWeapon();
		weaponEowyn = new ItemColdWeapon();
		weaponFaramir = new ItemColdWeapon();
		weaponGamling = new ItemColdWeapon();
		weaponGimli = new ItemColdWeapon();
		weaponGirion = new ItemColdWeapon();
		weaponGoblinking = new ItemColdWeapon();
		weaponGorbag = new ItemColdWeapon();
		weaponGothmog = new ItemColdWeapon();
		weaponGrima = new ItemColdWeapon();
		weaponGurthang = new ItemColdWeapon();
		weaponGuthwine = new ItemColdWeapon();
		weaponHadhafang = new ItemColdWeapon();
		weaponHerugrim = new ItemColdWeapon();
		weaponKhamul = new ItemColdWeapon();
		weaponKili = new ItemColdWeapon();
		weaponLegolas = new ItemColdWeapon();
		weaponMelkor = new ItemColdWeapon();
		weaponMouthofsauron = new ItemColdWeapon();
		weaponNarcil = new ItemColdWeapon();
		weaponNazgul = new ItemColdWeapon();
		weaponOrcrist = new ItemColdWeapon();
		weaponPallando = new ItemColdWeapon();
		weaponRadagast = new ItemColdWeapon();
		weaponSaruman = new ItemColdWeapon();
		weaponShagrat = new ItemColdWeapon();
		weaponThorin = new ItemColdWeapon();
		weaponThorondun = new ItemColdWeapon();
		weaponThrain = new ItemColdWeapon();
		weaponThranduil = new ItemColdWeapon();
		weaponThror = new ItemColdWeapon();
		weaponUrfael = new ItemColdWeapon();
		weaponWitchking = new ItemColdWeapon();

		arkenstone = new ItemGem();
		silmaril = new ItemGem();

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
		item.setRegistryName(itemName);
		ForgeRegistries.ITEMS.register(item);
		CONTENT.add(item);
	}
}