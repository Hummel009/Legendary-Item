package com.github.hummel.legendarium.renderer;

import com.github.hummel.legendarium.Main;
import com.google.common.base.CaseFormat;
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
		return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, item.getItemName().substring("item.".length()));
	}

	@Override
	public boolean handleRenderType(ItemStack itemstack, ItemRenderType type) {
		return type == ItemRenderType.EQUIPPED;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemstack, Object... data) {
		GL11.glPushMatrix();
		GL11.glTranslatef(-(scale - 1.0f) / 2.0f, -(scale - 1.0f) / 2.0f, 0.0f);
		GL11.glScalef(scale, scale, 1.0f);
		RenderEngine renderEngine = Minecraft.getMinecraft().renderEngine;
		String itemTexturePath = getItemTexturePath(item, folder);
		int itemTextureInt = renderEngine.getTexture(itemTexturePath);
		renderEngine.bindTexture(itemTextureInt);
		int textureSize = itemTexturePath.contains("2x") ? 32 : 48;
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		Tessellator tessellator = Tessellator.instance;
		renderItemIn2D(tessellator, 1.0f, 0.0f, 0.0f, 1.0f, textureSize, textureSize, 0.0625F);
		if (itemstack.hasEffect()) {
			GL11.glDepthFunc(514);
			GL11.glDisable(2896);
			int enchantmentTextureInt = renderEngine.getTexture(ENCHANTMENT_TEXTURE);
			renderEngine.bindTexture(enchantmentTextureInt);
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
			renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glScalef(scale, scale, scale);
			randomShift = Minecraft.getSystemTime() % 4873L / 4873.0f * 8.0f;
			GL11.glTranslatef(-randomShift, 0.0f, 0.0f);
			GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
			renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625F);
			GL11.glPopMatrix();
			GL11.glMatrixMode(5888);
			GL11.glDisable(3042);
			GL11.glEnable(2896);
			GL11.glDepthFunc(515);
		}
		GL11.glPopMatrix();
	}

	private static void renderItemIn2D(Tessellator par0Tessellator, float par1, float par2, float par3, float par4, int par5, int par6, float par7) {
		par0Tessellator.startDrawingQuads();
		par0Tessellator.setNormal(0.0F, 0.0F, 1.0F);
		par0Tessellator.addVertexWithUV(0.0, 0.0, 0.0, par1, par4);
		par0Tessellator.addVertexWithUV(1.0, 0.0, 0.0, par3, par4);
		par0Tessellator.addVertexWithUV(1.0, 1.0, 0.0, par3, par2);
		par0Tessellator.addVertexWithUV(0.0, 1.0, 0.0, par1, par2);
		par0Tessellator.draw();
		par0Tessellator.startDrawingQuads();
		par0Tessellator.setNormal(0.0F, 0.0F, -1.0F);
		par0Tessellator.addVertexWithUV(0.0, 1.0, 0.0F - par7, par1, par2);
		par0Tessellator.addVertexWithUV(1.0, 1.0, 0.0F - par7, par3, par2);
		par0Tessellator.addVertexWithUV(1.0, 0.0, 0.0F - par7, par3, par4);
		par0Tessellator.addVertexWithUV(0.0, 0.0, 0.0F - par7, par1, par4);
		par0Tessellator.draw();
		float f5 = par5 * (par1 - par3);
		float f6 = par6 * (par4 - par2);
		par0Tessellator.startDrawingQuads();
		par0Tessellator.setNormal(-1.0F, 0.0F, 0.0F);

		int k;
		float f7;
		float f8;
		for (k = 0; k < f5; ++k) {
			f7 = k / f5;
			f8 = par1 + (par3 - par1) * f7 - 0.5F / par5;
			par0Tessellator.addVertexWithUV(f7, 0.0, 0.0F - par7, f8, par4);
			par0Tessellator.addVertexWithUV(f7, 0.0, 0.0, f8, par4);
			par0Tessellator.addVertexWithUV(f7, 1.0, 0.0, f8, par2);
			par0Tessellator.addVertexWithUV(f7, 1.0, 0.0F - par7, f8, par2);
		}

		par0Tessellator.draw();
		par0Tessellator.startDrawingQuads();
		par0Tessellator.setNormal(1.0F, 0.0F, 0.0F);

		float f9;
		for (k = 0; k < f5; ++k) {
			f7 = k / f5;
			f8 = par1 + (par3 - par1) * f7 - 0.5F / par5;
			f9 = f7 + 1.0F / f5;
			par0Tessellator.addVertexWithUV(f9, 1.0, 0.0F - par7, f8, par2);
			par0Tessellator.addVertexWithUV(f9, 1.0, 0.0, f8, par2);
			par0Tessellator.addVertexWithUV(f9, 0.0, 0.0, f8, par4);
			par0Tessellator.addVertexWithUV(f9, 0.0, 0.0F - par7, f8, par4);
		}

		par0Tessellator.draw();
		par0Tessellator.startDrawingQuads();
		par0Tessellator.setNormal(0.0F, 1.0F, 0.0F);

		for (k = 0; k < f6; ++k) {
			f7 = k / f6;
			f8 = par4 + (par2 - par4) * f7 - 0.5F / par6;
			f9 = f7 + 1.0F / f6;
			par0Tessellator.addVertexWithUV(0.0, f9, 0.0, par1, f8);
			par0Tessellator.addVertexWithUV(1.0, f9, 0.0, par3, f8);
			par0Tessellator.addVertexWithUV(1.0, f9, 0.0F - par7, par3, f8);
			par0Tessellator.addVertexWithUV(0.0, f9, 0.0F - par7, par1, f8);
		}

		par0Tessellator.draw();
		par0Tessellator.startDrawingQuads();
		par0Tessellator.setNormal(0.0F, -1.0F, 0.0F);

		for (k = 0; k < f6; ++k) {
			f7 = k / f6;
			f8 = par4 + (par2 - par4) * f7 - 0.5F / par6;
			par0Tessellator.addVertexWithUV(1.0, f7, 0.0, par3, f8);
			par0Tessellator.addVertexWithUV(0.0, f7, 0.0, par1, f8);
			par0Tessellator.addVertexWithUV(0.0, f7, 0.0F - par7, par1, f8);
			par0Tessellator.addVertexWithUV(1.0, f7, 0.0F - par7, par3, f8);
		}

		par0Tessellator.draw();
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack itemstack, IItemRenderer.ItemRendererHelper helper) {
		return false;
	}
}