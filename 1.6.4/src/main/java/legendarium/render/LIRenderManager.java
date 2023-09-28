package legendarium.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import legendarium.LI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.ReloadableResourceManager;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.resources.ResourceManagerReloadListener;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

import java.util.ArrayList;
import java.util.List;

public class LIRenderManager implements ResourceManagerReloadListener {
	public static LIRenderManager INSTANCE;
	public static List<LIRenderLargeItem> largeItemRenderers;

	public static void preInit() {
		largeItemRenderers = new ArrayList<LIRenderLargeItem>();
		ResourceManager resMgr = Minecraft.getMinecraft().getResourceManager();
		INSTANCE = new LIRenderManager();
		INSTANCE.onResourceManagerReload(resMgr);
		((ReloadableResourceManager) resMgr).registerReloadListener(INSTANCE);
		MinecraftForge.EVENT_BUS.register(INSTANCE);
	}

	@Override
	public void onResourceManagerReload(ResourceManager resourceManager) {
		largeItemRenderers.clear();
		for (Item item : LI.CONTENT) {
			MinecraftForgeClient.registerItemRenderer(item.itemID, null);
			LIRenderLargeItem largeItemRenderer = LIRenderLargeItem.getRendererIfLarge(item);
			if (largeItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item.itemID, largeItemRenderer);
				largeItemRenderers.add(largeItemRenderer);
			}
		}
	}

	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void preTextureStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.map;
		if (map.getTextureType() == 1) {
			for (LIRenderLargeItem largeRenderer : largeItemRenderers) {
				largeRenderer.registerIcons(map);
			}
		}
	}
}
