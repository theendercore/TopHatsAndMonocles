package com.theendercore.top_hats_and_monocles.datagen

import com.theendercore.top_hats_and_monocles.TopHatsAndMonocles
import com.theendercore.top_hats_and_monocles.TopHatsAndMonocles.log
import com.theendercore.top_hats_and_monocles.datagen.assets.EnLangProvider
import com.theendercore.top_hats_and_monocles.datagen.assets.ModelProvider
import com.theendercore.top_hats_and_monocles.datagen.data.registry.BannerPatterns
import com.theendercore.top_hats_and_monocles.datagen.data.tags.BannerPatternTagsProvider
import com.theendercore.top_hats_and_monocles.datagen.data.tags.BlockTagsProvider
import com.theendercore.top_hats_and_monocles.datagen.data.tags.ItemTagsProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.Holder
import net.minecraft.core.HolderLookup
import net.minecraft.core.HolderLookup.RegistryLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import java.util.concurrent.CompletableFuture

object TopHatsAndMonoclesData : DataGeneratorEntrypoint {

    override fun getEffectiveModId(): String = TopHatsAndMonocles.MODID

    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        val pack = gen.createPack()
        log.info("Running \"${gen.modContainer.metadata.name}\" Datagen!")

        // Assets
        pack.addProvider(::EnLangProvider)
        pack.addProvider(::ModelProvider)
        // Data
        pack.addProvider(::RegistryProvider)
        val blockTags = pack.addProvider(::BlockTagsProvider)
        pack.addProvider { o, f -> ItemTagsProvider(o, f, blockTags) }
        pack.addProvider(::BannerPatternTagsProvider)
//        pack.addProvider(::RecipeProvider)
    }

    override fun buildRegistry(gen: RegistrySetBuilder) {
        gen.add(Registries.BANNER_PATTERN, BannerPatterns::bootstrap)
    }

    class RegistryProvider(o: FabricDataOutput, p: CompletableFuture<HolderLookup.Provider>) :
        FabricDynamicRegistryProvider(o, p) {

        override fun getName(): String = "Registry Gen"

        override fun configure(provider: HolderLookup.Provider, entries: Entries) {
            entries.addAll(provider.lookupOrThrow(Registries.BANNER_PATTERN))
        }

        fun <T : Any> Entries.addEverything(registry: RegistryLookup<T>): MutableList<Holder<T>> {
            return registry.listElementIds().map { add(registry, it) }.toList()
        }

    }
}