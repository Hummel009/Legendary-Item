package legendarium.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import legendarium.LI;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.resources.ResourceManagerReloadListener;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.ForgeSubscribe;

import java.util.ArrayList;
import java.util.Collection;

public class LIRenderManager implements ResourceManagerReloadListener {
	private static final Collection<LIRenderLargeItem> LARGE_ITEM_RENDERS = new ArrayList<LIRenderLargeItem>();

	@Override
	public void onResourceManagerReload(ResourceManager resourceManager) {
		LARGE_ITEM_RENDERS.clear();
		for (Item item : LI.CONTENT) {
			MinecraftForgeClient.registerItemRenderer(item.itemID, null);
			LIRenderLargeItem largeItemRenderer = LIRenderLargeItem.getRendererIfLarge(item);
			if (largeItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item.itemID, largeItemRenderer);
				LARGE_ITEM_RENDERS.add(largeItemRenderer);
			}
		}
	}

	@ForgeSubscribe
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