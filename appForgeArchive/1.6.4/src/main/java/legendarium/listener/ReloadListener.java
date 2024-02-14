package legendarium.listener;

import legendarium.init.Items;
import legendarium.render.RenderEpicItem;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.resources.ResourceManagerReloadListener;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import java.util.ArrayList;
import java.util.Collection;

public class ReloadListener implements ResourceManagerReloadListener {
	public static final Collection<RenderEpicItem> LARGE_ITEM_RENDERS = new ArrayList<RenderEpicItem>();

	@Override
	public void onResourceManagerReload(ResourceManager resourceManager) {
		LARGE_ITEM_RENDERS.clear();
		for (Item item : Items.CONTENT) {
			MinecraftForgeClient.registerItemRenderer(item.itemID, null);
			RenderEpicItem largeItemRenderer = RenderEpicItem.getRendererIfLarge(item);
			if (largeItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item.itemID, largeItemRenderer);
				LARGE_ITEM_RENDERS.add(largeItemRenderer);
			}
		}
	}
}