package legendarium;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import lotr.client.render.item.LOTRRenderBow;
import lotr.client.render.item.LOTRRenderCrossbow;
import lotr.client.render.item.LOTRRenderElvenBlade;
import lotr.common.item.LOTRItemBow;
import lotr.common.item.LOTRItemCrossbow;
import lotr.common.item.LOTRItemSword;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;

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
            MinecraftForgeClient.registerItemRenderer((Item)item, null);
            LIRender largeItemRenderer = LIRender.getRendererIfLarge(item);
            if (item instanceof LOTRItemCrossbow) {
                MinecraftForgeClient.registerItemRenderer((Item)item, new LOTRRenderCrossbow());
            } else if (item instanceof LOTRItemBow) {
                MinecraftForgeClient.registerItemRenderer((Item)item, new LOTRRenderBow(largeItemRenderer));
            } else if (item instanceof LOTRItemSword && ((LOTRItemSword)item).isElvenBlade()) {
                MinecraftForgeClient.registerItemRenderer((Item)item, new LOTRRenderElvenBlade(24.0, largeItemRenderer));
            } else if (largeItemRenderer != null) {
                MinecraftForgeClient.registerItemRenderer((Item)item, largeItemRenderer);
            }
            if (largeItemRenderer == null) continue;
            largeItemRenderers.add(largeItemRenderer);
        }
    }

    @SubscribeEvent
    public void preTextureStitch(TextureStitchEvent.Pre event) {
        TextureMap map = event.map;
        if (map.getTextureType() == 1) {
            for (LIRender largeRenderer : largeItemRenderers) {
                largeRenderer.registerIcons((IIconRegister)map);
            }
        }
    }
}
