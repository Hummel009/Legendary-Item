package legendarium;

import com.google.common.base.CaseFormat;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import legendarium.content.LICreativeTabs;
import legendarium.content.LIItemEmpty;
import legendarium.content.LIItemSword;
import legendarium.proxy.LICommonProxy;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Collection;

@Mod(modid = "legendarium", useMetadata = true)
public class LI {
	public static final String DISABLE_CURSEFORGE_DUPLICATE_NOTICE = "213313062023";

	public static final Collection<Item> CONTENT = new ArrayList<Item>();

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

	public static void register(Item item, String name) {
		String itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		item.setTextureName("legendarium:" + itemName);
		item.setUnlocalizedName(itemName);
		item.setCreativeTab(LICreativeTabs.TAB_ARTIFACTS);
		GameRegistry.registerItem(item, itemName);
		CONTENT.add(item);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LIConfig.preInit(event);

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

		proxy.preInit(event);
	}
}