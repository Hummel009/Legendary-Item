package com.github.hummel.legendarium.init;

import com.github.hummel.legendarium.util.UnicodeHelper;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Langs {
	private Langs() {
	}

	public static void preInit() {
		LanguageRegistry instance = LanguageRegistry.instance();

		UnicodeHelper.loadLocalization(instance, "/assets/legendarium/lang/en_US.lang", "en_US");
		UnicodeHelper.loadLocalization(instance, "/assets/legendarium/lang/ru_RU.lang", "ru_RU");
		UnicodeHelper.loadLocalization(instance, "/assets/legendarium/lang/uk_UA.lang", "uk_UA");
		UnicodeHelper.loadLocalization(instance, "/assets/legendarium/lang/zh_CN.lang", "zh_CN");
	}
}
