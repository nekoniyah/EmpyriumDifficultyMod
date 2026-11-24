package quest.nekoniyah.empyriumdifficulty

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import quest.nekoniyah.empyriumdifficulty.commands.EmpyriumCommand
import quest.nekoniyah.empyriumdifficulty.difficulty.DifficultyAttachments
import quest.nekoniyah.empyriumdifficulty.difficulty.EmpyriumDifficulty

object EmpyriumDifficultyMod : ModInitializer {
    const val MOD_ID: String = "empyrium-mod"

    @JvmField
    val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

    val difficulty = EmpyriumDifficulty(DifficultyAttachments())

    override fun onInitialize() {
        difficulty.register()

        CommandRegistrationCallback.EVENT.register { dispatcher, _, _ ->
            dispatcher.register(EmpyriumCommand(listOf(difficulty)).command)
        }
    }

    fun id(name: String): ResourceLocation = ResourceLocation.fromNamespaceAndPath(MOD_ID, name)
}
