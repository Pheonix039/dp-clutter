package net.auuugh.client;

import net.auuugh.DeadpoolInYourArea;
import net.auuugh.effect.ModEffects;
import net.auuugh.sound.ModSounds;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundCategory;

public class PlaySound implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (MinecraftClient.getInstance().world != null && client != null) {
                if (client.player.hasStatusEffect(ModEffects.DP_CLUTTER)) {
                    if (DisplayMath.getSfxCounter() == 0) {
                        //DeadpoolInYourArea.LOGGER.info("I ran :D");

                    }
                    //DeadpoolInYourArea.LOGGER.info("sfxCounter: " + DisplayMath.getSfxCounter());
                    switch (DisplayMath.getSfxCounter()) {
                        case 0:
                            MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(ModSounds.DP_SFX1, 1.0f, 1.0f));
                            break;
                        case 100:
                            MinecraftClient.getInstance().getSoundManager().stopSounds(ModSounds.DP_SFX1.getId(), SoundCategory.MASTER);
                            DisplayMath.setSfxCounter(-1);
                            break;
                    }
                } else {
                    MinecraftClient.getInstance().getSoundManager().stopSounds(ModSounds.DP_SFX1.getId(), SoundCategory.MASTER);
                }
            }
        });
    }
}
