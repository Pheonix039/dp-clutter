package net.auuugh.effect;

import net.auuugh.DeadpoolInYourArea;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> DP_CLUTTER = registerStatusEffect("dp_clutter", new DeadpoolEffect(StatusEffectCategory.BENEFICIAL, 0x8b1a1a));

    public static final RegistryEntry<StatusEffect> DP_AOE = registerStatusEffect("dp_aoe", new DeadpoolAreaEffect(StatusEffectCategory.BENEFICIAL, 0x8b1a1a));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String id, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(DeadpoolInYourArea.MOD_ID, id), effect);
    }

    public static void register() {}
}
