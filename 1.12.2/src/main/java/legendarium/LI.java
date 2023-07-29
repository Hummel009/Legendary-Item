package legendarium;

import com.google.common.base.CaseFormat;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.*;

@Mod(modid = "legendarium")
public class LI {
	public static final String DISABLE_CURSEFORGE_DUPLICATE_NOTICE = "213313062023";

	public static final List<Item> CONTENT = new ArrayList<>();
	public static final Map<ModelResourceLocation, ModelResourceLocation> COMPLIANCES = new HashMap<>();

	public static Item armorAnarionHelmet;
	public static Item armorAnarionChestplate;
	public static Item armorAnarionLeggings;
	public static Item armorAnarionBoots;

	public static Item armorArpharazonHelmet;
	public static Item armorArpharazonChestplate;
	public static Item armorArpharazonLeggings;
	public static Item armorArpharazonBoots;

	public static Item armorArveduiHelmet;
	public static Item armorArveduiChestplate;
	public static Item armorArveduiLeggings;
	public static Item armorArveduiBoots;

	public static Item armorBoromirChestplate;
	public static Item armorBoromirLeggings;
	public static Item armorBoromirBoots;

	public static Item armorElendilHelmet;
	public static Item armorElendilChestplate;
	public static Item armorElendilLeggings;
	public static Item armorElendilBoots;

	public static Item armorElrosHelmet;
	public static Item armorElrosChestplate;
	public static Item armorElrosLeggings;
	public static Item armorElrosBoots;

	public static Item armorFeanorHelmet;
	public static Item armorFeanorChestplate;
	public static Item armorFeanorLeggings;
	public static Item armorFeanorBoots;

	public static Item armorGilgaladHelmet;
	public static Item armorGilgaladChestplate;
	public static Item armorGilgaladLeggings;
	public static Item armorGilgaladBoots;

	public static Item armorGimliHelmet;
	public static Item armorGimliChestplate;
	public static Item armorGimliLeggings;
	public static Item armorGimliBoots;

	public static Item armorIsildurHelmet;
	public static Item armorIsildurChestplate;
	public static Item armorIsildurLeggings;
	public static Item armorIsildurBoots;

	public static Item armorJiindurHelmet;
	public static Item armorJiindurChestplate;
	public static Item armorJiindurLeggings;
	public static Item armorJiindurBoots;

	public static Item armorKhamulHelmet;
	public static Item armorKhamulChestplate;
	public static Item armorKhamulLeggings;
	public static Item armorKhamulBoots;

	public static Item armorHoarmurathHelmet;
	public static Item armorHoarmurathChestplate;
	public static Item armorHoarmurathLeggings;
	public static Item armorHoarmurathBoots;

	public static Item armorMorgomirHelmet;
	public static Item armorMorgomirChestplate;
	public static Item armorMorgomirLeggings;
	public static Item armorMorgomirBoots;

	public static Item armorTheodenHelmet;
	public static Item armorTheodenChestplate;
	public static Item armorTheodenLeggings;
	public static Item armorTheodenBoots;

	public static Item armorTurgonHelmet;
	public static Item armorTurgonChestplate;
	public static Item armorTurgonLeggings;
	public static Item armorTurgonBoots;

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

	@Mod.EventBusSubscriber
	public static class MissingMappingsDetector {
		@SubscribeEvent
		public static void onMissingMappings(RegistryEvent.MissingMappings<Item> event) {
			Map<String, Item> renamed = new HashMap<>();
			renamed.put("armor_khommurat_helmet", armorHoarmurathHelmet);
			renamed.put("armor_khommurat_chestplate", armorHoarmurathChestplate);
			renamed.put("armor_khommurat_legs", armorHoarmurathLeggings);
			renamed.put("armor_khommurat_boots", armorHoarmurathBoots);
			renamed.put("armor_anarion_legs", armorAnarionLeggings);
			renamed.put("armor_arpharazon_legs", armorArpharazonLeggings);
			renamed.put("armor_arvedui_legs", armorArveduiLeggings);
			renamed.put("armor_boromir_legs", armorBoromirLeggings);
			renamed.put("armor_elendil_legs", armorElendilLeggings);
			renamed.put("armor_elros_legs", armorElrosLeggings);
			renamed.put("armor_feanor_legs", armorFeanorLeggings);
			renamed.put("armor_gilgalad_legs", armorGilgaladLeggings);
			renamed.put("armor_gimli_legs", armorGimliLeggings);
			renamed.put("armor_isildur_legs", armorIsildurLeggings);
			renamed.put("armor_jiindur_legs", armorJiindurLeggings);
			renamed.put("armor_khamul_legs", armorKhamulLeggings);
			renamed.put("armor_morgomir_legs", armorMorgomirLeggings);
			renamed.put("armor_theoden_legs", armorTheodenLeggings);
			renamed.put("armor_turgon_legs", armorTurgonLeggings);
			for (RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getAllMappings()) {
				for (Map.Entry<String, Item> entry : renamed.entrySet()) {
					if (mapping.key.getResourcePath().contains(entry.getKey())) {
						mapping.remap(entry.getValue());
						break;
					}
				}
			}
		}
	}

	@ObjectHolder("legendarium")
	@Mod.EventBusSubscriber
	public static class RegistryEvents {

		@SubscribeEvent
		public static void onItemRegistry(RegistryEvent.Register<Item> event) {
			armorAnarionHelmet = new LIItemArmor(LIMaterial.ANARION, EntityEquipmentSlot.HEAD);
			armorAnarionChestplate = new LIItemArmor(LIMaterial.ANARION, EntityEquipmentSlot.CHEST);
			armorAnarionLeggings = new LIItemArmor(LIMaterial.ANARION, EntityEquipmentSlot.LEGS);
			armorAnarionBoots = new LIItemArmor(LIMaterial.ANARION, EntityEquipmentSlot.FEET);

			armorArpharazonHelmet = new LIItemArmor(LIMaterial.ARPHARAZON, EntityEquipmentSlot.HEAD);
			armorArpharazonChestplate = new LIItemArmor(LIMaterial.ARPHARAZON, EntityEquipmentSlot.CHEST);
			armorArpharazonLeggings = new LIItemArmor(LIMaterial.ARPHARAZON, EntityEquipmentSlot.LEGS);
			armorArpharazonBoots = new LIItemArmor(LIMaterial.ARPHARAZON, EntityEquipmentSlot.FEET);

			armorArveduiHelmet = new LIItemArmor(LIMaterial.ARVEDUI, EntityEquipmentSlot.HEAD);
			armorArveduiChestplate = new LIItemArmor(LIMaterial.ARVEDUI, EntityEquipmentSlot.CHEST);
			armorArveduiLeggings = new LIItemArmor(LIMaterial.ARVEDUI, EntityEquipmentSlot.LEGS);
			armorArveduiBoots = new LIItemArmor(LIMaterial.ARVEDUI, EntityEquipmentSlot.FEET);

			armorBoromirChestplate = new LIItemArmor(LIMaterial.BOROMIR, EntityEquipmentSlot.CHEST);
			armorBoromirLeggings = new LIItemArmor(LIMaterial.BOROMIR, EntityEquipmentSlot.LEGS);
			armorBoromirBoots = new LIItemArmor(LIMaterial.BOROMIR, EntityEquipmentSlot.FEET);

			armorElendilHelmet = new LIItemArmor(LIMaterial.ELENDIL, EntityEquipmentSlot.HEAD);
			armorElendilChestplate = new LIItemArmor(LIMaterial.ELENDIL, EntityEquipmentSlot.CHEST);
			armorElendilLeggings = new LIItemArmor(LIMaterial.ELENDIL, EntityEquipmentSlot.LEGS);
			armorElendilBoots = new LIItemArmor(LIMaterial.ELENDIL, EntityEquipmentSlot.FEET);

			armorElrosHelmet = new LIItemArmor(LIMaterial.ELROS, EntityEquipmentSlot.HEAD);
			armorElrosChestplate = new LIItemArmor(LIMaterial.ELROS, EntityEquipmentSlot.CHEST);
			armorElrosLeggings = new LIItemArmor(LIMaterial.ELROS, EntityEquipmentSlot.LEGS);
			armorElrosBoots = new LIItemArmor(LIMaterial.ELROS, EntityEquipmentSlot.FEET);

			armorFeanorHelmet = new LIItemArmor(LIMaterial.FEANOR, EntityEquipmentSlot.HEAD);
			armorFeanorChestplate = new LIItemArmor(LIMaterial.FEANOR, EntityEquipmentSlot.CHEST);
			armorFeanorLeggings = new LIItemArmor(LIMaterial.FEANOR, EntityEquipmentSlot.LEGS);
			armorFeanorBoots = new LIItemArmor(LIMaterial.FEANOR, EntityEquipmentSlot.FEET);

			armorGilgaladHelmet = new LIItemArmor(LIMaterial.GILGALAD, EntityEquipmentSlot.HEAD);
			armorGilgaladChestplate = new LIItemArmor(LIMaterial.GILGALAD, EntityEquipmentSlot.CHEST);
			armorGilgaladLeggings = new LIItemArmor(LIMaterial.GILGALAD, EntityEquipmentSlot.LEGS);
			armorGilgaladBoots = new LIItemArmor(LIMaterial.GILGALAD, EntityEquipmentSlot.FEET);

			armorGimliHelmet = new LIItemArmor(LIMaterial.GIMLI, EntityEquipmentSlot.HEAD);
			armorGimliChestplate = new LIItemArmor(LIMaterial.GIMLI, EntityEquipmentSlot.CHEST);
			armorGimliLeggings = new LIItemArmor(LIMaterial.GIMLI, EntityEquipmentSlot.LEGS);
			armorGimliBoots = new LIItemArmor(LIMaterial.GIMLI, EntityEquipmentSlot.FEET);

			armorIsildurHelmet = new LIItemArmor(LIMaterial.ISILDUR, EntityEquipmentSlot.HEAD);
			armorIsildurChestplate = new LIItemArmor(LIMaterial.ISILDUR, EntityEquipmentSlot.CHEST);
			armorIsildurLeggings = new LIItemArmor(LIMaterial.ISILDUR, EntityEquipmentSlot.LEGS);
			armorIsildurBoots = new LIItemArmor(LIMaterial.ISILDUR, EntityEquipmentSlot.FEET);

			armorJiindurHelmet = new LIItemArmor(LIMaterial.JIINDUR, EntityEquipmentSlot.HEAD);
			armorJiindurChestplate = new LIItemArmor(LIMaterial.JIINDUR, EntityEquipmentSlot.CHEST);
			armorJiindurLeggings = new LIItemArmor(LIMaterial.JIINDUR, EntityEquipmentSlot.LEGS);
			armorJiindurBoots = new LIItemArmor(LIMaterial.JIINDUR, EntityEquipmentSlot.FEET);

			armorKhamulHelmet = new LIItemArmor(LIMaterial.KHAMUL, EntityEquipmentSlot.HEAD);
			armorKhamulChestplate = new LIItemArmor(LIMaterial.KHAMUL, EntityEquipmentSlot.CHEST);
			armorKhamulLeggings = new LIItemArmor(LIMaterial.KHAMUL, EntityEquipmentSlot.LEGS);
			armorKhamulBoots = new LIItemArmor(LIMaterial.KHAMUL, EntityEquipmentSlot.FEET);

			armorHoarmurathHelmet = new LIItemArmor(LIMaterial.HOARMURATH, EntityEquipmentSlot.HEAD);
			armorHoarmurathChestplate = new LIItemArmor(LIMaterial.HOARMURATH, EntityEquipmentSlot.CHEST);
			armorHoarmurathLeggings = new LIItemArmor(LIMaterial.HOARMURATH, EntityEquipmentSlot.LEGS);
			armorHoarmurathBoots = new LIItemArmor(LIMaterial.HOARMURATH, EntityEquipmentSlot.FEET);

			armorMorgomirHelmet = new LIItemArmor(LIMaterial.MORGOMIR, EntityEquipmentSlot.HEAD);
			armorMorgomirChestplate = new LIItemArmor(LIMaterial.MORGOMIR, EntityEquipmentSlot.CHEST);
			armorMorgomirLeggings = new LIItemArmor(LIMaterial.MORGOMIR, EntityEquipmentSlot.LEGS);
			armorMorgomirBoots = new LIItemArmor(LIMaterial.MORGOMIR, EntityEquipmentSlot.FEET);

			armorTheodenHelmet = new LIItemArmor(LIMaterial.THEODEN, EntityEquipmentSlot.HEAD);
			armorTheodenChestplate = new LIItemArmor(LIMaterial.THEODEN, EntityEquipmentSlot.CHEST);
			armorTheodenLeggings = new LIItemArmor(LIMaterial.THEODEN, EntityEquipmentSlot.LEGS);
			armorTheodenBoots = new LIItemArmor(LIMaterial.THEODEN, EntityEquipmentSlot.FEET);

			armorTurgonHelmet = new LIItemArmor(LIMaterial.TURGON, EntityEquipmentSlot.HEAD);
			armorTurgonChestplate = new LIItemArmor(LIMaterial.TURGON, EntityEquipmentSlot.CHEST);
			armorTurgonLeggings = new LIItemArmor(LIMaterial.TURGON, EntityEquipmentSlot.LEGS);
			armorTurgonBoots = new LIItemArmor(LIMaterial.TURGON, EntityEquipmentSlot.FEET);

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

			register(armorAnarionHelmet, "armorAnarionHelmet");
			register(armorAnarionChestplate, "armorAnarionChestplate");
			register(armorAnarionLeggings, "armorAnarionLeggings");
			register(armorAnarionBoots, "armorAnarionBoots");

			register(armorArpharazonHelmet, "armorArpharazonHelmet");
			register(armorArpharazonChestplate, "armorArpharazonChestplate");
			register(armorArpharazonLeggings, "armorArpharazonLeggings");
			register(armorArpharazonBoots, "armorArpharazonBoots");

			register(armorArveduiHelmet, "armorArveduiHelmet");
			register(armorArveduiChestplate, "armorArveduiChestplate");
			register(armorArveduiLeggings, "armorArveduiLeggings");
			register(armorArveduiBoots, "armorArveduiBoots");

			register(armorBoromirChestplate, "armorBoromirChestplate");
			register(armorBoromirLeggings, "armorBoromirLeggings");
			register(armorBoromirBoots, "armorBoromirBoots");

			register(armorElendilHelmet, "armorElendilHelmet");
			register(armorElendilChestplate, "armorElendilChestplate");
			register(armorElendilLeggings, "armorElendilLeggings");
			register(armorElendilBoots, "armorElendilBoots");

			register(armorElrosHelmet, "armorElrosHelmet");
			register(armorElrosChestplate, "armorElrosChestplate");
			register(armorElrosLeggings, "armorElrosLeggings");
			register(armorElrosBoots, "armorElrosBoots");

			register(armorFeanorHelmet, "armorFeanorHelmet");
			register(armorFeanorChestplate, "armorFeanorChestplate");
			register(armorFeanorLeggings, "armorFeanorLeggings");
			register(armorFeanorBoots, "armorFeanorBoots");

			register(armorGilgaladHelmet, "armorGilgaladHelmet");
			register(armorGilgaladChestplate, "armorGilgaladChestplate");
			register(armorGilgaladLeggings, "armorGilgaladLeggings");
			register(armorGilgaladBoots, "armorGilgaladBoots");

			register(armorGimliHelmet, "armorGimliHelmet");
			register(armorGimliChestplate, "armorGimliChestplate");
			register(armorGimliLeggings, "armorGimliLeggings");
			register(armorGimliBoots, "armorGimliBoots");

			register(armorIsildurHelmet, "armorIsildurHelmet");
			register(armorIsildurChestplate, "armorIsildurChestplate");
			register(armorIsildurLeggings, "armorIsildurLeggings");
			register(armorIsildurBoots, "armorIsildurBoots");

			register(armorJiindurHelmet, "armorJiindurHelmet");
			register(armorJiindurChestplate, "armorJiindurChestplate");
			register(armorJiindurLeggings, "armorJiindurLeggings");
			register(armorJiindurBoots, "armorJiindurBoots");

			register(armorKhamulHelmet, "armorKhamulHelmet");
			register(armorKhamulChestplate, "armorKhamulChestplate");
			register(armorKhamulLeggings, "armorKhamulLeggings");
			register(armorKhamulBoots, "armorKhamulBoots");

			register(armorHoarmurathHelmet, "armorHoarmurathHelmet");
			register(armorHoarmurathChestplate, "armorHoarmurathChestplate");
			register(armorHoarmurathLeggings, "armorHoarmurathLeggings");
			register(armorHoarmurathBoots, "armorHoarmurathBoots");

			register(armorMorgomirHelmet, "armorMorgomirHelmet");
			register(armorMorgomirChestplate, "armorMorgomirChestplate");
			register(armorMorgomirLeggings, "armorMorgomirLeggings");
			register(armorMorgomirBoots, "armorMorgomirBoots");

			register(armorTheodenHelmet, "armorTheodenHelmet");
			register(armorTheodenChestplate, "armorTheodenChestplate");
			register(armorTheodenLeggings, "armorTheodenLeggings");
			register(armorTheodenBoots, "armorTheodenBoots");

			register(armorTurgonHelmet, "armorTurgonHelmet");
			register(armorTurgonChestplate, "armorTurgonChestplate");
			register(armorTurgonLeggings, "armorTurgonLeggings");
			register(armorTurgonBoots, "armorTurgonBoots");

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

		@SubscribeEvent
		@SideOnly(Side.CLIENT)
		public static void onModelBake(ModelBakeEvent event) {
			for (Map.Entry<ModelResourceLocation, ModelResourceLocation> compliance : COMPLIANCES.entrySet()) {
				ModelResourceLocation smallLocation = compliance.getKey();
				IBakedModel smallModel = event.getModelRegistry().getObject(smallLocation);
				if (smallModel != null) {
					ModelResourceLocation largeLocation = compliance.getValue();
					IBakedModel largeModel = event.getModelRegistry().getObject(largeLocation);
					if (largeModel != null) {
						event.getModelRegistry().putObject(smallLocation, new LIItemSword.LargeItemModel(smallModel, largeModel));
					}
				}
			}
		}

		@SubscribeEvent
		@SideOnly(Side.CLIENT)
		public static void onModelRegistry(ModelRegistryEvent event) {
			Set<Item> inapplicable = new HashSet<>();
			inapplicable.add(weaponAngrist);
			inapplicable.add(weaponAcharn);
			inapplicable.add(weaponLegolas);
			inapplicable.add(weaponGrima);
			for (Item item : CONTENT) {
				ResourceLocation itemName = item.getRegistryName();
				ModelResourceLocation smallModel = new ModelResourceLocation(itemName, "inventory");
				ModelResourceLocation largeModel = new ModelResourceLocation(itemName + "_large", "inventory");
				if (item instanceof LIItemSword && !inapplicable.contains(item)) {
					COMPLIANCES.put(smallModel, largeModel);
					ModelBakery.registerItemVariants(item, smallModel, largeModel);
				} else {
					ModelBakery.registerItemVariants(item, smallModel);
				}
				ModelLoader.setCustomModelResourceLocation(item, 0, smallModel);
			}
		}

		public static void register(Item item, String name) {
			String itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
			item.setUnlocalizedName(itemName);
			item.setRegistryName(itemName);
			ForgeRegistries.ITEMS.register(item);
			CONTENT.add(item);
		}
	}
}