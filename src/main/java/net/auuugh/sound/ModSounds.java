package net.auuugh.sound;

import net.auuugh.DeadpoolInYourArea;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent DEADPOOL_SFX = registerSoundEvent("dp_sfx1");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(DeadpoolInYourArea.MOD_ID, name);
        return  Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void register() {}
}
