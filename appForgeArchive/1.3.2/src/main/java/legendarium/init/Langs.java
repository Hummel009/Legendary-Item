package legendarium.init;

import cpw.mods.fml.common.registry.LanguageRegistry;
import legendarium.util.UnicodeHelper;

public class Langs {
	private Langs() {
	}

	public static void preInit() {
		LanguageRegistry instance = LanguageRegistry.instance();

		UnicodeHelper.loadLocalization(instance, "/assets/trop/lang/en_US.lang", "en_US");
		UnicodeHelper.loadLocalization(instance, "/assets/trop/lang/ru_RU.lang", "ru_RU");
		UnicodeHelper.loadLocalization(instance, "/assets/trop/lang/uk_UA.lang", "uk_UA");
		UnicodeHelper.loadLocalization(instance, "/assets/trop/lang/zh_CN.lang", "zh_CN");
	}
}
