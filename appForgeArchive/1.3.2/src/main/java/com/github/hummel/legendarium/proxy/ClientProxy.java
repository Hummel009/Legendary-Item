package com.github.hummel.legendarium.proxy;

import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.renderer.EpicItemRenderer;
import net.minecraft.src.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy implements CommonProxy {
	@Override
	public void onInit() {
		for (Item item : Items.CONTENT) {
			EpicItemRenderer epicItemRenderer = EpicItemRenderer.getRendererIfEpic(item);
			if (epicItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item.shiftedIndex, epicItemRenderer);
			}
		}
	}
}