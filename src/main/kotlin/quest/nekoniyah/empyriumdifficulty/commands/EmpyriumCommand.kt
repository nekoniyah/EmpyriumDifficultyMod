package quest.nekoniyah.empyriumdifficulty.commands

import com.mojang.brigadier.builder.LiteralArgumentBuilder
import net.minecraft.commands.CommandSourceStack

class EmpyriumCommand(subcommands: List<SubcommandHolder>) {
    var command: LiteralArgumentBuilder<CommandSourceStack?>? =
        LiteralArgumentBuilder.literal<CommandSourceStack>("empyrium").also {
            subcommands.forEach { sc -> it.then(sc.command()) }
        }
}