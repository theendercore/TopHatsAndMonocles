package com.theendercore.top_hats_and_monocles.mixin.client;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.theendercore.top_hats_and_monocles.TopHatsAndMonocles.log;

@Mixin(Minecraft.class)
public class ExampleMixin {

    @Inject(method = "run", at = @At("HEAD"))
    private void run(CallbackInfo info) {
        log.info("Hello from Mixin");
    }

}
