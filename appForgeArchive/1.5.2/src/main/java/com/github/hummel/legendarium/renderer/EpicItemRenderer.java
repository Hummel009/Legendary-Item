package com.github.hummel.legendarium.renderer;

import com.google.common.base.CaseFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;

public class EpicItemRenderer implements IItemRenderer {
	private static final String ENCHANTMENT_TEXTURE = "/textures/misc/enchanted_item_glint.png";
	private static final Map<String, Float> SIZE_FOLDERS = new HashMap<String, Float>();
	private static final Map<Item, Icon> LARGE_ICONS_MAP = new HashMap<Item, Icon>();

	static {
		SIZE_FOLDERS.put("large-2x", 2.0f);
		SIZE_FOLDERS.put("large-3x", 3.0f);
	}

	private final Item item;
	private final String folderName;
	private final float scale;
	private Icon largeIcon;

	private EpicItemRenderer(Item item, String folderName, float scale) {
		this.item = item;
		this.folderName = folderName;
		this.scale = scale;
	}

	private static String getLargeTexturePath(Item item, String folder) {
		String itemIconString = item.getUnlocalizedName().substring("item.".length());
		itemIconString = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemIconString);
		return "/textures/items/" + folder + '/' + itemIconString + ".png";
	}

	public static EpicItemRenderer getRendererIfLarge(Item item) {
		for (Map.Entry<String, Float> folder : SIZE_FOLDERS.entrySet()) {
			float iconScale = folder.getValue();
			try {
				String resLoc = getLargeTexturePath(item, folder.getKey());
				TextureManager textureManager = TextureManager.instance();
				textureManager.createTexture(resLoc);
				return new EpicItemRenderer(item, folder.getKey(), iconScale);
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
		TextureManager textureManager = TextureManager.instance();
		GL11.glDepthFunc(514);
		GL11.glDisable(2896);
		textureManager.createTexture(ENCHANTMENT_TEXTURE);
		GL11.glEnable(3042);
		GL11.glBlendFunc(768, 1);
		float shade = 0.76F;
		GL11.glColor4f(0.5f * shade, 0.25F * shade, 0.8f * shade, 1.0f);
		GL11.glMatrixMode(5890);
		GL11.glPushMatrix();
		float scale = 0.125F;
		GL11.glScalef(scale, scale, scale);
		float randomShift = Minecraft.getSystemTime() % 3000L / 3000.0f * 8.0f;
		GL11.glTranslatef(randomShift, 0.0f, 0.0f);
		GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
		ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		GL11.glScalef(scale, scale, scale);
		randomShift = Minecraft.getSystemTime() % 4873L / 4873.0f * 8.0f;
		GL11.glTranslatef(-randomShift, 0.0f, 0.0f);
		GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
		ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625F);
		GL11.glPopMatrix();
		GL11.glMatrixMode(5888);
		GL11.glDisable(3042);
		GL11.glEnable(2896);
		GL11.glDepthFunc(515);
	}

	private void doTransformations() {
		GL11.glTranslatef(-(scale - 1.0f) / 2.0f, -(scale - 1.0f) / 2.0f, 0.0f);
		GL11.glScalef(scale, scale, 1.0f);
	}

	@Override
	public boolean handleRenderType(ItemStack itemstack, IItemRenderer.ItemRenderType type) {
		return type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON;
	}

	public void registerIcons(IconRegister register) {
		largeIcon = registerLargeIcon(register, null);
	}

	private Icon registerLargeIcon(IconRegister register, String extra) {
		String itemName = item.getUnlocalizedName().substring("item.".length());
		itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemName);
		String path = folderName + '/' + itemName;
		if (!isNullOrEmpty(extra)) {
			path += '_' + extra;
		}
		Icon icon = register.registerIcon(path);
		LARGE_ICONS_MAP.put(item, icon);
		return icon;
	}

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack itemstack, Object... data) {
		GL11.glPushMatrix();
		renderLargeItem(itemstack);
		if (itemstack.hasEffect()) {
			renderEnchantmentEffect();
		}
		GL11.glPopMatrix();
	}

	private void renderLargeItem(Icon icon) {
		doTransformations();
		TextureManager textureManager = TextureManager.instance();
		textureManager.createTexture("/textures/atlas/items.png");
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		Tessellator tess = Tessellator.instance;
		ItemRenderer.renderItemIn2D(tess, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getOriginX(), icon.getOriginY(), 0.0625f);
	}

	private void renderLargeItem(ItemStack itemstack) {
		if (largeIcon == null) {
			largeIcon = LARGE_ICONS_MAP.get(itemstack.getItem());
		}
		try {
			renderLargeItem(largeIcon);
		} catch (Exception e) {
			System.out.println(itemstack.getItem().getUnlocalizedName());
		}
	}

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack itemstack, IItemRenderer.ItemRendererHelper helper) {
		return false;
	}
}