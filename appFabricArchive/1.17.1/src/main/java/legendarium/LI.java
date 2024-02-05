package legendarium;

import legendarium.content.LIItemEmpty;
import legendarium.content.LIItemSword;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("WeakerAccess")
public class LI implements ModInitializer {
	public static final String DISABLE_CURSEFORGE_DUPLICATE_NOTICE = "131829122023";
	public static final Collection<Item> CONTENT = new ArrayList<>();

	public static final Item WEAPON_ACHARN = new LIItemSword();
	public static final Item WEAPON_AEGLOS = new LIItemSword();
	public static final Item WEAPON_ALATAR = new LIItemSword();
	public static final Item WEAPON_ANGRIST = new LIItemSword();
	public static final Item WEAPON_ANGUIREL = new LIItemSword();
	public static final Item WEAPON_ARANRUTH = new LIItemSword();
	public static final Item WEAPON_AZOG = new LIItemSword();
	public static final Item WEAPON_BALIN = new LIItemSword();
	public static final Item WEAPON_BARAZANTHUAL = new LIItemSword();
	public static final Item WEAPON_BOLG = new LIItemSword();
	public static final Item WEAPON_BOROMIR = new LIItemSword();
	public static final Item WEAPON_CELEBORN = new LIItemSword();
	public static final Item WEAPON_DAGMOR = new LIItemSword();
	public static final Item WEAPON_DAIN = new LIItemSword();
	public static final Item WEAPON_DENETHOR = new LIItemSword();
	public static final Item WEAPON_DORI = new LIItemSword();
	public static final Item WEAPON_DRAMBORLEG = new LIItemSword();
	public static final Item WEAPON_DURIN = new LIItemSword();
	public static final Item WEAPON_DWALIN = new LIItemSword();
	public static final Item WEAPON_EOTHAIN = new LIItemSword();
	public static final Item WEAPON_EOWYN = new LIItemSword();
	public static final Item WEAPON_FARAMIR = new LIItemSword();
	public static final Item WEAPON_GAMLING = new LIItemSword();
	public static final Item WEAPON_GIMLI = new LIItemSword();
	public static final Item WEAPON_GIRION = new LIItemSword();
	public static final Item WEAPON_GOBLINKING = new LIItemSword();
	public static final Item WEAPON_GORBAG = new LIItemSword();
	public static final Item WEAPON_GOTHMOG = new LIItemSword();
	public static final Item WEAPON_GRIMA = new LIItemSword();
	public static final Item WEAPON_GURTHANG = new LIItemSword();
	public static final Item WEAPON_GUTHWINE = new LIItemSword();
	public static final Item WEAPON_HADHAFANG = new LIItemSword();
	public static final Item WEAPON_HERUGRIM = new LIItemSword();
	public static final Item WEAPON_KHAMUL = new LIItemSword();
	public static final Item WEAPON_KILI = new LIItemSword();
	public static final Item WEAPON_LEGOLAS = new LIItemSword();
	public static final Item WEAPON_MELKOR = new LIItemSword();
	public static final Item WEAPON_MOUTHOFSAURON = new LIItemSword();
	public static final Item WEAPON_NARCIL = new LIItemSword();
	public static final Item WEAPON_NAZGUL = new LIItemSword();
	public static final Item WEAPON_ORCRIST = new LIItemSword();
	public static final Item WEAPON_PALLANDO = new LIItemSword();
	public static final Item WEAPON_RADAGAST = new LIItemSword();
	public static final Item WEAPON_SARUMAN = new LIItemSword();
	public static final Item WEAPON_SHAGRAT = new LIItemSword();
	public static final Item WEAPON_THORIN = new LIItemSword();
	public static final Item WEAPON_THORONDUN = new LIItemSword();
	public static final Item WEAPON_THRAIN = new LIItemSword();
	public static final Item WEAPON_THRANDUIL = new LIItemSword();
	public static final Item WEAPON_THROR = new LIItemSword();
	public static final Item WEAPON_URFAEL = new LIItemSword();
	public static final Item WEAPON_WITCHKING = new LIItemSword();

	public static final Item ARKENSTONE = new LIItemEmpty();
	public static final Item SILMARIL = new LIItemEmpty();

	public static final CreativeModeTab TAB_ARTIFACTS = FabricItemGroupBuilder.create(new ResourceLocation("legendarium", "artifacts")).icon(() -> new ItemStack(WEAPON_FARAMIR)).appendItems(entries -> {
		for (var item : CONTENT) {
			entries.add(new ItemStack(item));
		}
	}).build();

	private static void register(Item item, String name) {
		Registry.register(Registry.ITEM, new ResourceLocation("legendarium", name), item);
	}

	@Override
	public void onInitialize() {
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
}