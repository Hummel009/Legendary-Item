package legendarium.content;

import com.google.common.base.CaseFormat;
import cpw.mods.fml.common.registry.GameRegistry;
import legendarium.LIDependencyManager;
import legendarium.render.LIRenderLargeItem;
import legendarium.render.LIRenderable;
import legendarium.render.LIRenderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LIRegistry implements LIDependencyManager {
	public static final List<Item> CONTENT = new ArrayList<>();

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
	public static Item weaponAngrist;
	public static Item weaponAnguirel;
	public static Item weaponBalin;
	public static Item weaponBarazanthual;
	public static Item weaponBolg;
	public static Item weaponBoromir;
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
	public static Item weaponGorbag;
	public static Item weaponGothmog;
	public static Item weaponGrima;
	public static Item weaponGurthang;
	public static Item weaponGuthwine;
	public static Item weaponHerugrim;
	public static Item weaponKhamul;
	public static Item weaponKili;
	public static Item weaponLegolas;
	public static Item weaponMouthofsauron;
	public static Item weaponNarcil;
	public static Item weaponNazgul;
	public static Item weaponShagrat;
	public static Item weaponThorin;
	public static Item weaponThrain;
	public static Item weaponThror;
	public static Item weaponUrfael;

	public static Item weaponAzog;
	public static Item weaponAeglos;
	public static Item weaponAlatar;
	public static Item weaponAranruth;
	public static Item weaponCeleborn;
	public static Item weaponGoblinking;
	public static Item weaponHadhafang;
	public static Item weaponMelkor;
	public static Item weaponOrcrist;
	public static Item weaponPallando;
	public static Item weaponRadagast;
	public static Item weaponSaruman;
	public static Item weaponThorondun;
	public static Item weaponThranduil;
	public static Item weaponWitchking;

	public static Item arkenstone;
	public static Item silmaril;

	public void registerCommon() {
		silmaril = new LIItemEmpty();
		arkenstone = new LIItemEmpty();
		
		armorAnarionBoots = new LIItemArmor(LIMaterial.ANARION, 3);
		armorAnarionChestplate = new LIItemArmor(LIMaterial.ANARION, 1);
		armorAnarionHelmet = new LIItemArmor(LIMaterial.ANARION, 0);
		armorAnarionLegs = new LIItemArmor(LIMaterial.ANARION, 2);

		armorArpharazonBoots = new LIItemArmor(LIMaterial.ARPHARAZON, 3);
		armorArpharazonChestplate = new LIItemArmor(LIMaterial.ARPHARAZON, 1);
		armorArpharazonHelmet = new LIItemArmor(LIMaterial.ARPHARAZON, 0);
		armorArpharazonLegs = new LIItemArmor(LIMaterial.ARPHARAZON, 2);

		armorArveduiBoots = new LIItemArmor(LIMaterial.ARVEDUI, 3);
		armorArveduiChestplate = new LIItemArmor(LIMaterial.ARVEDUI, 1);
		armorArveduiHelmet = new LIItemArmor(LIMaterial.ARVEDUI, 0);
		armorArveduiLegs = new LIItemArmor(LIMaterial.ARVEDUI, 2);

		armorBoromirBoots = new LIItemArmor(LIMaterial.BOROMIR, 3);
		armorBoromirChestplate = new LIItemArmor(LIMaterial.BOROMIR, 1);
		armorBoromirLegs = new LIItemArmor(LIMaterial.BOROMIR, 2);

		armorElendilBoots = new LIItemArmor(LIMaterial.ELENDIL, 3);
		armorElendilChestplate = new LIItemArmor(LIMaterial.ELENDIL, 1);
		armorElendilHelmet = new LIItemArmor(LIMaterial.ELENDIL, 0);
		armorElendilLegs = new LIItemArmor(LIMaterial.ELENDIL, 2);

		armorElrosBoots = new LIItemArmor(LIMaterial.ELROS, 3);
		armorElrosChestplate = new LIItemArmor(LIMaterial.ELROS, 1);
		armorElrosHelmet = new LIItemArmor(LIMaterial.ELROS, 0);
		armorElrosLegs = new LIItemArmor(LIMaterial.ELROS, 2);

		armorFeanorBoots = new LIItemArmor(LIMaterial.FEANOR, 3);
		armorFeanorChestplate = new LIItemArmor(LIMaterial.FEANOR, 1);
		armorFeanorHelmet = new LIItemArmor(LIMaterial.FEANOR, 0);
		armorFeanorLegs = new LIItemArmor(LIMaterial.FEANOR, 2);

		armorGilgaladBoots = new LIItemArmor(LIMaterial.GILGALAD, 3);
		armorGilgaladChestplate = new LIItemArmor(LIMaterial.GILGALAD, 1);
		armorGilgaladHelmet = new LIItemArmor(LIMaterial.GILGALAD, 0);
		armorGilgaladLegs = new LIItemArmor(LIMaterial.GILGALAD, 2);

		armorGimliBoots = new LIItemArmor(LIMaterial.GIMLI, 3);
		armorGimliChestplate = new LIItemArmor(LIMaterial.GIMLI, 1);
		armorGimliHelmet = new LIItemArmor(LIMaterial.GIMLI, 0);
		armorGimliLegs = new LIItemArmor(LIMaterial.GIMLI, 2);

		armorIsildurBoots = new LIItemArmor(LIMaterial.ISILDUR, 3);
		armorIsildurChestplate = new LIItemArmor(LIMaterial.ISILDUR, 1);
		armorIsildurHelmet = new LIItemArmor(LIMaterial.ISILDUR, 0);
		armorIsildurLegs = new LIItemArmor(LIMaterial.ISILDUR, 2);

		armorJiindurBoots = new LIItemArmor(LIMaterial.JIINDUR, 3);
		armorJiindurChestplate = new LIItemArmor(LIMaterial.JIINDUR, 1);
		armorJiindurHelmet = new LIItemArmor(LIMaterial.JIINDUR, 0);
		armorJiindurLegs = new LIItemArmor(LIMaterial.JIINDUR, 2);

		armorKhamulBoots = new LIItemArmor(LIMaterial.KHAMUL, 3);
		armorKhamulChestplate = new LIItemArmor(LIMaterial.KHAMUL, 1);
		armorKhamulHelmet = new LIItemArmor(LIMaterial.KHAMUL, 0);
		armorKhamulLegs = new LIItemArmor(LIMaterial.KHAMUL, 2);

		armorKhommuratBoots = new LIItemArmor(LIMaterial.KHOMMURAT, 3);
		armorKhommuratChestplate = new LIItemArmor(LIMaterial.KHOMMURAT, 1);
		armorKhommuratHelmet = new LIItemArmor(LIMaterial.KHOMMURAT, 0);
		armorKhommuratLegs = new LIItemArmor(LIMaterial.KHOMMURAT, 2);

		armorMorgomirBoots = new LIItemArmor(LIMaterial.MORGOMIR, 3);
		armorMorgomirChestplate = new LIItemArmor(LIMaterial.MORGOMIR, 1);
		armorMorgomirHelmet = new LIItemArmor(LIMaterial.MORGOMIR, 0);
		armorMorgomirLegs = new LIItemArmor(LIMaterial.MORGOMIR, 2);

		armorTheodenBoots = new LIItemArmor(LIMaterial.THEODEN, 3);
		armorTheodenChestplate = new LIItemArmor(LIMaterial.THEODEN, 1);
		armorTheodenHelmet = new LIItemArmor(LIMaterial.THEODEN, 0);
		armorTheodenLegs = new LIItemArmor(LIMaterial.THEODEN, 2);

		armorTurgonBoots = new LIItemArmor(LIMaterial.TURGON, 3);
		armorTurgonChestplate = new LIItemArmor(LIMaterial.TURGON, 1);
		armorTurgonHelmet = new LIItemArmor(LIMaterial.TURGON, 0);
		armorTurgonLegs = new LIItemArmor(LIMaterial.TURGON, 2);

		weaponAcharn = new LIItemSword();
		weaponAngrist = new LIItemSword();
		weaponAnguirel = new LIItemSword();
		weaponBalin = new LIItemSword();
		weaponBarazanthual = new LIItemSword();
		weaponBolg = new LIItemSword();
		weaponBoromir = new LIItemSword();
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
		weaponGorbag = new LIItemSword();
		weaponGothmog = new LIItemSword();
		weaponGrima = new LIItemSword();
		weaponGurthang = new LIItemSword();
		weaponGuthwine = new LIItemSword();
		weaponHerugrim = new LIItemSword();
		weaponKhamul = new LIItemSword();
		weaponKili = new LIItemSword();
		weaponLegolas = new LIItemSword();
		weaponMouthofsauron = new LIItemSword();
		weaponNarcil = new LIItemSword();
		weaponNazgul = new LIItemSword();
		weaponShagrat = new LIItemSword();
		weaponThorin = new LIItemSword();
		weaponThrain = new LIItemSword();
		weaponThror = new LIItemSword();
		weaponUrfael = new LIItemSword();

		register(arkenstone, "arkenstone");
		register(silmaril, "silmaril");

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
		register(weaponAngrist, "weaponAngrist");
		register(weaponAnguirel, "weaponAnguirel");
		register(weaponBalin, "weaponBalin");
		register(weaponBarazanthual, "weaponBarazanthual");
		register(weaponBolg, "weaponBolg");
		register(weaponBoromir, "weaponBoromir");
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
		register(weaponGorbag, "weaponGorbag");
		register(weaponGothmog, "weaponGothmog");
		register(weaponGrima, "weaponGrima");
		register(weaponGurthang, "weaponGurthang");
		register(weaponGuthwine, "weaponGuthwine");
		register(weaponHerugrim, "weaponHerugrim");
		register(weaponKhamul, "weaponKhamul");
		register(weaponKili, "weaponKili");
		register(weaponLegolas, "weaponLegolas");
		register(weaponMouthofsauron, "weaponMouthofsauron");
		register(weaponNarcil, "weaponNarcil");
		register(weaponNazgul, "weaponNazgul");
		register(weaponShagrat, "weaponShagrat");
		register(weaponThorin, "weaponThorin");
		register(weaponThrain, "weaponThrain");
		register(weaponThror, "weaponThror");
		register(weaponUrfael, "weaponUrfael");
	}

	@Override
	public void registerSpecial() {
		weaponAzog = new LIItemSword();
		weaponAeglos = new LIItemSword();
		weaponAlatar = new LIItemSword();
		weaponAranruth = new LIItemSword();
		weaponCeleborn = new LIItemSword();
		weaponGoblinking = new LIItemSword();
		weaponHadhafang = new LIItemSword();
		weaponMelkor = new LIItemSword();
		weaponOrcrist = new LIItemSword();
		weaponPallando = new LIItemSword();
		weaponRadagast = new LIItemSword();
		weaponSaruman = new LIItemSword();
		weaponThorondun = new LIItemSword();
		weaponThranduil = new LIItemSword();
		weaponWitchking = new LIItemSword();

		register(weaponAzog, "weaponAzog");
		register(weaponAeglos, "weaponAeglos");
		register(weaponAlatar, "weaponAlatar");
		register(weaponAranruth, "weaponAranruth");
		register(weaponCeleborn, "weaponCeleborn");
		register(weaponGoblinking, "weaponGoblinking");
		register(weaponHadhafang, "weaponHadhafang");
		register(weaponMelkor, "weaponMelkor");
		register(weaponOrcrist, "weaponOrcrist");
		register(weaponPallando, "weaponPallando");
		register(weaponRadagast, "weaponRadagast");
		register(weaponSaruman, "weaponSaruman");
		register(weaponThorondun, "weaponThorondun");
		register(weaponThranduil, "weaponThranduil");
		register(weaponWitchking, "weaponWitchking");
	}

	@Override
	public void register(Item item, String field) {
		String name = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field);
		item.setUnlocalizedName(name);
		item.setTextureName("legendarium:" + name);
		item.setCreativeTab(LICreativeTabs.TAB_ARTIFACTS);
		GameRegistry.registerItem(item, name);
		CONTENT.add(item);
	}

	@Override
	public LIRenderable getRendererIfLarge(Item item) {
		for (Map.Entry<String, Float> folder : LIRenderLargeItem.sizeFolders.entrySet()) {
			float iconScale = folder.getValue();
			try {
				ResourceLocation resLoc = LIRenderLargeItem.getLargeTexturePath(item, folder.getKey());
				IResource res = Minecraft.getMinecraft().getResourceManager().getResource(resLoc);
				if (res != null) {
					return new LIRenderLargeItem(item, folder.getKey(), iconScale);
				}
			} catch (Exception ignored) {
			}
		}
		return null;
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		LIRenderManager.largeItemRenderers.clear();
		for (Item item : CONTENT) {
			MinecraftForgeClient.registerItemRenderer(item, null);
			LIRenderable largeItemRenderer = getRendererIfLarge(item);
			if (largeItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item, (IItemRenderer) largeItemRenderer);
			}
			if (largeItemRenderer != null) {
				LIRenderManager.largeItemRenderers.add(largeItemRenderer);
			}
		}
	}

}
