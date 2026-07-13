package com.theendercore.top_hats_and_monocles

import me.fzzyhmstrs.fzzy_config.api.ConfigApi
import net.minecraft.resources.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.theendercore.top_hats_and_monocles.config.TopHatsAndMonoclesConfig
import com.theendercore.top_hats_and_monocles.init.TnMBlocks
import com.theendercore.top_hats_and_monocles.init.TnMItems

object TopHatsAndMonocles {

    const val MODID = "top_hats_and_monocles"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(TopHatsAndMonocles::class.simpleName)

    @JvmField
    var config = ConfigApi.registerAndLoadConfig(::TopHatsAndMonoclesConfig)

    fun init() {
        log.info("Hello from Common ${config.commonEntry.get()}")
        TnMItems.init()
        TnMBlocks.init()
    }

    fun id(namespace: String, path: String): Identifier = Identifier.fromNamespaceAndPath(namespace, path)
    fun mc(path: String): Identifier = Identifier.withDefaultNamespace(path)
    fun id(path: String) = id(MODID, path)

}