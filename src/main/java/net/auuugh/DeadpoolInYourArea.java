package net.auuugh;

import net.auuugh.effect.ModEffects;
import net.auuugh.gamerule.DeadpoolsChallenge;
import net.auuugh.gamerule.ModGamerule;
import net.auuugh.potion.ModPotions;
import net.auuugh.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
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

		//client
		//DisplayMath.register();
		//DisplayScreen.register();
		//PlaySound.register();

		//server
		ModEffects.register();
		ModSounds.register();
		ModPotions.register();
		ModGamerule.register();
		DeadpoolsChallenge.register();

		//Potion recipe
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.ROTTEN_FLESH, ModPotions.DEADPOOL_POTION);
		});

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(ModPotions.DEADPOOL_POTION, Items.FERMENTED_SPIDER_EYE, ModPotions.PWNED_DEADPOOL_POTION);
		});
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
