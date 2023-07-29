package legendarium.render;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public interface LIRenderable {
	static LIRenderable getRendererIfLarge(Item item) {
		return null;
	}

	void registerIcons(IIconRegister map);
}
