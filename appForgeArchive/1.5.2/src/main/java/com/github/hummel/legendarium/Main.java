package com.github.hummel.legendarium;

import com.github.hummel.legendarium.init.Items;
import com.github.hummel.legendarium.init.Langs;
import com.github.hummel.legendarium.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "legendarium", useMetadata = true)
public class Main {
	@SuppressWarnings("unused")
	public static final String DISABLE_CURSEFORGE_DUPLICATE_NOTICE = "111229022024";

	@SidedProxy(clientSide = "com.github.hummel.legendarium.proxy.ClientProxy", serverSide = "com.github.hummel.legendarium.proxy.ServerProxy")
	@SuppressWarnings({"PublicField", "WeakerAccess"})
	public static CommonProxy proxy;

	@Mod.PreInit
	@SuppressWarnings("MethodMayBeStatic")
	public void preInit(FMLPreInitializationEvent event) {
		Config.preInit(event);

		Items.preInit();
		Langs.preInit();
	}

	@Mod.Init
	@SuppressWarnings("MethodMayBeStatic")
	public void onInit(FMLInitializationEvent event) {
		proxy.onInit();
	}
}