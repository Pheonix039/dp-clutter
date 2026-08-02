package net.auuugh.client;

import net.auuugh.DeadpoolInYourArea;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;


import java.util.concurrent.atomic.AtomicInteger;

public class DisplayScreen {
    //Aww! Look at all the widdle Wades!
    private static final Identifier dpBigTex = Identifier.of(DeadpoolInYourArea.MOD_ID + ":textures/clutter/dp-big.png");
    private static final Identifier dpBigTexFlipped = Identifier.of(DeadpoolInYourArea.MOD_ID + ":textures/clutter/flipped/dp-big-flipped.png");
    private static final Identifier dpRocketTex = Identifier.of(DeadpoolInYourArea.MOD_ID + ":textures/clutter/dp-rocket.png");
    private static final Identifier dpRocketTexFlipped = Identifier.of(DeadpoolInYourArea.MOD_ID + ":textures/clutter/flipped/dp-rocket-flipped.png");
    private static final Identifier dpRunTex = Identifier.of(DeadpoolInYourArea.MOD_ID + ":textures/clutter/dp-run.png");
    private static final Identifier dpScooterTex = Identifier.of(DeadpoolInYourArea.MOD_ID + ":textures/clutter/dp-scooter.png");
    private static final Identifier dpTapeTex = Identifier.of(DeadpoolInYourArea.MOD_ID + ":textures/clutter/dp-tape.png");

    //private static AtomicInteger winWidth = new AtomicInteger();
    //private static AtomicInteger winHeight = new AtomicInteger();
    //private static MinecraftClient client = MinecraftClient.getInstance();



    public static void register() {
        MinecraftClient client = MinecraftClient.getInstance();

        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            if (MinecraftClient.getInstance().world != null && client != null) {
                //renders
                displayDPBig(drawContext, DisplayScreenTick.getDPBigY1());
                displayDPBigFlipped(drawContext, DisplayScreenTick.getDPBigY2());

                displayDPTape(drawContext, DisplayScreenTick.getDpTapeX());

                displayDPRocket(drawContext, DisplayScreenTick.getDpRocketX(),  DisplayScreenTick.getDpRocketY());
                displayDPRocketFlipped(drawContext, DisplayScreenTick.getDpRocketX2(),  DisplayScreenTick.getDpRocketY2());

                displayDPScooter(drawContext, DisplayScreenTick.getDpScooterX(), DisplayScreenTick.getDpScooterY());
                displayDPRun(drawContext, DisplayScreenTick.getDpRunX(), DisplayScreenTick.getDpRunY());

            }
        });


    }

    public static void displayDPBig(DrawContext drawContext, double y) {
        //DeadpoolInYourArea.LOGGER.info("Who's the man? Wade is! ");
        AtomicInteger winWidth = new AtomicInteger();
        AtomicInteger winHeight = new AtomicInteger();
        MinecraftClient client = MinecraftClient.getInstance();

        if (MinecraftClient.getInstance().world != null && client != null) {
            winWidth.set(client.getWindow().getScaledWidth());
            winHeight.set(client.getWindow().getScaledHeight());
            int x = winWidth.get() - 128;

            drawContext.drawTexture(
                    dpBigTex,
                    x, (int) y,
                    0f, 0f,
                    128, 128,
                    128, 128
            );
        }
    }

    public static void displayDPBigFlipped(DrawContext drawContext, double y) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (MinecraftClient.getInstance().world != null && client != null) {

            drawContext.drawTexture(
                    dpBigTexFlipped,
                    0, (int) y,
                    0f, 0f,
                    128, 128,
                    128, 128
            );
        }
    }

    public static void displayDPTape(DrawContext drawContext, int movementX) {
        AtomicInteger winWidth = new AtomicInteger();
        AtomicInteger winHeight = new AtomicInteger();
        MinecraftClient client = MinecraftClient.getInstance();

        if (MinecraftClient.getInstance().world != null && client != null) {
            winWidth.set(client.getWindow().getScaledWidth());
            winHeight.set(client.getWindow().getScaledHeight());

            drawContext.drawTexture(
                    dpTapeTex,
                    movementX, winHeight.get() - 64,
                    0f, 0f,
                    496, 64,
                    496, 64
            );
        }
    }

    public static void displayDPRocket(DrawContext drawContext, int movementX, int movementY) {
        AtomicInteger winWidth = new AtomicInteger();
        AtomicInteger winHeight = new AtomicInteger();
        MinecraftClient client = MinecraftClient.getInstance();

        if (MinecraftClient.getInstance().world != null && client != null) {
            winWidth.set(client.getWindow().getScaledWidth());
            winHeight.set(client.getWindow().getScaledHeight());

            drawContext.drawTexture(
                    dpRocketTex,
                    movementX, movementY,
                    0f, 0f,
                    64, 64,
                    64, 64
            );
        }
    }

    public static void displayDPRocketFlipped(DrawContext drawContext, int movementX, int movementY) {
        AtomicInteger winWidth = new AtomicInteger();
        AtomicInteger winHeight = new AtomicInteger();
        MinecraftClient client = MinecraftClient.getInstance();

        if (MinecraftClient.getInstance().world != null && client != null) {
            winWidth.set(client.getWindow().getScaledWidth());
            winHeight.set(client.getWindow().getScaledHeight());

            drawContext.drawTexture(
                    dpRocketTexFlipped,
                    movementX, movementY,
                    0f, 0f,
                    64, 64,
                    64, 64
            );
        }
    }

    public static void displayDPScooter(DrawContext drawContext, int movementX, int movementY) {
        AtomicInteger winWidth = new AtomicInteger();
        AtomicInteger winHeight = new AtomicInteger();
        MinecraftClient client = MinecraftClient.getInstance();

        if (MinecraftClient.getInstance().world != null && client != null) {
            winWidth.set(client.getWindow().getScaledWidth());
            winHeight.set(client.getWindow().getScaledHeight());

            drawContext.drawTexture(
                    dpScooterTex,
                    movementX, movementY,
                    0f, 0f,
                    128, 128,
                    128, 128
            );
        }
    }

    public static void displayDPRun(DrawContext drawContext, int movementX, int movementY) {
        AtomicInteger winWidth = new AtomicInteger();
        AtomicInteger winHeight = new AtomicInteger();
        MinecraftClient client = MinecraftClient.getInstance();

        if (MinecraftClient.getInstance().world != null && client != null) {
            winWidth.set(client.getWindow().getScaledWidth());
            winHeight.set(client.getWindow().getScaledHeight());

            drawContext.drawTexture(
                    dpRunTex,
                    movementX, movementY,
                    0f, 0f,
                    64, 64,
                    64, 64
            );
        }
    }
}
