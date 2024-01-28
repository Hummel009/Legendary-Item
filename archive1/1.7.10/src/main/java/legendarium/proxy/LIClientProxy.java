package legendarium.proxy;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import legendarium.render.LIRenderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraftforge.common.MinecraftForge;

public class LIClientProxy extends LICommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		IResourceManagerReloadListener renderManager = new LIRenderManager();
		IResourceManager resourceManager = Minecraft.getMinecraft().getResourceManager();
		renderManager.onResourceManagerReload(resourceManager);
		((IReloadableResourceManager) resourceManager).registerReloadListener(renderManager);
		MinecraftForge.EVENT_BUS.register(renderManager);
	}
}