package legendarium;

import legendarium.render.LIRenderable;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.item.Item;

public interface LIDependencyManager {
	void registerSpecial();

	void registerCommon();

	void register(Item item, String field);

	LIRenderable getRendererIfLarge(Item item);

	void onResourceManagerReload(IResourceManager resourceManager);
}
