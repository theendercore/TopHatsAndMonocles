package com.theendercore.top_hats_and_monocles.mixin.client;

import net.minecraft.client.entity.ClientAvatarEntity;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.theendercore.top_hats_and_monocles.client.TopHatsAndMonoclesClient.MOUSTACHE_KEY;
import static com.theendercore.top_hats_and_monocles.client.TopHatsAndMonoclesClient.isEnderC;


@Mixin(AvatarRenderer.class)
public class AvatarRendererMixin<AvatarLikeEntity extends Avatar & ClientAvatarEntity> {

    @Inject(
            method = "extractRenderState(Lnet/minecraft/world/entity/Avatar;Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;F)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/ClientAvatarEntity;showExtraEars()Z")
    )
    void extractMoustacheState(AvatarLikeEntity avatar, AvatarRenderState state, float f, CallbackInfo ci) {
        state.setData(MOUSTACHE_KEY, isEnderC(avatar));
    }
}
