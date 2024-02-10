package legendarium.item;

import legendarium.init.Items;
import net.minecraft.world.item.Item;

public class ItemGem extends Item {
	public ItemGem() {
		super(new Properties().stacksTo(1));
		Items.CONTENT.add(this);
	}
}