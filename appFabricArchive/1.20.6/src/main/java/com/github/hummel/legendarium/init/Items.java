package com.github.hummel.legendarium.init;

import com.github.hummel.legendarium.item.ItemColdWeapon;
import com.github.hummel.legendarium.item.ItemGem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("WeakerAccess")
public class Items {
	public static final Collection<Item> CONTENT = new ArrayList<>();

	public static final Item WEAPON_ACHARN = new ItemColdWeapon();
	public static final Item WEAPON_AEGLOS = new ItemColdWeapon();
	public static final Item WEAPON_ALATAR = new ItemColdWeapon();
	public static final Item WEAPON_ANGRIST = new ItemColdWeapon();
	public static final Item WEAPON_ANGUIREL = new ItemColdWeapon();
	public static final Item WEAPON_ARANRUTH = new ItemColdWeapon();
	public static final Item WEAPON_AZOG = new ItemColdWeapon();
	public static final Item WEAPON_BALIN = new ItemColdWeapon();
	public static final Item WEAPON_BARAZANTHUAL = new ItemColdWeapon();
	public static final Item WEAPON_BOLG = new ItemColdWeapon();
	public static final Item WEAPON_BOROMIR = new ItemColdWeapon();
	public static final Item WEAPON_CELEBORN = new ItemColdWeapon();
	public static final Item WEAPON_DAGMOR = new ItemColdWeapon();
	public static final Item WEAPON_DAIN = new ItemColdWeapon();
	public static final Item WEAPON_DENETHOR = new ItemColdWeapon();
	public static final Item WEAPON_DORI = new ItemColdWeapon();
	public static final Item WEAPON_DRAMBORLEG = new ItemColdWeapon();
	public static final Item WEAPON_DURIN = new ItemColdWeapon();
	public static final Item WEAPON_DWALIN = new ItemColdWeapon();
	public static final Item WEAPON_EOTHAIN = new ItemColdWeapon();
	public static final Item WEAPON_EOWYN = new ItemColdWeapon();
	public static final Item WEAPON_FARAMIR = new ItemColdWeapon();
	public static final Item WEAPON_GAMLING = new ItemColdWeapon();
	public static final Item WEAPON_GIMLI = new ItemColdWeapon();
	public static final Item WEAPON_GIRION = new ItemColdWeapon();
	public static final Item WEAPON_GOBLINKING = new ItemColdWeapon();
	public static final Item WEAPON_GORBAG = new ItemColdWeapon();
	public static final Item WEAPON_GOTHMOG = new ItemColdWeapon();
	public static final Item WEAPON_GRIMA = new ItemColdWeapon();
	public static final Item WEAPON_GURTHANG = new ItemColdWeapon();
	public static final Item WEAPON_GUTHWINE = new ItemColdWeapon();
	public static final Item WEAPON_HADHAFANG = new ItemColdWeapon();
	public static final Item WEAPON_HERUGRIM = new ItemColdWeapon();
	public static final Item WEAPON_KHAMUL = new ItemColdWeapon();
	public static final Item WEAPON_KILI = new ItemColdWeapon();
	public static final Item WEAPON_LEGOLAS = new ItemColdWeapon();
	public static final Item WEAPON_MELKOR = new ItemColdWeapon();
	public static final Item WEAPON_MOUTHOFSAURON = new ItemColdWeapon();
	public static final Item WEAPON_NARCIL = new ItemColdWeapon();
	public static final Item WEAPON_NAZGUL = new ItemColdWeapon();
	public static final Item WEAPON_ORCRIST = new ItemColdWeapon();
	public static final Item WEAPON_PALLANDO = new ItemColdWeapon();
	public static final Item WEAPON_RADAGAST = new ItemColdWeapon();
	public static final Item WEAPON_SARUMAN = new ItemColdWeapon();
	public static final Item WEAPON_SHAGRAT = new ItemColdWeapon();
	public static final Item WEAPON_THORIN = new ItemColdWeapon();
	public static final Item WEAPON_THORONDUN = new ItemColdWeapon();
	public static final Item WEAPON_THRAIN = new ItemColdWeapon();
	public static final Item WEAPON_THRANDUIL = new ItemColdWeapon();
	public static final Item WEAPON_THROR = new ItemColdWeapon();
	public static final Item WEAPON_URFAEL = new ItemColdWeapon();
	public static final Item WEAPON_WITCHKING = new ItemColdWeapon();

	public static final Item ARKENSTONE = new ItemGem();
	public static final Item SILMARIL = new ItemGem();

	private Items() {
	}

	public static void register() {
		register(WEAPON_ACHARN, "weapon_acharn");
		register(WEAPON_AEGLOS, "weapon_aeglos");
		register(WEAPON_ALATAR, "weapon_alatar");
		register(WEAPON_ANGRIST, "weapon_angrist");
		register(WEAPON_ANGUIREL, "weapon_anguirel");
		register(WEAPON_ARANRUTH, "weapon_aranruth");
		register(WEAPON_AZOG, "weapon_azog");
		register(WEAPON_BALIN, "weapon_balin");
		register(WEAPON_BARAZANTHUAL, "weapon_barazanthual");
		register(WEAPON_BOLG, "weapon_bolg");
		register(WEAPON_BOROMIR, "weapon_boromir");
		register(WEAPON_CELEBORN, "weapon_celeborn");
		register(WEAPON_DAGMOR, "weapon_dagmor");
		register(WEAPON_DAIN, "weapon_dain");
		register(WEAPON_DENETHOR, "weapon_denethor");
		register(WEAPON_DORI, "weapon_dori");
		register(WEAPON_DRAMBORLEG, "weapon_dramborleg");
		register(WEAPON_DURIN, "weapon_durin");
		register(WEAPON_DWALIN, "weapon_dwalin");
		register(WEAPON_EOTHAIN, "weapon_eothain");
		register(WEAPON_EOWYN, "weapon_eowyn");
		register(WEAPON_FARAMIR, "weapon_faramir");
		register(WEAPON_GAMLING, "weapon_gamling");
		register(WEAPON_GIMLI, "weapon_gimli");
		register(WEAPON_GIRION, "weapon_girion");
		register(WEAPON_GOBLINKING, "weapon_goblinking");
		register(WEAPON_GORBAG, "weapon_gorbag");
		register(WEAPON_GOTHMOG, "weapon_gothmog");
		register(WEAPON_GRIMA, "weapon_grima");
		register(WEAPON_GURTHANG, "weapon_gurthang");
		register(WEAPON_GUTHWINE, "weapon_guthwine");
		register(WEAPON_HADHAFANG, "weapon_hadhafang");
		register(WEAPON_HERUGRIM, "weapon_herugrim");
		register(WEAPON_KHAMUL, "weapon_khamul");
		register(WEAPON_KILI, "weapon_kili");
		register(WEAPON_LEGOLAS, "weapon_legolas");
		register(WEAPON_MELKOR, "weapon_melkor");
		register(WEAPON_MOUTHOFSAURON, "weapon_mouthofsauron");
		register(WEAPON_NARCIL, "weapon_narcil");
		register(WEAPON_NAZGUL, "weapon_nazgul");
		register(WEAPON_ORCRIST, "weapon_orcrist");
		register(WEAPON_PALLANDO, "weapon_pallando");
		register(WEAPON_RADAGAST, "weapon_radagast");
		register(WEAPON_SARUMAN, "weapon_saruman");
		register(WEAPON_SHAGRAT, "weapon_shagrat");
		register(WEAPON_THORIN, "weapon_thorin");
		register(WEAPON_THORONDUN, "weapon_thorondun");
		register(WEAPON_THRAIN, "weapon_thrain");
		register(WEAPON_THRANDUIL, "weapon_thranduil");
		register(WEAPON_THROR, "weapon_thror");
		register(WEAPON_URFAEL, "weapon_urfael");
		register(WEAPON_WITCHKING, "weapon_witchking");

		register(ARKENSTONE, "arkenstone");
		register(SILMARIL, "silmaril");
	}

	private static void register(Item item, String name) {
		Registry.register(BuiltInRegistries.ITEM, new ResourceLocation("legendarium", name), item);
		CONTENT.add(item);
	}
}