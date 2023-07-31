package legendarium.lotr;

import com.google.common.base.CaseFormat;
import cpw.mods.fml.common.registry.GameRegistry;
import legendarium.render.LIRenderable;
import lotr.client.render.item.LOTRRenderLargeItem;
import lotr.common.util.LOTRLog;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import org.lwjgl.opengl.GL11;

import java.util.*;

public class LIRenderLargeItemLOTR extends LOTRRenderLargeItem implements LIRenderable {
	public static Map<String, Float> sizeFolders = new HashMap<>();

	static {
		sizeFolders.put("large-2x", 2.0f);
		sizeFolders.put("large-3x", 3.0f);
	}

	private Item theItem;
	private String folderName;
	private float largeIconScale;
	private IIcon largeIcon;
	private Collection<ExtraLargeIconToken> extraTokens = new ArrayList<>();

	public LIRenderLargeItemLOTR(Item item, String dir, float f) {
		super(item, dir, f);
		theItem = item;
		folderName = dir;
		largeIconScale = f;
	}

	public static ResourceLocation getLargeTexturePath(Item item, String folder) {
		String itemIconString = item.getUnlocalizedName().substring("item.".length());
		itemIconString = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemIconString);
		GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor(item);
		if (UID == null) {
			LOTRLog.logger.fatal("Tried registering a item which doesn't have a unique identifier.");
		}
		String modID = StringUtils.isNullOrEmpty(UID.modId) ? "minecraft" : UID.modId;
		return new ResourceLocation(modID, "textures/items/" + folder + "/" + itemIconString + ".png");
	}

	public void doTransformations() {
		GL11.glTranslatef(-(largeIconScale - 1.0f) / 2.0f, -(largeIconScale - 1.0f) / 2.0f, 0.0f);
		GL11.glScalef(largeIconScale, largeIconScale, 1.0f);
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
		if (UID == null) {
			LOTRLog.logger.fatal("Tried registering a item which doesn't have a unique identifier.");
		}
		String modID = (StringUtils.isNullOrEmpty(UID.modId) ? "minecraft" : UID.modId) + ":";
		StringBuilder path = new StringBuilder().append(modID).append(folderName).append("/").append(itemName);
		if (!StringUtils.isNullOrEmpty(extra)) {
			path.append("_").append(extra);
		}
		return register.registerIcon(path.toString());
	}

	@Override
	public void renderLargeItem() {
		renderLargeItem(largeIcon);
	}

	public void renderLargeItem(IIcon icon) {
		doTransformations();
		Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationItemsTexture);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		Tessellator tess = Tessellator.instance;
		ItemRenderer.renderItemIn2D(tess, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625f);
	}
}