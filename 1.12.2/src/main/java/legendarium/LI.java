package legendarium;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Objects;

@Mod(modid = "legendarium")
public class LI {
	public static final ArrayList<Item> CONTENT = new ArrayList<>();
	public static Item armor_anarion_helmet;
	public static Item armor_anarion_chestplate;
	public static Item armor_anarion_legs;
	public static Item armor_anarion_boots;
	public static Item armor_arpharazon_helmet;
	public static Item armor_arpharazon_chestplate;
	public static Item armor_arpharazon_legs;
	public static Item armor_arpharazon_boots;
	public static Item armor_arvedui_helmet;
	public static Item armor_arvedui_chestplate;
	public static Item armor_arvedui_legs;
	public static Item armor_arvedui_boots;
	public static Item armor_boromir_chestplate;
	public static Item armor_boromir_legs;
	public static Item armor_boromir_boots;
	public static Item armor_elendil_helmet;
	public static Item armor_elendil_chestplate;
	public static Item armor_elendil_legs;
	public static Item armor_elendil_boots;
	public static Item armor_elros_helmet;
	public static Item armor_elros_chestplate;
	public static Item armor_elros_legs;
	public static Item armor_elros_boots;
	public static Item armor_feanor_helmet;
	public static Item armor_feanor_chestplate;
	public static Item armor_feanor_legs;
	public static Item armor_feanor_boots;
	public static Item armor_gilgalad_helmet;
	public static Item armor_gilgalad_chestplate;
	public static Item armor_gilgalad_legs;
	public static Item armor_gilgalad_boots;
	public static Item armor_gimli_helmet;
	public static Item armor_gimli_chestplate;
	public static Item armor_gimli_legs;
	public static Item armor_gimli_boots;
	public static Item armor_isildur_helmet;
	public static Item armor_isildur_chestplate;
	public static Item armor_isildur_legs;
	public static Item armor_isildur_boots;
	public static Item armor_jiindur_helmet;
	public static Item armor_jiindur_chestplate;
	public static Item armor_jiindur_legs;
	public static Item armor_jiindur_boots;
	public static Item armor_khamul_helmet;
	public static Item armor_khamul_chestplate;
	public static Item armor_khamul_legs;
	public static Item armor_khamul_boots;
	public static Item armor_khommurat_helmet;
	public static Item armor_khommurat_chestplate;
	public static Item armor_khommurat_legs;
	public static Item armor_khommurat_boots;
	public static Item armor_morgomir_helmet;
	public static Item armor_morgomir_chestplate;
	public static Item armor_morgomir_legs;
	public static Item armor_morgomir_boots;
	public static Item armor_theoden_helmet;
	public static Item armor_theoden_chestplate;
	public static Item armor_theoden_legs;
	public static Item armor_theoden_boots;
	public static Item armor_turgon_helmet;
	public static Item armor_turgon_chestplate;
	public static Item armor_turgon_legs;
	public static Item armor_turgon_boots;
	public static Item weapon_acharn;
	public static Item weapon_aeglos;
	public static Item weapon_alatar;
	public static Item weapon_angrist;
	public static Item weapon_anguirel;
	public static Item weapon_aranruth;
	public static Item weapon_azog;
	public static Item weapon_balin;
	public static Item weapon_barazanthual;
	public static Item weapon_bolg;
	public static Item weapon_boromir;
	public static Item weapon_celeborn;
	public static Item weapon_dagmor;
	public static Item weapon_dain;
	public static Item weapon_denethor;
	public static Item weapon_dori;
	public static Item weapon_dramborleg;
	public static Item weapon_durin;
	public static Item weapon_dwalin;
	public static Item weapon_eothain;
	public static Item weapon_eowyn;
	public static Item weapon_faramir;
	public static Item weapon_gamling;
	public static Item weapon_gimli;
	public static Item weapon_girion;
	public static Item weapon_goblinking;
	public static Item weapon_gorbag;
	public static Item weapon_gothmog;
	public static Item weapon_grima;
	public static Item weapon_gurthang;
	public static Item weapon_guthwine;
	public static Item weapon_hadhafang;
	public static Item weapon_herugrim;
	public static Item weapon_khamul;
	public static Item weapon_kili;
	public static Item weapon_legolas;
	public static Item weapon_melkor;
	public static Item weapon_mouthofsauron;
	public static Item weapon_narcil;
	public static Item weapon_nazgul;
	public static Item weapon_orcrist;
	public static Item weapon_pallando;
	public static Item weapon_radagast;
	public static Item weapon_saruman;
	public static Item weapon_shagrat;
	public static Item weapon_thorin;
	public static Item weapon_thorondun;
	public static Item weapon_thrain;
	public static Item weapon_thranduil;
	public static Item weapon_thror;
	public static Item weapon_urfael;
	public static Item weapon_witchking;
	public static Item arkenstone;
	public static Item silmaril;

	@ObjectHolder("legendarium")
	@Mod.EventBusSubscriber
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onRegistryItem(RegistryEvent.Register<Item> event) {
			armor_anarion_helmet = new LIItemArmor(LIMaterial.ANARION, EntityEquipmentSlot.HEAD);
			armor_anarion_chestplate = new LIItemArmor(LIMaterial.ANARION, EntityEquipmentSlot.CHEST);
			armor_anarion_legs = new LIItemArmor(LIMaterial.ANARION, EntityEquipmentSlot.LEGS);
			armor_anarion_boots = new LIItemArmor(LIMaterial.ANARION, EntityEquipmentSlot.FEET);

			armor_arpharazon_helmet = new LIItemArmor(LIMaterial.ARPHARAZON, EntityEquipmentSlot.HEAD);
			armor_arpharazon_chestplate = new LIItemArmor(LIMaterial.ARPHARAZON, EntityEquipmentSlot.CHEST);
			armor_arpharazon_legs = new LIItemArmor(LIMaterial.ARPHARAZON, EntityEquipmentSlot.LEGS);
			armor_arpharazon_boots = new LIItemArmor(LIMaterial.ARPHARAZON, EntityEquipmentSlot.FEET);

			armor_arvedui_helmet = new LIItemArmor(LIMaterial.ARVEDUI, EntityEquipmentSlot.HEAD);
			armor_arvedui_chestplate = new LIItemArmor(LIMaterial.ARVEDUI, EntityEquipmentSlot.CHEST);
			armor_arvedui_legs = new LIItemArmor(LIMaterial.ARVEDUI, EntityEquipmentSlot.LEGS);
			armor_arvedui_boots = new LIItemArmor(LIMaterial.ARVEDUI, EntityEquipmentSlot.FEET);

			armor_boromir_chestplate = new LIItemArmor(LIMaterial.BOROMIR, EntityEquipmentSlot.CHEST);
			armor_boromir_legs = new LIItemArmor(LIMaterial.BOROMIR, EntityEquipmentSlot.LEGS);
			armor_boromir_boots = new LIItemArmor(LIMaterial.BOROMIR, EntityEquipmentSlot.FEET);

			armor_elendil_helmet = new LIItemArmor(LIMaterial.ELENDIL, EntityEquipmentSlot.HEAD);
			armor_elendil_chestplate = new LIItemArmor(LIMaterial.ELENDIL, EntityEquipmentSlot.CHEST);
			armor_elendil_legs = new LIItemArmor(LIMaterial.ELENDIL, EntityEquipmentSlot.LEGS);
			armor_elendil_boots = new LIItemArmor(LIMaterial.ELENDIL, EntityEquipmentSlot.FEET);

			armor_elros_helmet = new LIItemArmor(LIMaterial.ELROS, EntityEquipmentSlot.HEAD);
			armor_elros_chestplate = new LIItemArmor(LIMaterial.ELROS, EntityEquipmentSlot.CHEST);
			armor_elros_legs = new LIItemArmor(LIMaterial.ELROS, EntityEquipmentSlot.LEGS);
			armor_elros_boots = new LIItemArmor(LIMaterial.ELROS, EntityEquipmentSlot.FEET);

			armor_feanor_helmet = new LIItemArmor(LIMaterial.FEANOR, EntityEquipmentSlot.HEAD);
			armor_feanor_chestplate = new LIItemArmor(LIMaterial.FEANOR, EntityEquipmentSlot.CHEST);
			armor_feanor_legs = new LIItemArmor(LIMaterial.FEANOR, EntityEquipmentSlot.LEGS);
			armor_feanor_boots = new LIItemArmor(LIMaterial.FEANOR, EntityEquipmentSlot.FEET);

			armor_gilgalad_helmet = new LIItemArmor(LIMaterial.GILGALAD, EntityEquipmentSlot.HEAD);
			armor_gilgalad_chestplate = new LIItemArmor(LIMaterial.GILGALAD, EntityEquipmentSlot.CHEST);
			armor_gilgalad_legs = new LIItemArmor(LIMaterial.GILGALAD, EntityEquipmentSlot.LEGS);
			armor_gilgalad_boots = new LIItemArmor(LIMaterial.GILGALAD, EntityEquipmentSlot.FEET);

			armor_gimli_helmet = new LIItemArmor(LIMaterial.GIMLI, EntityEquipmentSlot.HEAD);
			armor_gimli_chestplate = new LIItemArmor(LIMaterial.GIMLI, EntityEquipmentSlot.CHEST);
			armor_gimli_legs = new LIItemArmor(LIMaterial.GIMLI, EntityEquipmentSlot.LEGS);
			armor_gimli_boots = new LIItemArmor(LIMaterial.GIMLI, EntityEquipmentSlot.FEET);

			armor_isildur_helmet = new LIItemArmor(LIMaterial.ISILDUR, EntityEquipmentSlot.HEAD);
			armor_isildur_chestplate = new LIItemArmor(LIMaterial.ISILDUR, EntityEquipmentSlot.CHEST);
			armor_isildur_legs = new LIItemArmor(LIMaterial.ISILDUR, EntityEquipmentSlot.LEGS);
			armor_isildur_boots = new LIItemArmor(LIMaterial.ISILDUR, EntityEquipmentSlot.FEET);

			armor_jiindur_helmet = new LIItemArmor(LIMaterial.JIINDUR, EntityEquipmentSlot.HEAD);
			armor_jiindur_chestplate = new LIItemArmor(LIMaterial.JIINDUR, EntityEquipmentSlot.CHEST);
			armor_jiindur_legs = new LIItemArmor(LIMaterial.JIINDUR, EntityEquipmentSlot.LEGS);
			armor_jiindur_boots = new LIItemArmor(LIMaterial.JIINDUR, EntityEquipmentSlot.FEET);

			armor_khamul_helmet = new LIItemArmor(LIMaterial.KHAMUL, EntityEquipmentSlot.HEAD);
			armor_khamul_chestplate = new LIItemArmor(LIMaterial.KHAMUL, EntityEquipmentSlot.CHEST);
			armor_khamul_legs = new LIItemArmor(LIMaterial.KHAMUL, EntityEquipmentSlot.LEGS);
			armor_khamul_boots = new LIItemArmor(LIMaterial.KHAMUL, EntityEquipmentSlot.FEET);

			armor_khommurat_helmet = new LIItemArmor(LIMaterial.KHOMMURAT, EntityEquipmentSlot.HEAD);
			armor_khommurat_chestplate = new LIItemArmor(LIMaterial.KHOMMURAT, EntityEquipmentSlot.CHEST);
			armor_khommurat_legs = new LIItemArmor(LIMaterial.KHOMMURAT, EntityEquipmentSlot.LEGS);
			armor_khommurat_boots = new LIItemArmor(LIMaterial.KHOMMURAT, EntityEquipmentSlot.FEET);

			armor_morgomir_helmet = new LIItemArmor(LIMaterial.MORGOMIR, EntityEquipmentSlot.HEAD);
			armor_morgomir_chestplate = new LIItemArmor(LIMaterial.MORGOMIR, EntityEquipmentSlot.CHEST);
			armor_morgomir_legs = new LIItemArmor(LIMaterial.MORGOMIR, EntityEquipmentSlot.LEGS);
			armor_morgomir_boots = new LIItemArmor(LIMaterial.MORGOMIR, EntityEquipmentSlot.FEET);

			armor_theoden_helmet = new LIItemArmor(LIMaterial.THEODEN, EntityEquipmentSlot.HEAD);
			armor_theoden_chestplate = new LIItemArmor(LIMaterial.THEODEN, EntityEquipmentSlot.CHEST);
			armor_theoden_legs = new LIItemArmor(LIMaterial.THEODEN, EntityEquipmentSlot.LEGS);
			armor_theoden_boots = new LIItemArmor(LIMaterial.THEODEN, EntityEquipmentSlot.FEET);

			armor_turgon_helmet = new LIItemArmor(LIMaterial.TURGON, EntityEquipmentSlot.HEAD);
			armor_turgon_chestplate = new LIItemArmor(LIMaterial.TURGON, EntityEquipmentSlot.CHEST);
			armor_turgon_legs = new LIItemArmor(LIMaterial.TURGON, EntityEquipmentSlot.LEGS);
			armor_turgon_boots = new LIItemArmor(LIMaterial.TURGON, EntityEquipmentSlot.FEET);

			weapon_acharn = new LIItemSword();
			weapon_aeglos = new LIItemSword();
			weapon_alatar = new LIItemSword();
			weapon_angrist = new LIItemSword();
			weapon_anguirel = new LIItemSword();
			weapon_aranruth = new LIItemSword();
			weapon_azog = new LIItemSword();
			weapon_balin = new LIItemSword();
			weapon_barazanthual = new LIItemSword();
			weapon_bolg = new LIItemSword();
			weapon_boromir = new LIItemSword();
			weapon_celeborn = new LIItemSword();
			weapon_dagmor = new LIItemSword();
			weapon_dain = new LIItemSword();
			weapon_denethor = new LIItemSword();
			weapon_dori = new LIItemSword();
			weapon_dramborleg = new LIItemSword();
			weapon_durin = new LIItemSword();
			weapon_dwalin = new LIItemSword();
			weapon_eothain = new LIItemSword();
			weapon_eowyn = new LIItemSword();
			weapon_faramir = new LIItemSword();
			weapon_gamling = new LIItemSword();
			weapon_gimli = new LIItemSword();
			weapon_girion = new LIItemSword();
			weapon_goblinking = new LIItemSword();
			weapon_gorbag = new LIItemSword();
			weapon_gothmog = new LIItemSword();
			weapon_grima = new LIItemSword();
			weapon_gurthang = new LIItemSword();
			weapon_guthwine = new LIItemSword();
			weapon_hadhafang = new LIItemSword();
			weapon_herugrim = new LIItemSword();
			weapon_khamul = new LIItemSword();
			weapon_kili = new LIItemSword();
			weapon_legolas = new LIItemSword();
			weapon_melkor = new LIItemSword();
			weapon_mouthofsauron = new LIItemSword();
			weapon_narcil = new LIItemSword();
			weapon_nazgul = new LIItemSword();
			weapon_orcrist = new LIItemSword();
			weapon_pallando = new LIItemSword();
			weapon_radagast = new LIItemSword();
			weapon_saruman = new LIItemSword();
			weapon_shagrat = new LIItemSword();
			weapon_thorin = new LIItemSword();
			weapon_thorondun = new LIItemSword();
			weapon_thrain = new LIItemSword();
			weapon_thranduil = new LIItemSword();
			weapon_thror = new LIItemSword();
			weapon_urfael = new LIItemSword();
			weapon_witchking = new LIItemSword();
			arkenstone = new LIItemEmpty();
			silmaril = new LIItemEmpty();

			register(armor_anarion_helmet, "armor_anarion_helmet");
			register(armor_anarion_chestplate, "armor_anarion_chestplate");
			register(armor_anarion_legs, "armor_anarion_legs");
			register(armor_anarion_boots, "armor_anarion_boots");
			register(armor_arpharazon_helmet, "armor_arpharazon_helmet");
			register(armor_arpharazon_chestplate, "armor_arpharazon_chestplate");
			register(armor_arpharazon_legs, "armor_arpharazon_legs");
			register(armor_arpharazon_boots, "armor_arpharazon_boots");
			register(armor_arvedui_helmet, "armor_arvedui_helmet");
			register(armor_arvedui_chestplate, "armor_arvedui_chestplate");
			register(armor_arvedui_legs, "armor_arvedui_legs");
			register(armor_arvedui_boots, "armor_arvedui_boots");
			register(armor_boromir_chestplate, "armor_boromir_chestplate");
			register(armor_boromir_legs, "armor_boromir_legs");
			register(armor_boromir_boots, "armor_boromir_boots");
			register(armor_elendil_helmet, "armor_elendil_helmet");
			register(armor_elendil_chestplate, "armor_elendil_chestplate");
			register(armor_elendil_legs, "armor_elendil_legs");
			register(armor_elendil_boots, "armor_elendil_boots");
			register(armor_elros_helmet, "armor_elros_helmet");
			register(armor_elros_chestplate, "armor_elros_chestplate");
			register(armor_elros_legs, "armor_elros_legs");
			register(armor_elros_boots, "armor_elros_boots");
			register(armor_feanor_helmet, "armor_feanor_helmet");
			register(armor_feanor_chestplate, "armor_feanor_chestplate");
			register(armor_feanor_legs, "armor_feanor_legs");
			register(armor_feanor_boots, "armor_feanor_boots");
			register(armor_gilgalad_helmet, "armor_gilgalad_helmet");
			register(armor_gilgalad_chestplate, "armor_gilgalad_chestplate");
			register(armor_gilgalad_legs, "armor_gilgalad_legs");
			register(armor_gilgalad_boots, "armor_gilgalad_boots");
			register(armor_gimli_helmet, "armor_gimli_helmet");
			register(armor_gimli_chestplate, "armor_gimli_chestplate");
			register(armor_gimli_legs, "armor_gimli_legs");
			register(armor_gimli_boots, "armor_gimli_boots");
			register(armor_isildur_helmet, "armor_isildur_helmet");
			register(armor_isildur_chestplate, "armor_isildur_chestplate");
			register(armor_isildur_legs, "armor_isildur_legs");
			register(armor_isildur_boots, "armor_isildur_boots");
			register(armor_jiindur_helmet, "armor_jiindur_helmet");
			register(armor_jiindur_chestplate, "armor_jiindur_chestplate");
			register(armor_jiindur_legs, "armor_jiindur_legs");
			register(armor_jiindur_boots, "armor_jiindur_boots");
			register(armor_khamul_helmet, "armor_khamul_helmet");
			register(armor_khamul_chestplate, "armor_khamul_chestplate");
			register(armor_khamul_legs, "armor_khamul_legs");
			register(armor_khamul_boots, "armor_khamul_boots");
			register(armor_khommurat_helmet, "armor_khommurat_helmet");
			register(armor_khommurat_chestplate, "armor_khommurat_chestplate");
			register(armor_khommurat_legs, "armor_khommurat_legs");
			register(armor_khommurat_boots, "armor_khommurat_boots");
			register(armor_morgomir_helmet, "armor_morgomir_helmet");
			register(armor_morgomir_chestplate, "armor_morgomir_chestplate");
			register(armor_morgomir_legs, "armor_morgomir_legs");
			register(armor_morgomir_boots, "armor_morgomir_boots");
			register(armor_theoden_helmet, "armor_theoden_helmet");
			register(armor_theoden_chestplate, "armor_theoden_chestplate");
			register(armor_theoden_legs, "armor_theoden_legs");
			register(armor_theoden_boots, "armor_theoden_boots");
			register(armor_turgon_helmet, "armor_turgon_helmet");
			register(armor_turgon_chestplate, "armor_turgon_chestplate");
			register(armor_turgon_legs, "armor_turgon_legs");
			register(armor_turgon_boots, "armor_turgon_boots");

			register(weapon_acharn, "weapon_acharn");
			register(weapon_aeglos, "weapon_aeglos");
			register(weapon_alatar, "weapon_alatar");
			register(weapon_angrist, "weapon_angrist");
			register(weapon_anguirel, "weapon_anguirel");
			register(weapon_aranruth, "weapon_aranruth");
			register(weapon_azog, "weapon_azog");
			register(weapon_balin, "weapon_balin");
			register(weapon_barazanthual, "weapon_barazanthual");
			register(weapon_bolg, "weapon_bolg");
			register(weapon_boromir, "weapon_boromir");
			register(weapon_celeborn, "weapon_celeborn");
			register(weapon_dagmor, "weapon_dagmor");
			register(weapon_dain, "weapon_dain");
			register(weapon_denethor, "weapon_denethor");
			register(weapon_dori, "weapon_dori");
			register(weapon_dramborleg, "weapon_dramborleg");
			register(weapon_durin, "weapon_durin");
			register(weapon_dwalin, "weapon_dwalin");
			register(weapon_eothain, "weapon_eothain");
			register(weapon_eowyn, "weapon_eowyn");
			register(weapon_faramir, "weapon_faramir");
			register(weapon_gamling, "weapon_gamling");
			register(weapon_gimli, "weapon_gimli");
			register(weapon_girion, "weapon_girion");
			register(weapon_goblinking, "weapon_goblinking");
			register(weapon_gorbag, "weapon_gorbag");
			register(weapon_gothmog, "weapon_gothmog");
			register(weapon_grima, "weapon_grima");
			register(weapon_gurthang, "weapon_gurthang");
			register(weapon_guthwine, "weapon_guthwine");
			register(weapon_hadhafang, "weapon_hadhafang");
			register(weapon_herugrim, "weapon_herugrim");
			register(weapon_khamul, "weapon_khamul");
			register(weapon_kili, "weapon_kili");
			register(weapon_legolas, "weapon_legolas");
			register(weapon_melkor, "weapon_melkor");
			register(weapon_mouthofsauron, "weapon_mouthofsauron");
			register(weapon_narcil, "weapon_narcil");
			register(weapon_nazgul, "weapon_nazgul");
			register(weapon_orcrist, "weapon_orcrist");
			register(weapon_pallando, "weapon_pallando");
			register(weapon_radagast, "weapon_radagast");
			register(weapon_saruman, "weapon_saruman");
			register(weapon_shagrat, "weapon_shagrat");
			register(weapon_thorin, "weapon_thorin");
			register(weapon_thorondun, "weapon_thorondun");
			register(weapon_thrain, "weapon_thrain");
			register(weapon_thranduil, "weapon_thranduil");
			register(weapon_thror, "weapon_thror");
			register(weapon_urfael, "weapon_urfael");
			register(weapon_witchking, "weapon_witchking");

			register(arkenstone, "arkenstone");
			register(silmaril, "silmaril");
		}

		@SubscribeEvent
		@SideOnly(Side.CLIENT)
		public static void onRegistryModel(ModelRegistryEvent event) {
			for (Item item : CONTENT) {
				ResourceLocation regName = item.getRegistryName();
				ModelResourceLocation mrl = new ModelResourceLocation(Objects.requireNonNull(regName), "inventory");
				ModelBakery.registerItemVariants(item, mrl);
				ModelLoader.setCustomModelResourceLocation(item, 0, mrl);
			}
		}

		public static void register(Item item, String name) {
			CONTENT.add(item);
			item.setRegistryName(name);
			item.setUnlocalizedName(name);
			ForgeRegistries.ITEMS.register(item);
		}
	}
}