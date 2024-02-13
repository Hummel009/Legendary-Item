package legendarium.listener;

import legendarium.init.Items;
import legendarium.render.RenderEpicItem;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import java.util.ArrayList;
import java.util.Collection;

public class ReloadListener implements IResourceManagerReloadListener {
	public static final Collection<RenderEpicItem> LARGE_ITEM_RENDERS = new ArrayList<>();

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		LARGE_ITEM_RENDERS.clear();
		for (Item item : Items.CONTENT) {
			MinecraftForgeClient.registerItemRenderer(item, null);
			RenderEpicItem largeItemRenderer = RenderEpicItem.getRendererIfLarge(item);
			if (largeItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item, largeItemRenderer);
				LARGE_ITEM_RENDERS.add(largeItemRenderer);
			}
		}
	}
}