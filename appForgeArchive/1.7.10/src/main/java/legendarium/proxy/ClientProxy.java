package legendarium.proxy;

import legendarium.listener.ReloadListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;

public class ClientProxy implements CommonProxy {
	@Override
	public void onInit() {
		IResourceManagerReloadListener reloadListener = new ReloadListener();
		IResourceManager resourceManager = Minecraft.getMinecraft().getResourceManager();
		reloadListener.onResourceManagerReload(resourceManager);
		((IReloadableResourceManager) resourceManager).registerReloadListener(reloadListener);
	}
}