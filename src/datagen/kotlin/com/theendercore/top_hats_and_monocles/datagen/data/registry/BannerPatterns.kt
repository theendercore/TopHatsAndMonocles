package com.theendercore.top_hats_and_monocles.datagen.data.registry

import com.theendercore.top_hats_and_monocles.data.registry.TnMBannerPatterns
import com.theendercore.top_hats_and_monocles.data.registry.TnMBannerPatterns.patternLang
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.block.entity.BannerPattern

object BannerPatterns : RegistryBootstrapper<BannerPattern> {

    override fun BootstrapContext<BannerPattern>.init() {
        pattern(TnMBannerPatterns.MUSTACHE)
    }

    fun BootstrapContext<BannerPattern>.pattern(key: ResourceKey<BannerPattern>) {
        register(key, BannerPattern(key.identifier(), patternLang(key)))
    }

}