package com.theendercore.top_hats_and_monocles.init

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.Item
import com.theendercore.top_hats_and_monocles.TopHatsAndMonocles.id
import com.theendercore.top_hats_and_monocles.util.getModEntries
import com.theendercore.top_hats_and_monocles.util.register

object TnMItems {

    val ITEMS get() = getModEntries(BuiltInRegistries.ITEM)

//    val APPLE_2 = register("apple_2", Item(Properties().rarity(Rarity.RARE)))

    fun init() = Unit

    fun register(id: String, item: Item): Item = BuiltInRegistries.ITEM.register(id(id), item)

}