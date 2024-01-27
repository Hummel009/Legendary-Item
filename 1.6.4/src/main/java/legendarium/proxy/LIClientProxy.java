package legendarium.proxy;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import legendarium.render.LIRenderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.ReloadableResourceManager;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.resources.ResourceManagerReloadListener;
import net.minecraftforge.common.MinecraftForge;

public class LIClientProxy extends LICommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		ResourceManagerReloadListener renderManager = new LIRenderManager();
		ResourceManager resourceManager = Minecraft.getMinecraft().getResourceManager();
		renderManager.onResourceManagerReload(resourceManager);
		((ReloadableResourceManager) resourceManager).registerReloadListener(renderManager);
		MinecraftForge.EVENT_BUS.register(renderManager);
	}
}