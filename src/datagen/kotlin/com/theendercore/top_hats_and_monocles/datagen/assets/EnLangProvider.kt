package com.theendercore.top_hats_and_monocles.datagen.assets

import com.theendercore.top_hats_and_monocles.data.registry.TnMBannerPatterns
import com.theendercore.top_hats_and_monocles.data.registry.TnMBannerPatterns.patternLang
import com.theendercore.top_hats_and_monocles.util.getModHolders
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.core.Holder
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.DyeColor
import java.util.concurrent.CompletableFuture

class EnLangProvider(var output: FabricDataOutput, p: CompletableFuture<HolderLookup.Provider>) :
    FabricLanguageProvider(output, p) {

    override fun generateTranslations(lookup: HolderLookup.Provider, gen: TranslationBuilder) {
        getModHolders(BuiltInRegistries.ITEM).forEach { gen.add(it.value(), genLang(it)) }
        getModHolders(BuiltInRegistries.BLOCK).forEach { trySafe { gen.add(it.value(), genLang(it)) } }

        listOf(TnMBannerPatterns.MUSTACHE).forEach {
            val lang = patternLang(it)
            val tex = genLang(it)
            gen.add(lang, tex)
            for (color in DyeColor.entries) {
                val name = color.getName()
                gen.add("$lang.$name", "${genLang(name)} $tex")
            }
        }
    }

    fun genLang(holder: Holder.Reference<*>): String = genLang(holder.key())
    fun genLang(key: ResourceKey<*>): String = genLang(key.identifier())
    fun genLang(id: Identifier): String = genLang(id.path)
    fun genLang(str: String) = str.split("_").joinToString(" ") { it.replaceFirstChar(Char::uppercaseChar) }

    fun trySafe(fn: () -> Unit) {
        try {
            fn()
        } catch (e: Exception) {
            if (output.isStrictValidationEnabled) {
                LOGGER.warn("Exception found when lang gen: ", e)
            }
        }
    }

}