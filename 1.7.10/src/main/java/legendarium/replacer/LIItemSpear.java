package legendarium.replacer;

import legendarium.LIRegistry;
import lotr.common.LOTRCreativeTabs;
import lotr.common.item.LOTRItemSpear;
import lotr.common.item.LOTRMaterial;

public class LIItemSpear extends LOTRItemSpear {
	public LIItemSpear() {
		super(LOTRMaterial.HIGH_ELVEN);
		setCreativeTab(LOTRCreativeTabs.tabStory);
		initialize();
	}

	public void initialize() {
		LIRegistry.CONTENT.add(this);
	}
}