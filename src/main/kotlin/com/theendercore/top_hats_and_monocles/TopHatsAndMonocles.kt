package com.theendercore.top_hats_and_monocles

import com.theendercore.top_hats_and_monocles.init.TnMBlocks
import com.theendercore.top_hats_and_monocles.init.TnMItems
import net.minecraft.resources.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object TopHatsAndMonocles {

    const val MODID = "top_hats_and_monocles"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(TopHatsAndMonocles::class.simpleName)

//    @JvmField
//    var config = ConfigApi.registerAndLoadConfig(::TopHatsAndMonoclesConfig)

    fun init() {
        log.info("A hat on top?")
        TnMItems.init()
        TnMBlocks.init()
    }

    fun id(namespace: String, path: String): Identifier = Identifier.fromNamespaceAndPath(namespace, path)
    fun mc(path: String): Identifier = Identifier.withDefaultNamespace(path)
    fun id(path: String) = id(MODID, path)

}