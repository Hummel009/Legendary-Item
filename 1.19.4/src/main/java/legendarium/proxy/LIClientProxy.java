package legendarium.proxy;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LIClientProxy extends LIServerProxy {
	private static final Minecraft MC = Minecraft.getInstance();

	@SubscribeEvent
	public void onModelRegistry(ModelEvent event) {
		HandheldItemModels.INSTANCE.setupAndDetectModels(MC);
	}

	@SubscribeEvent
	public void onModelBake(ModelEvent.BakingCompleted event) {
		HandheldItemModels.INSTANCE.onModelBake(event);
	}
}
