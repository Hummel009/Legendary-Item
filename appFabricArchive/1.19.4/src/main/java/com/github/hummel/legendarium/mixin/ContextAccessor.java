package com.github.hummel.legendarium.mixin;

import net.fabricmc.fabric.impl.client.indigo.renderer.render.ItemRenderContext;
import net.minecraft.world.item.ItemDisplayContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemRenderContext.class)
public interface ContextAccessor {
	@Accessor
	ItemDisplayContext getTransformMode();
}