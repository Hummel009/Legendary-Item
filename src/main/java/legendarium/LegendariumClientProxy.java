package legendarium;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lotr.client.render.item.LOTRRenderBow;
import lotr.client.render.item.LOTRRenderCrossbow;
import lotr.client.render.item.LOTRRenderElvenBlade;
import lotr.client.render.item.LOTRRenderLargeItem;
import lotr.common.item.LOTRItemBow;
import lotr.common.item.LOTRItemCrossbow;
import lotr.common.item.LOTRItemSword;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;


public class LegendariumClientProxy extends LegendariumServerProxy {
	
	@Override
    public void preInit(FMLPreInitializationEvent event) {
        this.registerItemRenderers();
    }
	
	public void registerItemRenderers() {
        for (Item item : LegendariumCommander.getAllGOTItems()) {
            boolean large;
            if (item == null) continue;
            LegendariumRender largeItemRenderer = LegendariumRender.getLargeIconSize(item);
            boolean bl = large = largeItemRenderer != null;
            if (item instanceof LOTRItemCrossbow) {
                MinecraftForgeClient.registerItemRenderer((Item)item, (IItemRenderer)new LOTRRenderCrossbow());
                continue;
            }
            if (!large) continue;
            MinecraftForgeClient.registerItemRenderer((Item)item, (IItemRenderer)largeItemRenderer);
        }
    }
}
