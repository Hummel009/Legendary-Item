package legendarium;

import legendarium.render.LIRenderable;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.item.Item;

public interface LIDependencyManager {
	LIRenderable getRendererIfLarge(Item item);

	void onResourceManagerReload(IResourceManager resourceManager);

	void register(Item item, String field);

	void registerCommon();

	void registerSpecial();
}
