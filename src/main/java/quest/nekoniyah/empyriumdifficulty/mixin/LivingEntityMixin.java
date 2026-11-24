package quest.nekoniyah.empyriumdifficulty.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import quest.nekoniyah.empyriumdifficulty.EmpyriumDifficultyMod;

import java.util.Objects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(method = "dropAllDeathLoot", at = @At("HEAD"), cancellable = true)
    private void onDropAtDeath(ServerLevel serverLevel, DamageSource damageSource, CallbackInfo ci) {
        if ((Object) this instanceof Player) {
            String difficulty = ((Player) (Object) this).getAttached(EmpyriumDifficultyMod.INSTANCE.getDifficulty().getAttachments().getDIFFICULTY());
            if (Objects.equals(difficulty, "safe")) ci.cancel();
        }
    }
}
