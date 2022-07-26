package legendarium;

import java.util.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import lotr.client.render.item.*;
import lotr.common.item.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;

public class LegendariumRendererManager implements IResourceManagerReloadListener {
	private static LegendariumRendererManager INSTANCE;
	private static List<LegendariumRender> largeItemRenderers;

	public static void preInit() {
		largeItemRenderers = new ArrayList<>();
		IResourceManager resMgr = Minecraft.getMinecraft().getResourceManager();
		INSTANCE = new LegendariumRendererManager();
		INSTANCE.onResourceManagerReload(resMgr);
		((IReloadableResourceManager) resMgr).registerReloadListener(INSTANCE);
		MinecraftForge.EVENT_BUS.register(INSTANCE);
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		largeItemRenderers.clear();
		for (Item item : LegendariumCommander.getObjectFieldsOfType(LegendariumRegistry.class, Item.class)) {
			MinecraftForgeClient.registerItemRenderer(item, null);
			LegendariumRender largeItemRenderer = LegendariumRender.getRendererIfLarge(item);
			if (item instanceof LOTRItemCrossbow) {
				MinecraftForgeClient.registerItemRenderer(item, new LOTRRenderCrossbow());
			} else if (item instanceof LOTRItemBow) {
				MinecraftForgeClient.registerItemRenderer(item, new LOTRRenderBow(largeItemRenderer));
			} else if (item instanceof LOTRItemSword && ((LOTRItemSword) item).isElvenBlade()) {
				MinecraftForgeClient.registerItemRenderer(item, new LOTRRenderElvenBlade(24.0, largeItemRenderer));
			} else if (largeItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item, largeItemRenderer);
			}
			if (largeItemRenderer == null) {
				continue;
			}
			largeItemRenderers.add(largeItemRenderer);
		}
	}

	@SubscribeEvent
	public void preTextureStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.map;
		if (map.getTextureType() == 1) {
			for (LegendariumRender largeRenderer : largeItemRenderers) {
				largeRenderer.registerIcons(map);
			}
		}
	}
}
