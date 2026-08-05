package net.auuugh;

import net.auuugh.client.DisplayScreen;
import net.auuugh.client.DisplayScreenTick;
import net.auuugh.common.EffectChecker;
import net.auuugh.effect.ModEffects;
import net.fabricmc.api.ModInitializer;

import net.minecraft.block.Portal;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeadpoolInYourArea implements ModInitializer {
	public static final String MOD_ID = "dp-clutter";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Does a lord icon do bonus damage?");
		EffectChecker.register();
		DisplayScreenTick.register();
		DisplayScreen.register();
		ModEffects.register();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
