package legendarium.replacer;

import legendarium.LIRegistry;
import lotr.common.item.LOTRItemAnduril;

public class LIItemSwordUsual extends LOTRItemAnduril {
	public LIItemSwordUsual() {
		super();
		initialize();
	}

	public void initialize() {
		LIRegistry.CONTENT.add(this);
	}
}