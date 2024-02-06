package legendarium;

import com.google.common.base.CaseFormat;
import legendarium.content.LIItemEmpty;
import legendarium.content.LIItemSword;
import legendarium.proxy.LICommonProxy;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings({"WeakerAccess", "PublicField"})
@Mod(modid = "legendarium", useMetadata = true)
public class LI {
	public static final String DISABLE_CURSEFORGE_DUPLICATE_NOTICE = "131829122023";

	public static final Collection<Item> CONTENT = new ArrayList<>();

	@SidedProxy(serverSide = "legendarium.proxy.LICommonProxy", clientSide = "legendarium.proxy.LIClientProxy")
	public static LICommonProxy proxy;

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

	private static void register(Item item, String name) {
		String itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		item.setUnlocalizedName(itemName);
		item.setRegistryName(itemName);
		GameRegistry.registerItem(item, itemName);
		CONTENT.add(item);
	}

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		proxy.onInit();
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(proxy);

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