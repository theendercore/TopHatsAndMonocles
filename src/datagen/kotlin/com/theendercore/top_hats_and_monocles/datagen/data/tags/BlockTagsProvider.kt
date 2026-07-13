package com.theendercore.top_hats_and_monocles.datagen.data.tags

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.BlockTagProvider
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Blocks
import com.theendercore.top_hats_and_monocles.data.tags.TnMBlockTags
import com.theendercore.top_hats_and_monocles.init.TnMBlocks
import java.util.concurrent.CompletableFuture

class BlockTagsProvider(o: FabricDataOutput, p: CompletableFuture<HolderLookup.Provider>) : BlockTagProvider(o, p) {

    override fun addTags(lookup: HolderLookup.Provider) {
//        valueLookupBuilder(BlockTags.LOGS)
//            .add(TnMBlocks.SPECIAL_APPLE_BLOCK)

//        valueLookupBuilder(TnMBlockTags.APPLE_LIKE)
//            .add(TnMBlocks.APPLE_BLOCK, Blocks.RED_TERRACOTTA)

//        valueLookupBuilder(ConventionalBlockTags.STORAGE_BLOCKS)
//            .forceAddTag(TnMBlockTags.APPLE_LIKE)
    }

}