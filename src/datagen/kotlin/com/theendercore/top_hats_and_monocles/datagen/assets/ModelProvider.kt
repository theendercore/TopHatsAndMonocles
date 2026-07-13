package com.theendercore.top_hats_and_monocles.datagen.assets


import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.model.ModelTemplates
import net.minecraft.world.level.ItemLike

class ModelProvider(o: FabricDataOutput) : FabricModelProvider(o) {

    override fun generateBlockStateModels(gen: BlockModelGenerators) {
//        gen.createTrivialCube(TnMBlocks.APPLE_BLOCK)
    }

    val single = listOf<ItemLike>()

    override fun generateItemModels(gen: ItemModelGenerators) {
        single.forEach { gen.generateFlatItem(it.asItem(), ModelTemplates.FLAT_ITEM) }
    }

}