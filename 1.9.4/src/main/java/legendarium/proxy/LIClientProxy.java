package legendarium.proxy;

import legendarium.LI;
import legendarium.content.LIItemSword;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.*;

public class LIClientProxy extends LICommonProxy {
	public static final Map<ModelResourceLocation, ModelResourceLocation> COMPLIANCES = new HashMap<>();

	@Override
	@SideOnly(Side.CLIENT)
	public void onInit() {
		Collection<Item> inapplicable = new HashSet<>();
		inapplicable.add(LI.weaponAngrist);
		inapplicable.add(LI.weaponAcharn);
		inapplicable.add(LI.weaponLegolas);
		inapplicable.add(LI.weaponGrima);
		for (Item item : LI.CONTENT) {
			ResourceLocation itemName = item.getRegistryName();
			ModelResourceLocation smallModel = new ModelResourceLocation(itemName, "inventory");
			ModelResourceLocation largeModel = new ModelResourceLocation(itemName + "_large", "inventory");
			if (item instanceof LIItemSword && !inapplicable.contains(item)) {
				COMPLIANCES.put(smallModel, largeModel);
				ModelBakery.registerItemVariants(item, smallModel, largeModel);
			} else {
				ModelBakery.registerItemVariants(item, smallModel);
			}
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, smallModel);
		}
	}


	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onModelBake(ModelBakeEvent event) {
		for (Map.Entry<ModelResourceLocation, ModelResourceLocation> compliance : COMPLIANCES.entrySet()) {
			ModelResourceLocation smallLocation = compliance.getKey();
			IBakedModel smallModel = event.getModelRegistry().getObject(smallLocation);
			if (smallModel != null) {
				ModelResourceLocation largeLocation = compliance.getValue();
				IBakedModel largeModel = event.getModelRegistry().getObject(largeLocation);
				if (largeModel != null) {
					event.getModelRegistry().putObject(smallLocation, new LIItemSword.LargeItemModel(smallModel, largeModel));
				}
			}
		}
	}
}
