package net.auuugh.gamerule;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ModGamerule {
    //Gamerule
    public static final GameRules.Key<GameRules.BooleanRule> DEADPOOLS_CHALLENGE = GameRuleRegistry
            .register("deadpoolsChallenge", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(false));

    public static void register() {}
}
