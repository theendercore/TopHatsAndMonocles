package com.theendercore.top_hats_and_monocles.datagen.data.tags

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.ItemTagProvider
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags
import net.minecraft.core.HolderLookup
import net.minecraft.tags.ItemTags
import com.theendercore.top_hats_and_monocles.data.tags.TnMBlockTags
import com.theendercore.top_hats_and_monocles.data.tags.TnMItemTags
import com.theendercore.top_hats_and_monocles.init.TnMBlocks
import com.theendercore.top_hats_and_monocles.init.TnMItems
import java.util.concurrent.CompletableFuture

class ItemTagsProvider(o: FabricDataOutput, p: CompletableFuture<HolderLookup.Provider>, blockTag: BlockTagProvider) :
    ItemTagProvider(o, p, blockTag) {

    override fun addTags(lookup: HolderLookup.Provider) {
//        copy(TnMBlockTags.APPLE_LIKE, TnMItemTags.APPLE_LIKE)

//        valueLookupBuilder(ItemTags.SWORDS)
//            .add(TnMBlocks.APPLE_BLOCK.asItem())
//        valueLookupBuilder(TnMItemTags.APPLE_LIKE)
//            .add(TnMItems.APPLE_2)
//        valueLookupBuilder(ConventionalItemTags.HIDDEN_FROM_RECIPE_VIEWERS)
//            .add(TnMItems.APPLE_2)
    }

}