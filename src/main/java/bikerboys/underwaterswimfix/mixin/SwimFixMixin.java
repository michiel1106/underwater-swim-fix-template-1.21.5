package bikerboys.underwaterswimfix.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.*;
import com.mojang.datafixers.util.Either;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Unit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public abstract class SwimFixMixin extends LivingEntity {

    @Shadow
    public abstract Either<PlayerEntity.SleepFailureReason, Unit> trySleep(BlockPos pos);

    protected SwimFixMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }



    @WrapOperation(method = "knockbackTarget", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;setSprinting(Z)V"))
    private void onAttackEntity(PlayerEntity instance, boolean b, Operation<Void> original) {
        if (instance.isSwimming()) {

        } else {
            original.call(instance, b);
        }
    }
}
