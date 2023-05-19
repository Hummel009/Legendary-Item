package legendarium.replacer;

import legendarium.LIRegistry;
import lotr.common.item.LOTRItemGlamdring;

public class LIItemSwordGlowing extends LOTRItemGlamdring {
	public LIItemSwordGlowing() {
		initialize();
	}

	public void initialize() {
		LIRegistry.CONTENT.add(this);
	}
}