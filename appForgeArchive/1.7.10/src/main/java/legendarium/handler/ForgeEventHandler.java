package legendarium.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import legendarium.listener.ReloadListener;
import legendarium.render.RenderEpicItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.client.event.TextureStitchEvent;

public class ForgeEventHandler {
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void preTextureStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.map;
		if (map.getTextureType() == 1) {
			for (RenderEpicItem largeRenderer : ReloadListener.LARGE_ITEM_RENDERS) {
				largeRenderer.registerIcons(map);
			}
		}
	}
}