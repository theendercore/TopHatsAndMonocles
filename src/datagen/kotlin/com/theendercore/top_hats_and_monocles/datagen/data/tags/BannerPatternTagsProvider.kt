package com.theendercore.top_hats_and_monocles.datagen.data.tags

import com.theendercore.top_hats_and_monocles.data.registry.TnMBannerPatterns
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.tags.BannerPatternTags
import net.minecraft.world.level.block.entity.BannerPattern
import java.util.concurrent.CompletableFuture

class BannerPatternTagsProvider(o: FabricDataOutput, p: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider<BannerPattern>(o, Registries.BANNER_PATTERN, p) {

    override fun addTags(lookup: HolderLookup.Provider) {

        builder(BannerPatternTags.NO_ITEM_REQUIRED)
            .add(TnMBannerPatterns.MUSTACHE)
    }

}