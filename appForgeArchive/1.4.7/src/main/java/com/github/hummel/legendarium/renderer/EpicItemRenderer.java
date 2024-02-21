package com.github.hummel.legendarium.renderer;

import com.github.hummel.legendarium.Main;
import net.minecraft.client.Minecraft;
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
	public void renderItem(ItemRenderType itemRenderType, ItemStack itemStack, Object... data) {
		GL11.glPushMatrix();

		RenderEngine renderEngine = Minecraft.getMinecraft().renderEngine;
		String itemTexturePath = getItemTexturePath(item, folder);
		int itemTextureInt = renderEngine.getTexture(itemTexturePath);
		renderEngine.bindTexture(itemTextureInt);

		GL11.glTranslatef(-(scale - 1.0f) / 2.0f, -(scale - 1.0f) / 2.0f, 0.0f);
		GL11.glScalef(scale, scale, 1.0f);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

		Tessellator tessellator = Tessellator.instance;
		int textureSize = itemTexturePath.contains("2x") ? 32 : 48;
		renderItemIn2D(tessellator, 1.0f, 0.0f, 0.0f, 1.0f, textureSize, textureSize, 0.0625f);

		if (itemStack.hasEffect()) {
			GL11.glDepthFunc(514);
			GL11.glDisable(2896);
			int enchantmentTextureInt = renderEngine.getTexture(ENCHANTMENT_TEXTURE);
			renderEngine.bindTexture(enchantmentTextureInt);
			GL11.glEnable(3042);
			GL11.glBlendFunc(768, 1);
			float shade = 0.76f;
			GL11.glColor4f(0.5f * shade, 0.25f * shade, 0.8f * shade, 1.0f);
			GL11.glMatrixMode(5890);
			GL11.glPushMatrix();
			float scale = 0.125f;
			GL11.glScalef(scale, scale, scale);
			float randomShift = Minecraft.getSystemTime() % 3000L / 3000.0f * 8.0f;
			GL11.glTranslatef(randomShift, 0.0f, 0.0f);
			GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
			renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glScalef(scale, scale, scale);
			randomShift = Minecraft.getSystemTime() % 4873L / 4873.0f * 8.0f;
			GL11.glTranslatef(-randomShift, 0.0f, 0.0f);
			GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
			renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
			GL11.glPopMatrix();
			GL11.glMatrixMode(5888);
			GL11.glDisable(3042);
			GL11.glEnable(2896);
			GL11.glDepthFunc(515);
		}

		GL11.glPopMatrix();
	}

	@Override
	public boolean handleRenderType(ItemStack itemStack, ItemRenderType itemRenderType) {
		return itemRenderType == ItemRenderType.EQUIPPED;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType itemRenderType, ItemStack itemStack, ItemRendererHelper itemRendererHelper) {
		return false;
	}

	public static EpicItemRenderer getRendererIfEpic(Item item) {
		for (Map.Entry<String, Float> folder : SIZE_FOLDERS.entrySet()) {
			String itemTexturePath = getItemTexturePath(item, folder.getKey());
			InputStream inputStream = null;
			try {
				inputStream = Main.class.getResourceAsStream(itemTexturePath);
				if (inputStream != null) {
					return new EpicItemRenderer(item, folder.getKey(), folder.getValue());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (inputStream != null) {
						inputStream.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private static String getItemTexturePath(Item item, String folder) {
		return "/assets/legendarium/textures/items/" + folder + '/' + getItemName(item) + ".png";
	}

	private static String getItemName(Item item) {
		return item.getItemName().substring("item.".length());
	}

	private static void renderItemIn2D(Tessellator tessellator, float uMin, float vMin, float uMax, float vMax, int width, int height, float f) {
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0f, 0.0f, 1.0f);
		tessellator.addVertexWithUV(0.0, 0.0, 0.0, uMin, vMax);
		tessellator.addVertexWithUV(1.0, 0.0, 0.0, uMax, vMax);
		tessellator.addVertexWithUV(1.0, 1.0, 0.0, uMax, vMin);
		tessellator.addVertexWithUV(0.0, 1.0, 0.0, uMin, vMin);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0f, 0.0f, -1.0f);
		tessellator.addVertexWithUV(0.0, 1.0, 0.0f - f, uMin, vMin);
		tessellator.addVertexWithUV(1.0, 1.0, 0.0f - f, uMax, vMin);
		tessellator.addVertexWithUV(1.0, 0.0, 0.0f - f, uMax, vMax);
		tessellator.addVertexWithUV(0.0, 0.0, 0.0f - f, uMin, vMax);
		tessellator.draw();
		float f5 = width * (uMin - uMax);
		float f6 = height * (vMax - vMin);
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1.0f, 0.0f, 0.0f);

		int k;
		float f7;
		float f8;
		for (k = 0; k < f5; ++k) {
			f7 = k / f5;
			f8 = uMin + (uMax - uMin) * f7 - 0.5f / width;
			tessellator.addVertexWithUV(f7, 0.0, 0.0f - f, f8, vMax);
			tessellator.addVertexWithUV(f7, 0.0, 0.0, f8, vMax);
			tessellator.addVertexWithUV(f7, 1.0, 0.0, f8, vMin);
			tessellator.addVertexWithUV(f7, 1.0, 0.0f - f, f8, vMin);
		}

		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0f, 0.0f, 0.0f);

		float f9;
		for (k = 0; k < f5; ++k) {
			f7 = k / f5;
			f8 = uMin + (uMax - uMin) * f7 - 0.5f / width;
			f9 = f7 + 1.0f / f5;
			tessellator.addVertexWithUV(f9, 1.0, 0.0f - f, f8, vMin);
			tessellator.addVertexWithUV(f9, 1.0, 0.0, f8, vMin);
			tessellator.addVertexWithUV(f9, 0.0, 0.0, f8, vMax);
			tessellator.addVertexWithUV(f9, 0.0, 0.0f - f, f8, vMax);
		}

		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0f, 1.0f, 0.0f);

		for (k = 0; k < f6; ++k) {
			f7 = k / f6;
			f8 = vMax + (vMin - vMax) * f7 - 0.5f / height;
			f9 = f7 + 1.0f / f6;
			tessellator.addVertexWithUV(0.0, f9, 0.0, uMin, f8);
			tessellator.addVertexWithUV(1.0, f9, 0.0, uMax, f8);
			tessellator.addVertexWithUV(1.0, f9, 0.0f - f, uMax, f8);
			tessellator.addVertexWithUV(0.0, f9, 0.0f - f, uMin, f8);
		}

		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0f, -1.0f, 0.0f);

		for (k = 0; k < f6; ++k) {
			f7 = k / f6;
			f8 = vMax + (vMin - vMax) * f7 - 0.5f / height;
			tessellator.addVertexWithUV(1.0, f7, 0.0, uMax, f8);
			tessellator.addVertexWithUV(0.0, f7, 0.0, uMin, f8);
			tessellator.addVertexWithUV(0.0, f7, 0.0f - f, uMin, f8);
			tessellator.addVertexWithUV(1.0, f7, 0.0F - f, uMax, f8);
		}

		tessellator.draw();
	}
}