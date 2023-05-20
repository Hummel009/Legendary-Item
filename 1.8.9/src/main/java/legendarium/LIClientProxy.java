package legendarium;

import java.util.Objects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class LIClientProxy extends LICommonProxy {

	@Override
	public void registerRenders() {
		for (Item item : LI.CONTENT) {
			String regName = item.getRegistryName();
			ModelResourceLocation mrl = new ModelResourceLocation(Objects.requireNonNull(regName), "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, mrl);
		}
	}
}
