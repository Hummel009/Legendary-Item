package legendarium;

import legendarium.content.LIItemEmpty;
import legendarium.content.LIItemSword;
import legendarium.proxy.LIClientProxy;
import legendarium.proxy.LICommonProxy;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.DistExecutor;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.Collection;

@Mod("legendarium")
public class LI {
	public static final String DISABLE_CURSEFORGE_DUPLICATE_NOTICE = "131829122023";
	public static final Collection<Item> CONTENT = new ArrayList<>();

	@SuppressWarnings("removal")
	private static final LICommonProxy PROXY = DistExecutor.safeRunForDist(() -> LIClientProxy::new, () -> LICommonProxy::new);
	private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("legendarium");
	private static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "legendarium");

	public static final DeferredItem<Item> WEAPON_ACHARN = ITEMS.register("weapon_acharn", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_AEGLOS = ITEMS.register("weapon_aeglos", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_ALATAR = ITEMS.register("weapon_alatar", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_ANGRIST = ITEMS.register("weapon_angrist", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_ANGUIREL = ITEMS.register("weapon_anguirel", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_ARANRUTH = ITEMS.register("weapon_aranruth", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_AZOG = ITEMS.register("weapon_azog", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_BALIN = ITEMS.register("weapon_balin", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_BARAZANTHUAL = ITEMS.register("weapon_barazanthual", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_BOLG = ITEMS.register("weapon_bolg", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_BOROMIR = ITEMS.register("weapon_boromir", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_CELEBORN = ITEMS.register("weapon_celeborn", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_DAGMOR = ITEMS.register("weapon_dagmor", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_DAIN = ITEMS.register("weapon_dain", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_DENETHOR = ITEMS.register("weapon_denethor", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_DORI = ITEMS.register("weapon_dori", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_DRAMBORLEG = ITEMS.register("weapon_dramborleg", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_DURIN = ITEMS.register("weapon_durin", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_DWALIN = ITEMS.register("weapon_dwalin", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_EOTHAIN = ITEMS.register("weapon_eothain", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_EOWYN = ITEMS.register("weapon_eowyn", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_FARAMIR = ITEMS.register("weapon_faramir", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_GAMLING = ITEMS.register("weapon_gamling", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_GIMLI = ITEMS.register("weapon_gimli", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_GIRION = ITEMS.register("weapon_girion", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_GOBLINKING = ITEMS.register("weapon_goblinking", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_GORBAG = ITEMS.register("weapon_gorbag", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_GOTHMOG = ITEMS.register("weapon_gothmog", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_GRIMA = ITEMS.register("weapon_grima", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_GURTHANG = ITEMS.register("weapon_gurthang", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_GUTHWINE = ITEMS.register("weapon_guthwine", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_HADHAFANG = ITEMS.register("weapon_hadhafang", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_HERUGRIM = ITEMS.register("weapon_herugrim", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_KHAMUL = ITEMS.register("weapon_khamul", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_KILI = ITEMS.register("weapon_kili", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_LEGOLAS = ITEMS.register("weapon_legolas", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_MELKOR = ITEMS.register("weapon_melkor", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_MOUTHOFSAURON = ITEMS.register("weapon_mouthofsauron", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_NARCIL = ITEMS.register("weapon_narcil", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_NAZGUL = ITEMS.register("weapon_nazgul", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_ORCRIST = ITEMS.register("weapon_orcrist", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_PALLANDO = ITEMS.register("weapon_pallando", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_RADAGAST = ITEMS.register("weapon_radagast", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_SARUMAN = ITEMS.register("weapon_saruman", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_SHAGRAT = ITEMS.register("weapon_shagrat", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_THORIN = ITEMS.register("weapon_thorin", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_THORONDUN = ITEMS.register("weapon_thorondun", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_THRAIN = ITEMS.register("weapon_thrain", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_THRANDUIL = ITEMS.register("weapon_thranduil", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_THROR = ITEMS.register("weapon_thror", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_URFAEL = ITEMS.register("weapon_urfael", LIItemSword::new);
	public static final DeferredItem<Item> WEAPON_WITCHKING = ITEMS.register("weapon_witchking", LIItemSword::new);

	public static final DeferredItem<Item> ARKENSTONE = ITEMS.register("arkenstone", LIItemEmpty::new);
	public static final DeferredItem<Item> SILMARIL = ITEMS.register("silmaril", LIItemEmpty::new);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB_ARTIFACTS = CREATIVE_TABS.register("legendariumtab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.artifacts")).icon(() -> new ItemStack(WEAPON_FARAMIR.get())).displayItems((enabledFlags, populator) -> {
		for (var item : CONTENT) {
			populator.accept(item);
		}
	}).build());

	public LI(IEventBus fmlBus) {
		fmlBus.register(PROXY);
		ITEMS.register(fmlBus);
		CREATIVE_TABS.register(fmlBus);
	}
}