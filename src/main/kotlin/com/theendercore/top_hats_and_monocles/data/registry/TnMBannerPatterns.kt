package com.theendercore.top_hats_and_monocles.data.registry

import com.theendercore.top_hats_and_monocles.TopHatsAndMonocles.id
import com.theendercore.top_hats_and_monocles.util.key
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.block.entity.BannerPattern

object TnMBannerPatterns {

    val MUSTACHE = create("mustache")

    fun create(id: String) = Registries.BANNER_PATTERN.key(id(id))

    fun patternLang(key: ResourceKey<BannerPattern>): String = "block.minecraft.banner.${key.identifier().toLanguageKey()}"

}