package legendarium.proxy;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LIClientProxy extends LIServerProxy {
	private static final Minecraft MC = Minecraft.getInstance();

	@SubscribeEvent
	public void onModelBake(ModelBakeEvent event) {
		LIReloadListener.INSTANCE.onModelBake(event);
	}

	@SubscribeEvent
	public void onModelRegistry(ModelRegistryEvent event) {
		LIReloadListener.INSTANCE.setupAndDetectModels(MC);
	}
}
