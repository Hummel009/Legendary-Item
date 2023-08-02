package legendarium.render;

import com.google.common.base.CaseFormat;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.Resource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;

public class LIRenderLargeItem implements IItemRenderer {
	public static ResourceLocation enchantmentTexture = new ResourceLocation("textures/misc/enchanted_item_glint.png");
	public static Map<String, Float> sizeFolders = new HashMap<String, Float>();
	public static Map<Item, Icon> largeIconsMap = new HashMap<Item, Icon>();

	static {
		sizeFolders.put("large-2x", 2.0f);
		sizeFolders.put("large-3x", 3.0f);
	}

	private Item theItem;
	private String folderName;
	private float largeIconScale;

	public LIRenderLargeItem(Item item, String dir, float f) {
		theItem = item;
		folderName = dir;
		largeIconScale = f;
	}

	public static ResourceLocation getLargeTexturePath(Item item, String folder) {
		String itemIconString = item.getUnlocalizedName().substring("item.".length());
		itemIconString = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemIconString);
		GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor(item);
		String modID = isNullOrEmpty(UID.modId) ? "minecraft" : UID.modId;
		return new ResourceLocation(modID, "textures/items/" + folder + "/" + itemIconString + ".png");
	}

	public static LIRenderLargeItem getRendererIfLarge(Item item) {
		for (Map.Entry<String, Float> folder : sizeFolders.entrySet()) {
			float iconScale = folder.getValue();
			try {
				ResourceLocation resLoc = getLargeTexturePath(item, folder.getKey());
				Resource res = Minecraft.getMinecraft().getResourceManager().getResource(resLoc);
				if (res != null) {
					return new LIRenderLargeItem(item, folder.getKey(), iconScale);
				}
			} catch (Exception ignored) {
			}
		}
		return null;
	}

	public static boolean isNullOrEmpty(CharSequence str) {
		return str == null || str.isEmpty();
	}

	public static void renderEnchantmentEffect() {
		Tessellator tessellator = Tessellator.instance;
		TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
		GL11.glDepthFunc(514);
		GL11.glDisable(2896);
		texturemanager.bindTexture(enchantmentTexture);
		GL11.glEnable(3042);
		GL11.glBlendFunc(768, 1);
		float shade = 0.76F;
		GL11.glColor4f(0.5F * shade, 0.25F * shade, 0.8F * shade, 1.0F);
		GL11.glMatrixMode(5890);
		GL11.glPushMatrix();
		float scale = 0.125F;
		GL11.glScalef(scale, scale, scale);
		float randomShift = Minecraft.getSystemTime() % 3000L / 3000.0F * 8.0F;
		GL11.glTranslatef(randomShift, 0.0F, 0.0F);
		GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
		ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		GL11.glScalef(scale, scale, scale);
		randomShift = Minecraft.getSystemTime() % 4873L / 4873.0F * 8.0F;
		GL11.glTranslatef(-randomShift, 0.0F, 0.0F);
		GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
		ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
		GL11.glPopMatrix();
		GL11.glMatrixMode(5888);
		GL11.glDisable(3042);
		GL11.glEnable(2896);
		GL11.glDepthFunc(515);
	}

	public void doTransformations() {
		GL11.glTranslatef(-(largeIconScale - 1.0f) / 2.0f, -(largeIconScale - 1.0f) / 2.0f, 0.0f);
		GL11.glScalef(largeIconScale, largeIconScale, 1.0f);
	}

	@Override
	public boolean handleRenderType(ItemStack itemstack, IItemRenderer.ItemRenderType type) {
		return type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON;
	}

	public void registerIcons(IconRegister register) {
		registerLargeIcon(register, null);
	}

	public void registerLargeIcon(IconRegister register, String extra) {
		String itemName = theItem.getUnlocalizedName().substring("item.".length());
		itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemName);
		GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor(theItem);
		String modID = (isNullOrEmpty(UID.modId) ? "minecraft" : UID.modId) + ":";
		StringBuilder path = new StringBuilder().append(modID).append(folderName).append("/").append(itemName);
		if (!isNullOrEmpty(extra)) {
			path.append("_").append(extra);
		}
		Icon sus = register.registerIcon(path.toString());
		largeIconsMap.put(theItem, sus);
	}

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack itemstack, Object... data) {
		GL11.glPushMatrix();
		renderLargeItem(largeIconsMap.get(itemstack.getItem()));
		if (itemstack.hasEffect(0)) {
			renderEnchantmentEffect();
		}
		GL11.glPopMatrix();
	}

	public void renderLargeItem(Icon icon) {
		doTransformations();
		Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationItemsTexture);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		Tessellator tess = Tessellator.instance;
		ItemRenderer.renderItemIn2D(tess, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625f);
	}

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack itemstack, IItemRenderer.ItemRendererHelper helper) {
		return false;
	}
}