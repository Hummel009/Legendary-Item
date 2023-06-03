package legendarium;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.Objects;

public class LIClientProxy extends LICommonProxy {

	@Override
	public void registerRenders() {
		for (Item item : LI.CONTENT) {
			ResourceLocation regName = item.getRegistryName();
			ModelResourceLocation mrl = new ModelResourceLocation(Objects.requireNonNull(regName), "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, mrl);
		}
	}
}
