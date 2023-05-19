package legendarium.replacer;

import legendarium.LIRegistry;
import lotr.common.item.LOTRItemGandalfStaffWhite;

public class LIItemStaff extends LOTRItemGandalfStaffWhite {
	public LIItemStaff() {
		initialize();
	}

	public void initialize() {
		LIRegistry.CONTENT.add(this);
	}
}