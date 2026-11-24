package quest.nekoniyah.empyriumdifficulty.difficulty

import com.mojang.serialization.Codec
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate
import net.fabricmc.fabric.api.attachment.v1.AttachmentType
import net.minecraft.network.codec.ByteBufCodecs
import quest.nekoniyah.empyriumdifficulty.EmpyriumDifficultyMod

class DifficultyAttachments {
    var DIFFICULTY: AttachmentType<String> =
        AttachmentRegistry.create(EmpyriumDifficultyMod.id("difficulty")) { builder ->
            builder.initializer {
                "none"
            }.syncWith(
                ByteBufCodecs.STRING_UTF8, AttachmentSyncPredicate.all()
            ).persistent(Codec.STRING).copyOnDeath()
        }
}