package com.theendercore.top_hats_and_monocles.client

import com.theendercore.top_hats_and_monocles.TopHatsAndMonocles.MODID
import com.theendercore.top_hats_and_monocles.client.config.TopHatsAndMonoclesClientConfig
import com.theendercore.top_hats_and_monocles.client.model.player.EnderMoustacheModel
import com.theendercore.top_hats_and_monocles.client.renderer.entity.layers.EnderMoustacheLayer
import com.theendercore.top_hats_and_monocles.util.isDev
import com.theendercore.top_hats_and_monocles.util.isEnder
import me.fzzyhmstrs.fzzy_config.api.ConfigApi
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback
import net.fabricmc.fabric.api.client.rendering.v1.RenderStateDataKey
import net.minecraft.client.model.player.PlayerModel
import net.minecraft.client.renderer.entity.RenderLayerParent
import net.minecraft.client.renderer.entity.state.AvatarRenderState
import net.minecraft.world.entity.Avatar
import net.minecraft.world.entity.EntityType

object TopHatsAndMonoclesClient {

    @JvmField
    val MOUSTACHE_KEY = RenderStateDataKey.create<Boolean> { "$MODID:moustache" }

    @JvmField
    var clientConfig = ConfigApi.registerAndLoadConfig(::TopHatsAndMonoclesClientConfig)

    fun init() {
        EntityModelLayerRegistry.registerModelLayer(EnderMoustacheModel.ID, EnderMoustacheModel::layer)
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register { type, renderer, helper, context ->
            if (type == EntityType.PLAYER || type == EntityType.MANNEQUIN) {
                @Suppress("UNCHECKED_CAST")
                helper.register(
                    EnderMoustacheLayer(renderer as RenderLayerParent<AvatarRenderState, PlayerModel>, context.modelSet)
                )
            }
        }
    }

    @JvmStatic
    fun isEnderC(player: Avatar) = isEnder(player) || (clientConfig.renderStashInDev && isDev())

}