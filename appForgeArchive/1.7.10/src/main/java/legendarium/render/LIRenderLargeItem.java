package legendarium.render;

import com.google.common.base.CaseFormat;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LIRenderLargeItem implements IItemRenderer {
	private static final ResourceLocation ENCHANTMENT_TEXTURE = new ResourceLocation("textures/misc/enchanted_item_glint.png");
	private static final Map<String, Float> SIZE_FOLDERS = new HashMap<>();
	private static final Map<Item, IIcon> LARGE_ICONS_MAP = new HashMap<>();

	static {
		SIZE_FOLDERS.put("large-2x", 2.0f);
		SIZE_FOLDERS.put("large-3x", 3.0f);
	}

	private final Item theItem;
	private final String folderName;
	private final float largeIconScale;
	private IIcon largeIcon;
	private final Collection<ExtraLargeIconToken> extraTokens = new ArrayList<>();

	private LIRenderLargeItem(Item item, String dir, float f) {
		theItem = item;
		folderName = dir;
		largeIconScale = f;
	}

	private static ResourceLocation getLargeTexturePath(Item item, String folder) {
		String itemIconString = item.getUnlocalizedName().substring("item.".length());
		itemIconString = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemIconString);
		GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor(item);
		String modID = isNullOrEmpty(UID.modId) ? "minecraft" : UID.modId;
		return new ResourceLocation(modID, "textures/items/" + folder + '/' + itemIconString + ".png");
	}

	public static LIRenderLargeItem getRendererIfLarge(Item item) {
		for (Map.Entry<String, Float> folder : SIZE_FOLDERS.entrySet()) {
			float iconScale = folder.getValue();
			try {
				ResourceLocation resLoc = getLargeTexturePath(item, folder.getKey());
				IResource res = Minecraft.getMinecraft().getResourceManager().getResource(resLoc);
				return new LIRenderLargeItem(item, folder.getKey(), iconScale);
			} catch (Exception ignored) {
			}
		}
		return null;
	}

	private static boolean isNullOrEmpty(String str) {
		return str == null || str.isEmpty();
	}

	private static void renderEnchantmentEffect() {
		Tessellator tessellator = Tessellator.instance;
		TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
		GL11.glDepthFunc(514);
		GL11.glDisable(2896);
		texturemanager.bindTexture(ENCHANTMENT_TEXTURE);
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

	private void doTransformations() {
		GL11.glTranslatef(-(largeIconScale - 1.0f) / 2.0f, -(largeIconScale - 1.0f) / 2.0f, 0.0f);
		GL11.glScalef(largeIconScale, largeIconScale, 1.0f);
	}

	public LIRenderLargeItem.ExtraLargeIconToken extraIcon(String name) {
		LIRenderLargeItem.ExtraLargeIconToken token = new LIRenderLargeItem.ExtraLargeIconToken(name);
		extraTokens.add(token);
		return token;
	}

	@Override
	public boolean handleRenderType(ItemStack itemstack, IItemRenderer.ItemRenderType type) {
		return type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON;
	}

	public void registerIcons(IIconRegister register) {
		largeIcon = registerLargeIcon(register, null);
		for (LIRenderLargeItem.ExtraLargeIconToken token : extraTokens) {
			token.setIcon(registerLargeIcon(register, token.getName()));
		}
	}

	private IIcon registerLargeIcon(IIconRegister register, String extra) {
		String itemName = theItem.getUnlocalizedName().substring("item.".length());
		itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemName);
		GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor(theItem);
		String modID = (isNullOrEmpty(UID.modId) ? "minecraft" : UID.modId) + ':';
		StringBuilder path = new StringBuilder().append(modID).append(folderName).append('/').append(itemName);
		if (!isNullOrEmpty(extra)) {
			path.append('_').append(extra);
		}
		IIcon icon = register.registerIcon(path.toString());
		LARGE_ICONS_MAP.put(theItem, icon);
		return icon;
	}

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack itemstack, Object... data) {
		GL11.glPushMatrix();
		renderLargeItem(itemstack);
		if (itemstack.hasEffect(0)) {
			renderEnchantmentEffect();
		}
		GL11.glPopMatrix();
	}

	private void renderLargeItem(ItemStack itemstack) {
		if (largeIcon == null) {
			largeIcon = LARGE_ICONS_MAP.get(itemstack.getItem());
		}
		renderLargeItem(largeIcon);
	}

	public void renderLargeItem(ExtraLargeIconToken token) {
		renderLargeItem(token.getIcon());
	}

	private void renderLargeItem(IIcon icon) {
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

	private static class ExtraLargeIconToken {
		private String name;
		private IIcon icon;

		private ExtraLargeIconToken(String s) {
			name = s;
		}

		private IIcon getIcon() {
			return icon;
		}

		private void setIcon(IIcon icon) {
			this.icon = icon;
		}

		private String getName() {
			return name;
		}

		private void setName(String name) {
			this.name = name;
		}
	}
}