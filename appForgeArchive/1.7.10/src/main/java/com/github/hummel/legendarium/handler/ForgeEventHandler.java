package com.github.hummel.legendarium.handler;

import com.github.hummel.legendarium.renderer.EpicItemRenderer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.client.event.TextureStitchEvent;

import java.util.ArrayList;
import java.util.Collection;

public class ForgeEventHandler {
	public static final Collection<EpicItemRenderer> EPIC_ITEM_RENDERERS = new ArrayList<>();

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void preTextureStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.map;
		if (map.getTextureType() == 1) {
			for (EpicItemRenderer epicItemRenderer : EPIC_ITEM_RENDERERS) {
				epicItemRenderer.registerIcons(map);
			}
		}
	}
}