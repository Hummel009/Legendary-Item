package com.github.hummel.legendarium.handler;

import com.github.hummel.legendarium.model.EpicBakedModel;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.IRegistry;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;

public class ForgeEventHandler {
	public static final Map<ModelResourceLocation, ModelResourceLocation> COMPLIANCES = new HashMap<>();

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	@SuppressWarnings("MethodMayBeStatic")
	public void onModelBake(ModelBakeEvent event) {
		IRegistry<ModelResourceLocation, IBakedModel> modelRegistry = event.modelRegistry;
		for (Map.Entry<ModelResourceLocation, ModelResourceLocation> compliance : COMPLIANCES.entrySet()) {
			ModelResourceLocation smallModelResourceLocation = compliance.getKey();
			IBakedModel smallBakedModel = modelRegistry.getObject(smallModelResourceLocation);
			if (smallBakedModel != null) {
				ModelResourceLocation largeModelResourceLocation = compliance.getValue();
				IBakedModel largeBakedModel = modelRegistry.getObject(largeModelResourceLocation);
				if (largeBakedModel != null) {
					IBakedModel epicBakedModel = new EpicBakedModel(smallBakedModel, largeBakedModel);
					modelRegistry.putObject(smallModelResourceLocation, epicBakedModel);
				}
			}
		}
	}
}