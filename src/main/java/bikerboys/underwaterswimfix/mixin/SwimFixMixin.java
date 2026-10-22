package bikerboys.underwaterswimfix.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.*;
import com.mojang.datafixers.util.*;

import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.logging.*;

@Mixin(Player.class)
public abstract class SwimFixMixin extends LivingEntity {

    protected SwimFixMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }



    @WrapOperation(method = "causeExtraKnockback", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;setSprinting(Z)V"))
    private void onAttackEntity(Player instance, boolean b, Operation<Void> original) {
        if (instance.isSwimming()) {

        } else {
            original.call(instance, b);
        }
    }
}
