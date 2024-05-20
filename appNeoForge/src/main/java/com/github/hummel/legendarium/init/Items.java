package com.github.hummel.legendarium.init;

import com.github.hummel.legendarium.item.ItemColdWeapon;
import com.github.hummel.legendarium.item.ItemGem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Items {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, "legendarium");

	public static final DeferredHolder<Item, Item> WEAPON_ACHARN = REGISTRY.register("weapon_acharn", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_AEGLOS = REGISTRY.register("weapon_aeglos", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_ALATAR = REGISTRY.register("weapon_alatar", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_ANGRIST = REGISTRY.register("weapon_angrist", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_ANGUIREL = REGISTRY.register("weapon_anguirel", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_ARANRUTH = REGISTRY.register("weapon_aranruth", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_AZOG = REGISTRY.register("weapon_azog", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_BALIN = REGISTRY.register("weapon_balin", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_BARAZANTHUAL = REGISTRY.register("weapon_barazanthual", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_BOLG = REGISTRY.register("weapon_bolg", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_BOROMIR = REGISTRY.register("weapon_boromir", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_CELEBORN = REGISTRY.register("weapon_celeborn", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_DAGMOR = REGISTRY.register("weapon_dagmor", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_DAIN = REGISTRY.register("weapon_dain", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_DENETHOR = REGISTRY.register("weapon_denethor", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_DORI = REGISTRY.register("weapon_dori", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_DRAMBORLEG = REGISTRY.register("weapon_dramborleg", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_DURIN = REGISTRY.register("weapon_durin", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_DWALIN = REGISTRY.register("weapon_dwalin", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_EOTHAIN = REGISTRY.register("weapon_eothain", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_EOWYN = REGISTRY.register("weapon_eowyn", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_FARAMIR = REGISTRY.register("weapon_faramir", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_GAMLING = REGISTRY.register("weapon_gamling", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_GIMLI = REGISTRY.register("weapon_gimli", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_GIRION = REGISTRY.register("weapon_girion", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_GOBLINKING = REGISTRY.register("weapon_goblinking", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_GORBAG = REGISTRY.register("weapon_gorbag", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_GOTHMOG = REGISTRY.register("weapon_gothmog", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_GRIMA = REGISTRY.register("weapon_grima", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_GURTHANG = REGISTRY.register("weapon_gurthang", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_GUTHWINE = REGISTRY.register("weapon_guthwine", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_HADHAFANG = REGISTRY.register("weapon_hadhafang", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_HERUGRIM = REGISTRY.register("weapon_herugrim", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_KHAMUL = REGISTRY.register("weapon_khamul", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_KILI = REGISTRY.register("weapon_kili", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_LEGOLAS = REGISTRY.register("weapon_legolas", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_MELKOR = REGISTRY.register("weapon_melkor", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_MOUTHOFSAURON = REGISTRY.register("weapon_mouthofsauron", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_NARCIL = REGISTRY.register("weapon_narcil", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_NAZGUL = REGISTRY.register("weapon_nazgul", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_ORCRIST = REGISTRY.register("weapon_orcrist", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_PALLANDO = REGISTRY.register("weapon_pallando", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_RADAGAST = REGISTRY.register("weapon_radagast", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_SARUMAN = REGISTRY.register("weapon_saruman", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_SHAGRAT = REGISTRY.register("weapon_shagrat", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_THORIN = REGISTRY.register("weapon_thorin", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_THORONDUN = REGISTRY.register("weapon_thorondun", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_THRAIN = REGISTRY.register("weapon_thrain", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_THRANDUIL = REGISTRY.register("weapon_thranduil", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_THROR = REGISTRY.register("weapon_thror", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_URFAEL = REGISTRY.register("weapon_urfael", ItemColdWeapon::new);
	public static final DeferredHolder<Item, Item> WEAPON_WITCHKING = REGISTRY.register("weapon_witchking", ItemColdWeapon::new);

	public static final DeferredHolder<Item, Item> ARKENSTONE = REGISTRY.register("arkenstone", ItemGem::new);
	public static final DeferredHolder<Item, Item> SILMARIL = REGISTRY.register("silmaril", ItemGem::new);

	private Items() {
	}

	public static void register(IEventBus modEventBus) {
		REGISTRY.register(modEventBus);
	}
}