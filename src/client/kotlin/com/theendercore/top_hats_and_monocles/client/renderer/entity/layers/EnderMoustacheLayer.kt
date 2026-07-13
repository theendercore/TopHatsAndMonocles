package com.theendercore.top_hats_and_monocles.client.renderer.entity.layers

import com.mojang.blaze3d.vertex.PoseStack
import com.theendercore.top_hats_and_monocles.TopHatsAndMonocles.id
import com.theendercore.top_hats_and_monocles.client.TopHatsAndMonoclesClient.MOUSTACHE_KEY
import com.theendercore.top_hats_and_monocles.client.model.player.EnderMoustacheModel
import net.minecraft.client.model.geom.EntityModelSet
import net.minecraft.client.model.player.PlayerModel
import net.minecraft.client.renderer.SubmitNodeCollector
import net.minecraft.client.renderer.entity.LivingEntityRenderer
import net.minecraft.client.renderer.entity.RenderLayerParent
import net.minecraft.client.renderer.entity.layers.RenderLayer
import net.minecraft.client.renderer.entity.state.AvatarRenderState
import net.minecraft.client.renderer.rendertype.RenderTypes

class EnderMoustacheLayer(parent: RenderLayerParent<AvatarRenderState, PlayerModel>, modelSet: EntityModelSet) :
    RenderLayer<AvatarRenderState, PlayerModel>(parent) {

    val model = EnderMoustacheModel(modelSet.bakeLayer(EnderMoustacheModel.ID))

    override fun submit(
        poseStack: PoseStack,
        collector: SubmitNodeCollector,
        lightCoords: Int,
        state: AvatarRenderState,
        yRot: Float, xRot: Float,
    ) {
        if (state.getDataOrDefault(MOUSTACHE_KEY, false) && !state.isInvisible) {
            val overlay = LivingEntityRenderer.getOverlayCoords(state, 0.0f)
            collector.submitModel(
                model, state, poseStack,
                RenderTypes.entityCutoutNoCull(TEXTURE),
                lightCoords, overlay, state.outlineColor, null
            )
        }
    }

    companion object {
        val TEXTURE = id("textures/entity/moustache/ender_moustache.png")
    }
}