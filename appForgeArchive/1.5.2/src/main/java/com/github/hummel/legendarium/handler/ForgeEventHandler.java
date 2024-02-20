package com.github.hummel.legendarium.handler;

import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.renderer.EpicItemRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.TextureLoadEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.ForgeSubscribe;

import java.util.ArrayList;
import java.util.Collection;

public class ForgeEventHandler {
	private static final Collection<EpicItemRenderer> EPIC_ITEM_RENDERERS = new ArrayList<EpicItemRenderer>();

	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void onTextureLoad(TextureLoadEvent event) {
		EPIC_ITEM_RENDERERS.clear();
		for (Item item : Items.CONTENT) {
			MinecraftForgeClient.registerItemRenderer(item.itemID, null);
			EpicItemRenderer largeItemRenderer = EpicItemRenderer.getRendererIfLarge(item);
			if (largeItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item.itemID, largeItemRenderer);
				EPIC_ITEM_RENDERERS.add(largeItemRenderer);
			}
		}
	}

	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void preTextureStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.map;
		if (map.textureType == 1) {
			for (EpicItemRenderer epicItemRenderer : EPIC_ITEM_RENDERERS) {
				epicItemRenderer.registerIcons(map);
			}
		}
	}
}