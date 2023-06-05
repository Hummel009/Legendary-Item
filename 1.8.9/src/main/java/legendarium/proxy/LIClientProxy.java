package legendarium.proxy;

import legendarium.LI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LIClientProxy extends LICommonProxy {

	@Override
	@SideOnly(Side.CLIENT)
	public void registerRenders() {
		for (Item item : LI.CONTENT) {
			String regName = item.getRegistryName();
			ModelResourceLocation mrl = new ModelResourceLocation(regName, "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, mrl);
		}
	}
}
