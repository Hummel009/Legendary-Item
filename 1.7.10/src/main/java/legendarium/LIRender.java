package legendarium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.lwjgl.opengl.GL11;

import com.google.common.base.CaseFormat;

import cpw.mods.fml.common.registry.GameRegistry;
import lotr.client.render.item.LOTRRenderLargeItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResource;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;

public class LIRender extends LOTRRenderLargeItem {
	private static final Map<String, Float> sizeFolders = new HashMap<>();
	static {
		sizeFolders.put("large-2x", 2.0f);
		sizeFolders.put("large-3x", 3.0f);
	}
	
	private final List<LOTRRenderLargeItem.ExtraLargeIconToken> extraTokens = new ArrayList<>();
	
	private final Item theItem;
	private final String folderName;
	private final float largeIconScale;
	private IIcon largeIcon;

	public LIRender(Item item, String dir, float f) {
		super(item, dir, f);
		theItem = item;
		folderName = dir;
		largeIconScale = f;
	}

	@Override
	public LOTRRenderLargeItem.ExtraLargeIconToken extraIcon(String name) {
		LOTRRenderLargeItem.ExtraLargeIconToken token = new LOTRRenderLargeItem.ExtraLargeIconToken(name);
		extraTokens.add(token);
		return token;
	}

	@Override
	public void registerIcons(IIconRegister register) {
		largeIcon = registerLargeIcon(register, null);
		for (LOTRRenderLargeItem.ExtraLargeIconToken token : extraTokens) {
			token.icon = registerLargeIcon(register, token.name);
		}
	}

	public IIcon registerLargeIcon(IIconRegister register, String extra) {
		String itemName = theItem.getUnlocalizedName().substring("item.".length());
		itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemName);
		GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor(theItem);
		String modID = (StringUtils.isNullOrEmpty(UID.modId) ? "minecraft" : UID.modId) + ":";
		StringBuilder path = new StringBuilder().append(modID).append(folderName).append("/").append(itemName);
		if (!StringUtils.isNullOrEmpty(extra)) {
			path.append("_").append(extra);
		}
		return register.registerIcon(path.toString());
	}

	@Override
	public void renderLargeItem() {
		GL11.glTranslatef(-(largeIconScale - 1.0f) / 2.0f, -(largeIconScale - 1.0f) / 2.0f, 0.0f);
		GL11.glScalef(largeIconScale, largeIconScale, 1.0f);
		Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationItemsTexture);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		Tessellator tess = Tessellator.instance;
		ItemRenderer.renderItemIn2D(tess, largeIcon.getMaxU(), largeIcon.getMinV(), largeIcon.getMinU(), largeIcon.getMaxV(), largeIcon.getIconWidth(), largeIcon.getIconHeight(), 0.0625f);
	}

	public static ResourceLocation getLargeTexturePath(Item item, String folder) {
		String itemIconString = item.getUnlocalizedName().substring("item.".length());
		itemIconString = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemIconString);
		GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor(item);
		String modID = StringUtils.isNullOrEmpty(UID.modId) ? "minecraft" : UID.modId;
		return new ResourceLocation(modID, "textures/items/" + folder + "/" + itemIconString + ".png");
	}

	public static LIRender getRendererIfLarge(Item item) {
		for (Entry<String, Float> folder : sizeFolders.entrySet()) {
			float iconScale = folder.getValue();
			try {
				ResourceLocation resLoc = LIRender.getLargeTexturePath(item, folder.getKey());
				IResource res = Minecraft.getMinecraft().getResourceManager().getResource(resLoc);
				if (res != null) {
					return new LIRender(item, folder.getKey(), iconScale);
				}
			} catch (IOException resLoc) {
			}
		}
		return null;
	}
}
