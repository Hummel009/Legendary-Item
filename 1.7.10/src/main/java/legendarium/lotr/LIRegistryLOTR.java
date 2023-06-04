package legendarium.lotr;

import com.google.common.base.CaseFormat;
import cpw.mods.fml.common.registry.GameRegistry;
import legendarium.content.LIRegistry;
import legendarium.render.LIRenderable;
import legendarium.render.LIRenderManager;
import lotr.client.render.item.LOTRRenderBow;
import lotr.client.render.item.LOTRRenderCrossbow;
import lotr.client.render.item.LOTRRenderElvenBlade;
import lotr.common.LOTRCreativeTabs;
import lotr.common.item.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;

import java.util.Map;

public class LIRegistryLOTR extends LIRegistry {
	public static Item rangedAzkar;
	public static Item rangedBard;
	public static Item rangedBelthronding;
	public static Item rangedBregor;
	public static Item rangedHaldir;
	public static Item rangedLegolas;
	public static Item rangedLurtz;

	@Override
	public void registerCommon() {
		super.registerCommon();
		rangedAzkar = new LOTRItemBow(LOTRMaterial.HIGH_ELVEN, 1.25).setDrawTime(16).setCreativeTab(LOTRCreativeTabs.tabStory);
		rangedBard = new LOTRItemBow(LOTRMaterial.DALE, 1.25).setDrawTime(16).setCreativeTab(LOTRCreativeTabs.tabStory);
		rangedBelthronding = new LOTRItemBow(LOTRMaterial.HIGH_ELVEN, 1.25).setDrawTime(16).setCreativeTab(LOTRCreativeTabs.tabStory);
		rangedBregor = new LOTRItemBow(LOTRMaterial.RANGER, 1.25).setDrawTime(16).setCreativeTab(LOTRCreativeTabs.tabStory);
		rangedHaldir = new LOTRItemBow(LOTRMaterial.GALADHRIM, 1.25).setDrawTime(16).setCreativeTab(LOTRCreativeTabs.tabStory);
		rangedLegolas = new LOTRItemBow(LOTRMaterial.HIGH_ELVEN, 1.25).setDrawTime(16).setCreativeTab(LOTRCreativeTabs.tabStory);
		rangedLurtz = new LOTRItemCrossbow(LOTRMaterial.URUK).setCreativeTab(LOTRCreativeTabs.tabStory);

		register(rangedAzkar, "rangedAzkar");
		register(rangedBard, "rangedBard");
		register(rangedBelthronding, "rangedBelthronding");
		register(rangedBregor, "rangedBregor");
		register(rangedHaldir, "rangedHaldir");
		register(rangedLegolas, "rangedLegolas");
		register(rangedLurtz, "rangedLurtz");
	}

	@Override
	public void registerSpecial() {
		weaponAzog = new LOTRItemSauronMace();
		weaponAeglos = new LOTRItemSpear(LOTRMaterial.HIGH_ELVEN).setCreativeTab(LOTRCreativeTabs.tabStory);
		weaponAlatar = new LOTRItemGandalfStaffWhite();
		weaponAranruth = new LOTRItemGlamdring();
		weaponCeleborn = new LOTRItemGlamdring();
		weaponGoblinking = new LOTRItemSauronMace();
		weaponHadhafang = new LOTRItemGlamdring();
		weaponMelkor = new LOTRItemSauronMace();
		weaponOrcrist = new LOTRItemGlamdring();
		weaponPallando = new LOTRItemGandalfStaffWhite();
		weaponRadagast = new LOTRItemGandalfStaffWhite();
		weaponSaruman = new LOTRItemSauronMace();
		weaponThorondun = new LOTRItemGlamdring();
		weaponThranduil = new LOTRItemGlamdring();
		weaponWitchking = new LOTRItemSauronMace();

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
		item.setCreativeTab(LOTRCreativeTabs.tabStory);
		GameRegistry.registerItem(item, name);
		CONTENT.add(item);
	}

	@Override
	public LIRenderable getRendererIfLarge(Item item) {
		for (Map.Entry<String, Float> folder : LIRenderLargeItemLOTR.sizeFolders.entrySet()) {
			float iconScale = folder.getValue();
			try {
				ResourceLocation resLoc = LIRenderLargeItemLOTR.getLargeTexturePath(item, folder.getKey());
				IResource res = Minecraft.getMinecraft().getResourceManager().getResource(resLoc);
				if (res != null) {
					return new LIRenderLargeItemLOTR(item, folder.getKey(), iconScale);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		LIRenderManager.largeItemRenderers.clear();
		for (Item item : CONTENT) {
			MinecraftForgeClient.registerItemRenderer(item, null);
			LIRenderLargeItemLOTR largeItemRenderer = (LIRenderLargeItemLOTR) getRendererIfLarge(item);
			if (item instanceof LOTRItemCrossbow) {
				MinecraftForgeClient.registerItemRenderer(item, new LOTRRenderCrossbow());
			} else if (item instanceof LOTRItemBow) {
				MinecraftForgeClient.registerItemRenderer(item, new LOTRRenderBow(largeItemRenderer));
			} else if (item instanceof LOTRItemSword && ((LOTRItemSword) item).isElvenBlade()) {
				MinecraftForgeClient.registerItemRenderer(item, new LOTRRenderElvenBlade(24.0, largeItemRenderer));
			} else if (largeItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item, largeItemRenderer);
			}
			if (largeItemRenderer != null) {
				LIRenderManager.largeItemRenderers.add(largeItemRenderer);
			}
		}
	}
}
