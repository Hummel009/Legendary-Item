package legendarium.handler;

import legendarium.Main;
import legendarium.init.Items;
import legendarium.model.EpicBakedModel;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.registry.IRegistry;
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
			String registryName = item.getRegistryName().toString();
			String resourceFileName = registryName.replace("legendarium:", "") + "_large.json";
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
		IRegistry<ModelResourceLocation, IBakedModel> modelRegistry = event.getModelRegistry();
		for (Map.Entry<ModelResourceLocation, ModelResourceLocation> compliance : COMPLIANCES.entrySet()) {
			ModelResourceLocation smallResourceLocation = compliance.getKey();
			IBakedModel smallBakedModel = modelRegistry.getObject(smallResourceLocation);
			if (smallBakedModel != null) {
				ModelResourceLocation largeResourceLocation = compliance.getValue();
				IBakedModel largeBakedModel = modelRegistry.getObject(largeResourceLocation);
				if (largeBakedModel != null) {
					IBakedModel epicBakedModel = new EpicBakedModel(smallBakedModel, largeBakedModel);
					modelRegistry.putObject(smallResourceLocation, epicBakedModel);
				}
			}
		}
	}
}