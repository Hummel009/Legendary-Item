package legendarium;

import net.minecraft.item.*;

public class LICreativeTabs {
	public static ItemGroup tabWeapons = new ItemGroup("weapons") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(LI.weapon_faramir.get());
		}
	};
}
