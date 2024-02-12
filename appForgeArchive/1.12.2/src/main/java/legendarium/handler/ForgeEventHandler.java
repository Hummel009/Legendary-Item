package legendarium.handler;

import legendarium.Main;
import legendarium.init.Items;
import legendarium.model.EpicBakedModel;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ForgeEventHandler {
	private static final Map<ModelResourceLocation, ModelResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	public void onItemRegistry(RegistryEvent.Register<Item> event) {
		Items.register();
	}

	@SubscribeEvent
	public void onModelRegistry(ModelRegistryEvent event) {
		for (Item item : Items.CONTENT) {
			ResourceLocation registryName = item.getRegistryName();
			String resourceFileName = (registryName + "_large.json").replace("legendarium:", "");
			try (InputStream inputStream = Main.class.getResourceAsStream("/assets/legendarium/models/item/" + resourceFileName)) {
				ModelResourceLocation smallResourceLocation = new ModelResourceLocation(registryName, "inventory");
				ModelResourceLocation largeResourceLocation = new ModelResourceLocation(registryName + "_large", "inventory");
				if (inputStream != null) {
					COMPLIANCES.put(smallResourceLocation, largeResourceLocation);
					ModelBakery.registerItemVariants(item, smallResourceLocation, largeResourceLocation);
				} else {
					ModelBakery.registerItemVariants(item, smallResourceLocation);
				}
				ModelLoader.setCustomModelResourceLocation(item, 0, smallResourceLocation);
			} catch (Exception e) {
			}
		}
	}

	@SubscribeEvent
	public void onModelBake(ModelBakeEvent event) {
		for (Map.Entry<ModelResourceLocation, ModelResourceLocation> compliance : COMPLIANCES.entrySet()) {
			ModelResourceLocation smallResourceLocation = compliance.getKey();
			IBakedModel smallBakedModel = event.getModelRegistry().getObject(smallResourceLocation);
			if (smallBakedModel != null) {
				ModelResourceLocation largeResourceLocation = compliance.getValue();
				IBakedModel largeBakedModel = event.getModelRegistry().getObject(largeResourceLocation);
				if (largeBakedModel != null) {
					event.getModelRegistry().putObject(smallResourceLocation, new EpicBakedModel(smallBakedModel, largeBakedModel));
				}
			}
		}
	}
}