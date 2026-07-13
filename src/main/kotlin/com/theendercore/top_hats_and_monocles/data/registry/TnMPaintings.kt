package com.theendercore.top_hats_and_monocles.data.registry

import net.minecraft.core.registries.Registries
import com.theendercore.top_hats_and_monocles.TopHatsAndMonocles
import com.theendercore.top_hats_and_monocles.util.key

object TnMPaintings {

    val APPLE_PAINT = create("apple_paint")

    fun create(id: String) = Registries.PAINTING_VARIANT.key(TopHatsAndMonocles.id(id))

}