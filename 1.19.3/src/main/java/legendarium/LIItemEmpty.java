package legendarium;

import net.minecraft.world.item.Item;

public class LIItemEmpty extends Item {
    public LIItemEmpty() {
        super(new Properties());
        initialize();
    }

    public void initialize() {
        LI.itemList.add(this);
    }
}