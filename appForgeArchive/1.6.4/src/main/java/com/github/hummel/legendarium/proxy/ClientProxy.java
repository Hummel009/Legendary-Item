package com.github.hummel.legendarium.proxy;

import com.github.hummel.legendarium.listener.ReloadListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.ReloadableResourceManager;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.resources.ResourceManagerReloadListener;

public class ClientProxy implements CommonProxy {
	@Override
	public void onInit() {
		ResourceManagerReloadListener reloadListener = new ReloadListener();
		ResourceManager resourceManager = Minecraft.getMinecraft().getResourceManager();
		reloadListener.onResourceManagerReload(resourceManager);
		((ReloadableResourceManager) resourceManager).registerReloadListener(reloadListener);
	}
}