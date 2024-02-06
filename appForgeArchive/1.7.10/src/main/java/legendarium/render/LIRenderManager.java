package legendarium.render;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import legendarium.LI;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.TextureStitchEvent;

import java.util.ArrayList;
import java.util.Collection;

public class LIRenderManager implements IResourceManagerReloadListener {
	private static final Collection<LIRenderLargeItem> LARGE_ITEM_RENDERS = new ArrayList<>();

	@Override
	@SideOnly(Side.CLIENT)
	public void onResourceManagerReload(IResourceManager resourceManager) {
		LARGE_ITEM_RENDERS.clear();
		for (Item item : LI.CONTENT) {
			MinecraftForgeClient.registerItemRenderer(item, null);
			LIRenderLargeItem largeItemRenderer = LIRenderLargeItem.getRendererIfLarge(item);
			if (largeItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item, largeItemRenderer);
				LARGE_ITEM_RENDERS.add(largeItemRenderer);
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void preTextureStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.map;
		if (map.getTextureType() == 1) {
			for (LIRenderLargeItem largeRenderer : LARGE_ITEM_RENDERS) {
				largeRenderer.registerIcons(map);
			}
		}
	}
}
