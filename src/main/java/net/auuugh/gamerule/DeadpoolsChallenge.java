package net.auuugh.gamerule;

import net.auuugh.DeadpoolInYourArea;
import net.auuugh.effect.ModEffects;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.TypeFilter;
import net.minecraft.world.level.*;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.minecraft.world.GameRules;

import java.util.List;

public class DeadpoolsChallenge {
    private static int tickCounter = 0;
    private static boolean activateEff = false;

    public static void dpChallengeEffect() {
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            //ServerWorld serverLevel = server.getOverworld();

            if (world != null) {
                activateEff = world.getGameRules().getBoolean(ModGamerule.DEADPOOLS_CHALLENGE);
                StatusEffectInstance applyEff = new StatusEffectInstance(ModEffects.DP_AOE_2, 5000, 0);

                if (activateEff) {
                    //DeadpoolInYourArea.LOGGER.info("I ran :D");
                    for (ServerWorld serverWorld : world.getServer().getWorlds()) {
                        tickCounter++;
                        if (tickCounter % 100 == 0) {
                            //code that totally works goes here
                            world.getEntitiesByType(TypeFilter.instanceOf(HostileEntity.class), hostile -> true)
                                    .forEach(hostileMob -> {
                                        hostileMob.addStatusEffect(applyEff);
                                    });
                            activateEff = true;
                            tickCounter = 0;
                            //DeadpoolInYourArea.LOGGER.info("I ran :D");
                        }
                    }
                } else {
                    activateEff = false;
                    tickCounter = 0;
                }
            }
        });
    }

    public static void register() {
        dpChallengeEffect();
    }
}
