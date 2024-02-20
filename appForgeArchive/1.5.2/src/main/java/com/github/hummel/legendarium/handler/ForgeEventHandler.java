package com.github.hummel.legendarium.handler;

import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.renderer.EpicItemRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.TextureLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class ForgeEventHandler {
	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void onTextureLoad(TextureLoadEvent event) {
		for (Item item : Items.CONTENT) {
			EpicItemRenderer epicItemRenderer = EpicItemRenderer.getRendererIfLarge(item);
			if (epicItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item.itemID, epicItemRenderer);
			}
		}
	}
}