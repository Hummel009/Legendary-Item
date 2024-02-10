package legendarium.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("WeakerAccess")
public class ItemGroups {
	public static final CreativeModeTab TAB_ARTIFACTS = FabricItemGroupBuilder.create(new ResourceLocation("legendarium", "artifacts")).icon(() -> new ItemStack(Items.WEAPON_FARAMIR)).appendItems(populator -> {
		for (Item item : Items.CONTENT) {
			populator.add(new ItemStack(item));
		}
	}).build();

	private ItemGroups() {
	}
}