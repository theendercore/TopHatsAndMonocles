package com.theendercore.top_hats_and_monocles.client.model.player

import net.minecraft.client.model.geom.ModelLayerLocation
import net.minecraft.client.model.geom.ModelPart
import net.minecraft.client.model.geom.PartPose
import net.minecraft.client.model.geom.builders.CubeDeformation
import net.minecraft.client.model.geom.builders.CubeListBuilder
import net.minecraft.client.model.geom.builders.LayerDefinition
import net.minecraft.client.model.player.PlayerModel
import com.theendercore.top_hats_and_monocles.TopHatsAndMonocles.id

class EnderMoustacheModel(root: ModelPart) : PlayerModel(root, true) {

    val moustache: ModelPart = root.getChild("head").getChild(STASH_KEY)

    companion object {
        const val STASH_KEY = "moustache"
        val ID = ModelLayerLocation(id("ender_moustache"), "main")

        fun layer(): LayerDefinition {
            val mesh = createMesh(CubeDeformation.NONE, true)
            val root = mesh.root.clearRecursively()
            val head = root.getChild("head")

            head.addOrReplaceChild(
                STASH_KEY,
                CubeListBuilder.create()
                    .texOffs(0, 0)
                    .addBox(-7.0f, -27.0f, -4.05f, 14.0f, 5.0f, 0.0f),
                PartPose.offset(0.0f, 24.0f, 0.0f)
            )

            return LayerDefinition.create(mesh, 32, 32)
        }

    }
}