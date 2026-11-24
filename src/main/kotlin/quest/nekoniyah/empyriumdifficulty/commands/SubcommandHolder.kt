package quest.nekoniyah.empyriumdifficulty.commands

import com.mojang.brigadier.builder.ArgumentBuilder
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.context.CommandContext
import net.minecraft.commands.CommandSourceStack
import net.minecraft.commands.Commands

abstract class SubcommandHolder(val name: String) {

    abstract fun subcommands(): List<ArgumentBuilder<CommandSourceStack, *>>
    abstract fun execute(ctx: CommandContext<CommandSourceStack>): Int

    fun command(): LiteralArgumentBuilder<CommandSourceStack?>? {
        return Commands.literal(name).executes(::execute).also {
            for (subcommand in subcommands()) it.then(subcommand)
        }
    }
}