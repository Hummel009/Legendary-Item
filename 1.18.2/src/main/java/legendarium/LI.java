package legendarium;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

@Mod("legendarium")
public class LI {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "legendarium");
    public static Map<ResourceLocation, Integer> ITEM_ORDER_FOR_CREATIVE_TABS = new HashMap<>();

    public static RegistryObject<Item> armor_anarion_helmet = ITEMS.register("armor_anarion_helmet", () -> new LIItemArmor(LIMaterial.ANARION, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_anarion_chestplate = ITEMS.register("armor_anarion_chestplate", () -> new LIItemArmor(LIMaterial.ANARION, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_anarion_legs = ITEMS.register("armor_anarion_legs", () -> new LIItemArmor(LIMaterial.ANARION, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_anarion_boots = ITEMS.register("armor_anarion_boots", () -> new LIItemArmor(LIMaterial.ANARION, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_arpharazon_helmet = ITEMS.register("armor_arpharazon_helmet", () -> new LIItemArmor(LIMaterial.ARPHARAZON, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_arpharazon_chestplate = ITEMS.register("armor_arpharazon_chestplate", () -> new LIItemArmor(LIMaterial.ARPHARAZON, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_arpharazon_legs = ITEMS.register("armor_arpharazon_legs", () -> new LIItemArmor(LIMaterial.ARPHARAZON, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_arpharazon_boots = ITEMS.register("armor_arpharazon_boots", () -> new LIItemArmor(LIMaterial.ARPHARAZON, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_arvedui_helmet = ITEMS.register("armor_arvedui_helmet", () -> new LIItemArmor(LIMaterial.ARVEDUI, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_arvedui_chestplate = ITEMS.register("armor_arvedui_chestplate", () -> new LIItemArmor(LIMaterial.ARVEDUI, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_arvedui_legs = ITEMS.register("armor_arvedui_legs", () -> new LIItemArmor(LIMaterial.ARVEDUI, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_arvedui_boots = ITEMS.register("armor_arvedui_boots", () -> new LIItemArmor(LIMaterial.ARVEDUI, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_boromir_chestplate = ITEMS.register("armor_boromir_chestplate", () -> new LIItemArmor(LIMaterial.BOROMIR, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_boromir_legs = ITEMS.register("armor_boromir_legs", () -> new LIItemArmor(LIMaterial.BOROMIR, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_boromir_boots = ITEMS.register("armor_boromir_boots", () -> new LIItemArmor(LIMaterial.BOROMIR, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_elendil_helmet = ITEMS.register("armor_elendil_helmet", () -> new LIItemArmor(LIMaterial.ELENDIL, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_elendil_chestplate = ITEMS.register("armor_elendil_chestplate", () -> new LIItemArmor(LIMaterial.ELENDIL, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_elendil_legs = ITEMS.register("armor_elendil_legs", () -> new LIItemArmor(LIMaterial.ELENDIL, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_elendil_boots = ITEMS.register("armor_elendil_boots", () -> new LIItemArmor(LIMaterial.ELENDIL, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_elros_helmet = ITEMS.register("armor_elros_helmet", () -> new LIItemArmor(LIMaterial.ELROS, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_elros_chestplate = ITEMS.register("armor_elros_chestplate", () -> new LIItemArmor(LIMaterial.ELROS, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_elros_legs = ITEMS.register("armor_elros_legs", () -> new LIItemArmor(LIMaterial.ELROS, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_elros_boots = ITEMS.register("armor_elros_boots", () -> new LIItemArmor(LIMaterial.ELROS, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_feanor_helmet = ITEMS.register("armor_feanor_helmet", () -> new LIItemArmor(LIMaterial.FEANOR, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_feanor_chestplate = ITEMS.register("armor_feanor_chestplate", () -> new LIItemArmor(LIMaterial.FEANOR, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_feanor_legs = ITEMS.register("armor_feanor_legs", () -> new LIItemArmor(LIMaterial.FEANOR, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_feanor_boots = ITEMS.register("armor_feanor_boots", () -> new LIItemArmor(LIMaterial.FEANOR, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_gilgalad_helmet = ITEMS.register("armor_gilgalad_helmet", () -> new LIItemArmor(LIMaterial.GILGALAD, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_gilgalad_chestplate = ITEMS.register("armor_gilgalad_chestplate", () -> new LIItemArmor(LIMaterial.GILGALAD, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_gilgalad_legs = ITEMS.register("armor_gilgalad_legs", () -> new LIItemArmor(LIMaterial.GILGALAD, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_gilgalad_boots = ITEMS.register("armor_gilgalad_boots", () -> new LIItemArmor(LIMaterial.GILGALAD, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_gimli_helmet = ITEMS.register("armor_gimli_helmet", () -> new LIItemArmor(LIMaterial.GIMLI, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_gimli_chestplate = ITEMS.register("armor_gimli_chestplate", () -> new LIItemArmor(LIMaterial.GIMLI, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_gimli_legs = ITEMS.register("armor_gimli_legs", () -> new LIItemArmor(LIMaterial.GIMLI, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_gimli_boots = ITEMS.register("armor_gimli_boots", () -> new LIItemArmor(LIMaterial.GIMLI, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_isildur_helmet = ITEMS.register("armor_isildur_helmet", () -> new LIItemArmor(LIMaterial.ISILDUR, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_isildur_chestplate = ITEMS.register("armor_isildur_chestplate", () -> new LIItemArmor(LIMaterial.ISILDUR, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_isildur_legs = ITEMS.register("armor_isildur_legs", () -> new LIItemArmor(LIMaterial.ISILDUR, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_isildur_boots = ITEMS.register("armor_isildur_boots", () -> new LIItemArmor(LIMaterial.ISILDUR, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_jiindur_helmet = ITEMS.register("armor_jiindur_helmet", () -> new LIItemArmor(LIMaterial.JIINDUR, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_jiindur_chestplate = ITEMS.register("armor_jiindur_chestplate", () -> new LIItemArmor(LIMaterial.JIINDUR, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_jiindur_legs = ITEMS.register("armor_jiindur_legs", () -> new LIItemArmor(LIMaterial.JIINDUR, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_jiindur_boots = ITEMS.register("armor_jiindur_boots", () -> new LIItemArmor(LIMaterial.JIINDUR, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_khamul_helmet = ITEMS.register("armor_khamul_helmet", () -> new LIItemArmor(LIMaterial.KHAMUL, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_khamul_chestplate = ITEMS.register("armor_khamul_chestplate", () -> new LIItemArmor(LIMaterial.KHAMUL, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_khamul_legs = ITEMS.register("armor_khamul_legs", () -> new LIItemArmor(LIMaterial.KHAMUL, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_khamul_boots = ITEMS.register("armor_khamul_boots", () -> new LIItemArmor(LIMaterial.KHAMUL, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_khommurat_helmet = ITEMS.register("armor_khommurat_helmet", () -> new LIItemArmor(LIMaterial.KHOMMURAT, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_khommurat_chestplate = ITEMS.register("armor_khommurat_chestplate", () -> new LIItemArmor(LIMaterial.KHOMMURAT, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_khommurat_legs = ITEMS.register("armor_khommurat_legs", () -> new LIItemArmor(LIMaterial.KHOMMURAT, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_khommurat_boots = ITEMS.register("armor_khommurat_boots", () -> new LIItemArmor(LIMaterial.KHOMMURAT, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_morgomir_helmet = ITEMS.register("armor_morgomir_helmet", () -> new LIItemArmor(LIMaterial.MORGOMIR, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_morgomir_chestplate = ITEMS.register("armor_morgomir_chestplate", () -> new LIItemArmor(LIMaterial.MORGOMIR, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_morgomir_legs = ITEMS.register("armor_morgomir_legs", () -> new LIItemArmor(LIMaterial.MORGOMIR, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_morgomir_boots = ITEMS.register("armor_morgomir_boots", () -> new LIItemArmor(LIMaterial.MORGOMIR, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_theoden_helmet = ITEMS.register("armor_theoden_helmet", () -> new LIItemArmor(LIMaterial.THEODEN, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_theoden_chestplate = ITEMS.register("armor_theoden_chestplate", () -> new LIItemArmor(LIMaterial.THEODEN, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_theoden_legs = ITEMS.register("armor_theoden_legs", () -> new LIItemArmor(LIMaterial.THEODEN, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_theoden_boots = ITEMS.register("armor_theoden_boots", () -> new LIItemArmor(LIMaterial.THEODEN, EquipmentSlot.FEET));

    public static RegistryObject<Item> armor_turgon_helmet = ITEMS.register("armor_turgon_helmet", () -> new LIItemArmor(LIMaterial.TURGON, EquipmentSlot.HEAD));
    public static RegistryObject<Item> armor_turgon_chestplate = ITEMS.register("armor_turgon_chestplate", () -> new LIItemArmor(LIMaterial.TURGON, EquipmentSlot.CHEST));
    public static RegistryObject<Item> armor_turgon_legs = ITEMS.register("armor_turgon_legs", () -> new LIItemArmor(LIMaterial.TURGON, EquipmentSlot.LEGS));
    public static RegistryObject<Item> armor_turgon_boots = ITEMS.register("armor_turgon_boots", () -> new LIItemArmor(LIMaterial.TURGON, EquipmentSlot.FEET));

    public static RegistryObject<Item> weapon_acharn = ITEMS.register("weapon_acharn", LIItemSword::new);
    public static RegistryObject<Item> weapon_aeglos = ITEMS.register("weapon_aeglos", LIItemSword::new);
    public static RegistryObject<Item> weapon_alatar = ITEMS.register("weapon_alatar", LIItemSword::new);
    public static RegistryObject<Item> weapon_angrist = ITEMS.register("weapon_angrist", LIItemSword::new);
    public static RegistryObject<Item> weapon_anguirel = ITEMS.register("weapon_anguirel", LIItemSword::new);
    public static RegistryObject<Item> weapon_aranruth = ITEMS.register("weapon_aranruth", LIItemSword::new);
    public static RegistryObject<Item> weapon_azog = ITEMS.register("weapon_azog", LIItemSword::new);
    public static RegistryObject<Item> weapon_balin = ITEMS.register("weapon_balin", LIItemSword::new);
    public static RegistryObject<Item> weapon_barazanthual = ITEMS.register("weapon_barazanthual", LIItemSword::new);
    public static RegistryObject<Item> weapon_bolg = ITEMS.register("weapon_bolg", LIItemSword::new);
    public static RegistryObject<Item> weapon_boromir = ITEMS.register("weapon_boromir", LIItemSword::new);
    public static RegistryObject<Item> weapon_celeborn = ITEMS.register("weapon_celeborn", LIItemSword::new);
    public static RegistryObject<Item> weapon_dagmor = ITEMS.register("weapon_dagmor", LIItemSword::new);
    public static RegistryObject<Item> weapon_dain = ITEMS.register("weapon_dain", LIItemSword::new);
    public static RegistryObject<Item> weapon_denethor = ITEMS.register("weapon_denethor", LIItemSword::new);
    public static RegistryObject<Item> weapon_dori = ITEMS.register("weapon_dori", LIItemSword::new);
    public static RegistryObject<Item> weapon_dramborleg = ITEMS.register("weapon_dramborleg", LIItemSword::new);
    public static RegistryObject<Item> weapon_durin = ITEMS.register("weapon_durin", LIItemSword::new);
    public static RegistryObject<Item> weapon_dwalin = ITEMS.register("weapon_dwalin", LIItemSword::new);
    public static RegistryObject<Item> weapon_eothain = ITEMS.register("weapon_eothain", LIItemSword::new);
    public static RegistryObject<Item> weapon_eowyn = ITEMS.register("weapon_eowyn", LIItemSword::new);
    public static RegistryObject<Item> weapon_faramir = ITEMS.register("weapon_faramir", LIItemSword::new);
    public static RegistryObject<Item> weapon_gamling = ITEMS.register("weapon_gamling", LIItemSword::new);
    public static RegistryObject<Item> weapon_gimli = ITEMS.register("weapon_gimli", LIItemSword::new);
    public static RegistryObject<Item> weapon_girion = ITEMS.register("weapon_girion", LIItemSword::new);
    public static RegistryObject<Item> weapon_goblinking = ITEMS.register("weapon_goblinking", LIItemSword::new);
    public static RegistryObject<Item> weapon_gorbag = ITEMS.register("weapon_gorbag", LIItemSword::new);
    public static RegistryObject<Item> weapon_gothmog = ITEMS.register("weapon_gothmog", LIItemSword::new);
    public static RegistryObject<Item> weapon_grima = ITEMS.register("weapon_grima", LIItemSword::new);
    public static RegistryObject<Item> weapon_gurthang = ITEMS.register("weapon_gurthang", LIItemSword::new);
    public static RegistryObject<Item> weapon_guthwine = ITEMS.register("weapon_guthwine", LIItemSword::new);
    public static RegistryObject<Item> weapon_hadhafang = ITEMS.register("weapon_hadhafang", LIItemSword::new);
    public static RegistryObject<Item> weapon_herugrim = ITEMS.register("weapon_herugrim", LIItemSword::new);
    public static RegistryObject<Item> weapon_khamul = ITEMS.register("weapon_khamul", LIItemSword::new);
    public static RegistryObject<Item> weapon_kili = ITEMS.register("weapon_kili", LIItemSword::new);
    public static RegistryObject<Item> weapon_legolas = ITEMS.register("weapon_legolas", LIItemSword::new);
    public static RegistryObject<Item> weapon_melkor = ITEMS.register("weapon_melkor", LIItemSword::new);
    public static RegistryObject<Item> weapon_mouthofsauron = ITEMS.register("weapon_mouthofsauron", LIItemSword::new);
    public static RegistryObject<Item> weapon_narcil = ITEMS.register("weapon_narcil", LIItemSword::new);
    public static RegistryObject<Item> weapon_nazgul = ITEMS.register("weapon_nazgul", LIItemSword::new);
    public static RegistryObject<Item> weapon_orcrist = ITEMS.register("weapon_orcrist", LIItemSword::new);
    public static RegistryObject<Item> weapon_pallando = ITEMS.register("weapon_pallando", LIItemSword::new);
    public static RegistryObject<Item> weapon_radagast = ITEMS.register("weapon_radagast", LIItemSword::new);
    public static RegistryObject<Item> weapon_saruman = ITEMS.register("weapon_saruman", LIItemSword::new);
    public static RegistryObject<Item> weapon_shagrat = ITEMS.register("weapon_shagrat", LIItemSword::new);
    public static RegistryObject<Item> weapon_thorin = ITEMS.register("weapon_thorin", LIItemSword::new);
    public static RegistryObject<Item> weapon_thorondun = ITEMS.register("weapon_thorondun", LIItemSword::new);
    public static RegistryObject<Item> weapon_thrain = ITEMS.register("weapon_thrain", LIItemSword::new);
    public static RegistryObject<Item> weapon_thranduil = ITEMS.register("weapon_thranduil", LIItemSword::new);
    public static RegistryObject<Item> weapon_thror = ITEMS.register("weapon_thror", LIItemSword::new);
    public static RegistryObject<Item> weapon_urfael = ITEMS.register("weapon_urfael", LIItemSword::new);
    public static RegistryObject<Item> weapon_witchking = ITEMS.register("weapon_witchking", LIItemSword::new);
    public static RegistryObject<Item> arkenstone = ITEMS.register("arkenstone", LIItemEmpty::new);
    public static RegistryObject<Item> silmaril = ITEMS.register("silmaril", LIItemEmpty::new);

    public LI() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }
}