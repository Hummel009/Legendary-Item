package com.github.hummel.legendarium.init;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class Langs {
	private Langs() {
	}

	public static void preInit() {
		LanguageRegistry instance = LanguageRegistry.instance();

		instance.loadLocalization("/assets/legendarium/lang/en_US.lang", "en_US", false);
		instance.loadLocalization("/assets/legendarium/lang/ru_RU.lang", "ru_RU", false);
		instance.loadLocalization("/assets/legendarium/lang/uk_UA.lang", "uk_UA", false);
		instance.loadLocalization("/assets/legendarium/lang/zh_CN.lang", "zh_CN", false);
	}
}
