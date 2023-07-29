package legendarium.render;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import legendarium.LI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;

public class LIRenderManager implements IResourceManagerReloadListener {
	public static LIRenderManager INSTANCE;
	public static List<LIRenderable> largeItemRenderers;

	public static void preInit() {
		largeItemRenderers = new ArrayList<>();
		IResourceManager resMgr = Minecraft.getMinecraft().getResourceManager();
		INSTANCE = new LIRenderManager();
		INSTANCE.onResourceManagerReload(resMgr);
		((IReloadableResourceManager) resMgr).registerReloadListener(INSTANCE);
		MinecraftForge.EVENT_BUS.register(INSTANCE);
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		LI.registry.onResourceManagerReload(resourceManager);
	}

	@SubscribeEvent
	public void preTextureStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.map;
		if (map.getTextureType() == 1) {
			for (LIRenderable largeRenderer : largeItemRenderers) {
				largeRenderer.registerIcons(map);
			}
		}
	}
}
