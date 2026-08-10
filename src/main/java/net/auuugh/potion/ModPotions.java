package net.auuugh.potion;

import net.auuugh.DeadpoolInYourArea;
import net.auuugh.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {

    public static final RegistryEntry<Potion> DEADPOOL_POTION = registerPotion("deadpool_potion", new Potion(new StatusEffectInstance(ModEffects.DP_AOE, 3600, 0, false, true)));

    public static final RegistryEntry<Potion> PWNED_DEADPOOL_POTION = registerPotion("pwned_deadpool_potion", new Potion(new StatusEffectInstance(ModEffects.DP_CLUTTER, 200, 0, false, true)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(DeadpoolInYourArea.MOD_ID, name), potion);
    }

    public static void register() {}
}
