package com.theendercore.top_hats_and_monocles.data.tags

import net.minecraft.core.registries.Registries
import com.theendercore.top_hats_and_monocles.TopHatsAndMonocles.id
import com.theendercore.top_hats_and_monocles.util.tag

object TnMItemTags {

    val APPLE_LIKE = create("apple_like")

    fun create(id: String) = Registries.ITEM.tag(id(id))

}