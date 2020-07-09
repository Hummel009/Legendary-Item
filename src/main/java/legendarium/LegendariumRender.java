package legendarium;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.opengl.GL11;

import com.google.common.base.CaseFormat;

import cpw.mods.fml.common.registry.GameRegistry;
import lotr.client.LOTRClientProxy;
import lotr.client.render.item.LOTRRenderLargeItem;
import lotr.common.item.LOTRItemLance;
import lotr.common.item.LOTRItemPike;
import lotr.common.item.LOTRItemSpear;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.IResource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.IItemRenderer;

public class LegendariumRender
implements IItemRenderer {
    private static Map<String, Float> sizeFolders = new HashMap<String, Float>();
    private static Map<Pair<Item, String>, ResourceLocation> largeItemTextures;
    private final Item theItem;
    private final ResourceLocation largeTexture;
    private final String folderName;
    private final float largeIconScale;
    private final int largeIconSize;

    private static ResourceLocation createLargeItemTexture(Item item, String folder) {
        return LegendariumRender.createLargeItemTexture(item, "", folder);
    }

    private static ResourceLocation createLargeItemTexture(Item item, String extra, String folder) {
        String modID;
        String itemIconString = item.getUnlocalizedName();
        if ((itemIconString = itemIconString.substring("item.".length())).contains(":")) {
            modID = itemIconString.substring(0, itemIconString.indexOf(":") + 1);
            itemIconString.substring(itemIconString.indexOf(":") + 1);
        } else {
            GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor((Item)item);
            if (UID == null) {
             
            }
            modID = "legendarium:";
        }
        itemIconString = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemIconString);
        String s = modID + "textures/items/" + folder + "/" + itemIconString;
        if (!StringUtils.isNullOrEmpty((String)extra)) {
            s = s + "_" + extra;
        }
        s = s + ".png";
        return new ResourceLocation(s);
    }

    public static ResourceLocation getOrCreateLargeItemTexture(Item item, String folder) {
        return LegendariumRender.getOrCreateLargeItemTexture(item, "", folder);
    }

    public static ResourceLocation getOrCreateLargeItemTexture(Item item, String extra, String folder) {
        ResourceLocation texture;
        Pair key;
        if (StringUtils.isNullOrEmpty((String)extra)) {
            extra = "";
        }
        if ((texture = largeItemTextures.get((Object)(key = Pair.of((Object)item, (Object)extra)))) == null) {
            texture = LegendariumRender.createLargeItemTexture(item, extra, folder);
            largeItemTextures.put((Pair<Item, String>)key, texture);
        }
        return texture;
    }

    public static LegendariumRender getLargeIconSize(Item item) {
        for (String folder : sizeFolders.keySet()) {
            float iconScale = sizeFolders.get(folder).floatValue();
            try {
                ResourceLocation resLoc = LegendariumRender.createLargeItemTexture(item, folder);
                IResource res = Minecraft.getMinecraft().getResourceManager().getResource(resLoc);
                if (res == null) continue;
                try {
                    BufferedImage img = ImageIO.read(ImageIO.createImageInputStream(res.getInputStream()));
                    if (img == null) continue;
                    if (img.getWidth() == img.getHeight()) {
                        return new LegendariumRender(item, resLoc, folder, iconScale, img.getWidth());
                    }
                  
                }
                catch (IOException e) {
                 
                }
            }
            catch (IOException resLoc) {}
        }
        return null;
    }

    public LegendariumRender(Item item, ResourceLocation res, String dir, float f, int i) {
        this.theItem = item;
        this.largeTexture = res;
        this.folderName = dir;
        this.largeIconScale = f;
        this.largeIconSize = i;
    }

    private ResourceLocation getSubtypeTexture(String extra) {
        return LegendariumRender.getOrCreateLargeItemTexture(this.theItem, extra, this.folderName);
    }

    private void doTransformations() {
        GL11.glTranslatef((float)(-(this.largeIconScale - 1.0f) / 2.0f), (float)(-(this.largeIconScale - 1.0f) / 2.0f), (float)0.0f);
        GL11.glScalef((float)this.largeIconScale, (float)this.largeIconScale, (float)1.0f);
    }

    public void renderLargeItem() {
        this.renderLargeItem(null);
    }

    public void renderLargeItem(String extra) {
        this.doTransformations();
        ResourceLocation res = extra == null ? this.largeTexture : this.getSubtypeTexture(extra);
        Minecraft.getMinecraft().getTextureManager().bindTexture(res);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        Tessellator tessellator = Tessellator.instance;
        ItemRenderer.renderItemIn2D((Tessellator)tessellator, (float)1.0f, (float)0.0f, (float)0.0f, (float)1.0f, (int)this.largeIconSize, (int)this.largeIconSize, (float)0.0625f);
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack itemstack, Object ... data) {
        EntityLivingBase entityliving;
        GL11.glPushMatrix();
        Entity holder = (Entity)data[1];
        boolean isFirstPerson = holder == Minecraft.getMinecraft().thePlayer && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0;
        Item item = itemstack.getItem();
        if (item instanceof LOTRItemSpear && holder instanceof EntityPlayer && ((EntityPlayer)holder).getItemInUse() == itemstack) {
            GL11.glRotatef((float)260.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glTranslatef((float)-1.0f, (float)0.0f, (float)0.0f);
        }
        if (item instanceof LOTRItemPike && holder instanceof EntityLivingBase && (entityliving = (EntityLivingBase)holder).getHeldItem() == itemstack && entityliving.swingProgress <= 0.0f) {
            if (entityliving.isSneaking()) {
                if (isFirstPerson) {
                    GL11.glRotatef((float)270.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glTranslatef((float)-1.0f, (float)0.0f, (float)0.0f);
                } else {
                    GL11.glTranslatef((float)0.0f, (float)-0.1f, (float)0.0f);
                    GL11.glRotatef((float)20.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                }
            } else if (!isFirstPerson) {
                GL11.glTranslatef((float)0.0f, (float)-0.3f, (float)0.0f);
                GL11.glRotatef((float)40.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            }
        }
        if (item instanceof LOTRItemLance && holder instanceof EntityLivingBase && (entityliving = (EntityLivingBase)holder).getHeldItem() == itemstack) {
            if (isFirstPerson) {
                GL11.glRotatef((float)260.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glTranslatef((float)-1.0f, (float)0.0f, (float)0.0f);
            } else {
                GL11.glTranslatef((float)0.7f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)-30.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glTranslatef((float)-1.0f, (float)0.0f, (float)0.0f);
            }
        }
        this.renderLargeItem();
        if (itemstack != null && itemstack.hasEffect(0)) {
            LOTRClientProxy.renderEnchantmentEffect();
        }
        GL11.glPopMatrix();
    }

    static {
        sizeFolders.put("large", Float.valueOf(2.0f));
        sizeFolders.put("large2", Float.valueOf(3.0f));
        largeItemTextures = new HashMap<Pair<Item, String>, ResourceLocation>();
    }
    
    

    public boolean handleRenderType(ItemStack itemstack, IItemRenderer.ItemRenderType type) {
        return type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack itemstack, IItemRenderer.ItemRendererHelper helper) {
        return false;
    }

   

    static {
        sizeFolders.put("large", Float.valueOf(2.0f));
        sizeFolders.put("large2", Float.valueOf(3.0f));
        largeItemTextures = new HashMap<Pair<Item, String>, ResourceLocation>();
    }
}

