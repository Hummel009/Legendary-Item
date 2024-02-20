package com.github.hummel.legendarium.listener;

import com.github.hummel.legendarium.handler.ForgeEventHandler;
import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.renderer.EpicItemRenderer;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.resources.ResourceManagerReloadListener;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ReloadListener implements ResourceManagerReloadListener {
	@Override
	public void onResourceManagerReload(ResourceManager resourceManager) {
		ForgeEventHandler.EPIC_ITEM_RENDERERS.clear();
		for (Item item : Items.CONTENT) {
			MinecraftForgeClient.registerItemRenderer(item.itemID, null);
			EpicItemRenderer largeItemRenderer = EpicItemRenderer.getRendererIfLarge(item);
			if (largeItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item.itemID, largeItemRenderer);
				ForgeEventHandler.EPIC_ITEM_RENDERERS.add(largeItemRenderer);
			}
		}
	}
}