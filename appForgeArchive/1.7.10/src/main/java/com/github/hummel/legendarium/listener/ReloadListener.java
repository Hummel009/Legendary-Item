package com.github.hummel.legendarium.listener;

import com.github.hummel.legendarium.handler.ForgeEventHandler;
import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.renderer.EpicItemRenderer;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ReloadListener implements IResourceManagerReloadListener {
	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		ForgeEventHandler.EPIC_ITEM_RENDERERS.clear();
		for (Item item : Items.CONTENT) {
			MinecraftForgeClient.registerItemRenderer(item, null);
			EpicItemRenderer largeItemRenderer = EpicItemRenderer.getRendererIfLarge(item);
			if (largeItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item, largeItemRenderer);
				ForgeEventHandler.EPIC_ITEM_RENDERERS.add(largeItemRenderer);
			}
		}
	}
}