package com.github.hummel.legendarium.handler;

import com.github.hummel.legendarium.Main;
import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.model.EpicBakedModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.registry.IRegistry;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ForgeEventHandler {
	private static final Map<ModelResourceLocation, ModelResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	public void onItemRegistry(RegistryEvent.Register<Item> event) {
		Items.register();
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onModelRegistry(ModelRegistryEvent event) {
		Collection<ModelResourceLocation> modelResourceLocations = new HashSet<>();

		for (Item item : Items.CONTENT) {
			String name = item.getTranslationKey().substring("item.".length());
			String smallResourceLocation = String.format("legendarium:%s", name);
			String largeResourceLocation = String.format("legendarium:%s_large", name);
			String largeJsonModelPath = String.format("/assets/legendarium/models/item/%s_large.json", name);

			ModelResourceLocation smallModelResourceLocation = new ModelResourceLocation(smallResourceLocation, "inventory");

			modelResourceLocations.clear();

			try (InputStream inputStream = Main.class.getResourceAsStream(largeJsonModelPath)) {
				if (inputStream != null) {
					ModelResourceLocation largeModelResourceLocation = new ModelResourceLocation(largeResourceLocation, "inventory");

					COMPLIANCES.put(smallModelResourceLocation, largeModelResourceLocation);
					modelResourceLocations.add(largeModelResourceLocation);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				modelResourceLocations.add(smallModelResourceLocation);
			}

			ModelBakery.registerItemVariants(item, modelResourceLocations.toArray(new ModelResourceLocation[0]));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, smallModelResourceLocation);
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
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