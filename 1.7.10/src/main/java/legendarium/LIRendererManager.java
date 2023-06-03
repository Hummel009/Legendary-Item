package legendarium;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import lotr.client.render.item.LOTRRenderBow;
import lotr.client.render.item.LOTRRenderCrossbow;
import lotr.client.render.item.LOTRRenderElvenBlade;
import lotr.common.item.LOTRItemBow;
import lotr.common.item.LOTRItemCrossbow;
import lotr.common.item.LOTRItemSword;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;

public class LIRendererManager implements IResourceManagerReloadListener {
	public static LIRendererManager INSTANCE;
	public static List<LIRender> largeItemRenderers;

	public static void preInit() {
		largeItemRenderers = new ArrayList<>();
		IResourceManager resMgr = Minecraft.getMinecraft().getResourceManager();
		INSTANCE = new LIRendererManager();
		INSTANCE.onResourceManagerReload(resMgr);
		((IReloadableResourceManager) resMgr).registerReloadListener(INSTANCE);
		MinecraftForge.EVENT_BUS.register(INSTANCE);
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		largeItemRenderers.clear();
		for (Item item : LIRegistry.CONTENT) {
			MinecraftForgeClient.registerItemRenderer(item, null);
			LIRender largeItemRenderer = LIRender.getRendererIfLarge(item);
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
				largeItemRenderers.add(largeItemRenderer);
			}
		}
	}

	@SubscribeEvent
	public void preTextureStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.map;
		if (map.getTextureType() == 1) {
			for (LIRender largeRenderer : largeItemRenderers) {
				largeRenderer.registerIcons(map);
			}
		}
	}
}
