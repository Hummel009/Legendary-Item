package com.github.hummel.legendarium.renderer;

import com.github.hummel.legendarium.Main;
import com.google.common.base.CaseFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class EpicItemRenderer implements IItemRenderer {
	private static final String ENCHANTMENT_TEXTURE = "%blur%/misc/glint.png";
	private static final Map<String, Float> SIZE_FOLDERS = new HashMap<String, Float>();

	static {
		SIZE_FOLDERS.put("large-2x", 2.0f);
		SIZE_FOLDERS.put("large-3x", 3.0f);
	}

	private final Item item;
	private final String folder;
	private final float scale;

	private EpicItemRenderer(Item item, String folder, float scale) {
		this.item = item;
		this.folder = folder;
		this.scale = scale;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemstack, Object... data) {
		GL11.glPushMatrix();
		GL11.glTranslatef(-(scale - 1.0f) / 2.0f, -(scale - 1.0f) / 2.0f, 0.0f);
		GL11.glScalef(scale, scale, 1.0f);
		RenderEngine renderEngine = Minecraft.getMinecraft().renderEngine;
		String itemTexturePath = getItemTexturePath(item, folder);
		renderEngine.bindTexture(itemTexturePath);
		int textureSize = itemTexturePath.contains("2x") ? 32 : 48;
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		Tessellator tessellator = Tessellator.instance;
		ItemRenderer.renderItemIn2D(tessellator, 1.0f, 0.0f, 0.0f, 1.0f, textureSize, textureSize, 0.0625F);
		if (itemstack.hasEffect()) {
			GL11.glDepthFunc(514);
			GL11.glDisable(2896);
			renderEngine.bindTexture(ENCHANTMENT_TEXTURE);
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
		GL11.glPopMatrix();
	}

	@Override
	public boolean handleRenderType(ItemStack itemstack, ItemRenderType type) {
		return type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack itemstack, IItemRenderer.ItemRendererHelper helper) {
		return false;
	}

	public static EpicItemRenderer getRendererIfLarge(Item item) {
		for (Map.Entry<String, Float> folder : SIZE_FOLDERS.entrySet()) {
			try {
				String itemTexturePath = getItemTexturePath(item, folder.getKey());
				InputStream inputStream = null;
				try {
					inputStream = Main.class.getResourceAsStream(itemTexturePath);
					if (inputStream != null) {
						return new EpicItemRenderer(item, folder.getKey(), folder.getValue());
					}
				} finally {
					try {
						if (inputStream != null) {
							inputStream.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (Exception ignored) {
			}
		}
		return null;
	}

	private static String getItemTexturePath(Item item, String folder) {
		return "/textures/items/" + folder + '/' + getItemName(item) + ".png";
	}

	private static String getItemName(Item item) {
		return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, item.getUnlocalizedName().substring("item.".length()));
	}
}