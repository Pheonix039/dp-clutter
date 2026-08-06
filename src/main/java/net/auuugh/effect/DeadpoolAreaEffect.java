package net.auuugh.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;

import java.util.List;

public class DeadpoolAreaEffect extends StatusEffect {
    protected DeadpoolAreaEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        //if anyone gets within 5 blocks of someone with the effect they get the screen clutter
        //return super.applyUpdateEffect(entity, amplifier);
        Box aoeRadius = entity.getBoundingBox().expand(3, 1, 3);
        List<PlayerEntity> nearbyPlayers = entity.getWorld().getEntitiesByClass(
                PlayerEntity.class,
                aoeRadius,
                player -> player != entity
        );

        for (PlayerEntity nearbyPlayer : nearbyPlayers) {
            nearbyPlayer.addStatusEffect(new StatusEffectInstance(ModEffects.DP_CLUTTER, 5, amplifier, false, false));
        }
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
