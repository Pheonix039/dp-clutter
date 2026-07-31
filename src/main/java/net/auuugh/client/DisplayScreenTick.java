package net.auuugh.client;

import net.auuugh.DeadpoolInYourArea;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class DisplayScreenTick implements ClientModInitializer {
    private static MinecraftClient client = MinecraftClient.getInstance();

    //DP-Big.png
    private static double dpBigY1 = 54;
    private static boolean dpBigCycle = true;
    //true = +
    //false = -

    //DP-Tape.png
    private static int dpTapeX = -496;
    //private static boolean dpTapeCycle = true;

    //DP-Rocket
    private static int dpRocketX = -64;
    private static int dpRocketY = 64;

    public static void register() {
        if (MinecraftClient.getInstance().world != null && client != null) {
            //DisplayScreenTick.math();
        }
    }

    @Override
    public void onInitializeClient() {
        AtomicInteger winWidth = new AtomicInteger();
        AtomicInteger winHeight = new AtomicInteger();
        if (MinecraftClient.getInstance().world != null && client != null) {
            winWidth.set(client.getWindow().getScaledWidth());
            winHeight.set(client.getWindow().getScaledHeight());
        }

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
           //Movement math for the pngs
            //DP-Big.png
            double y2 = 84;
            double y3 = 54;

            if (dpBigCycle) {
                dpBigY1 += (y2 - dpBigY1) * 0.2;
                //DeadpoolInYourArea.LOGGER.info("DpBigY1 (up): " + dpBigY1);
                if (dpBigY1 >= 83.9 || dpBigY1 > 84) {
                    dpBigY1 = 84;
                    dpBigCycle = false;
                }
            } else {
                dpBigY1 += (y3 - dpBigY1) * 0.2;
                //DeadpoolInYourArea.LOGGER.info("DpBigY1 (down): " + dpBigY1);
                if (dpBigY1 <= 55.00001 || dpBigY1 < 54) {
                    dpBigY1 = 54;
                    dpBigCycle = true;
                }
            }

            //DP-Tape
            if (client != null) {
                if (MinecraftClient.getInstance().world != null) {
                    if (dpTapeX < 0) {
                        dpTapeX = dpTapeX + 8;
                        // -496
                        //DeadpoolInYourArea.LOGGER.info("DpTapeX: " + dpTapeX);
                    }
                } else {
                    dpTapeX = -496;
                }
            }

            //DP-Rocket
            if (client != null) {
                if (MinecraftClient.getInstance().world != null) {
                    if (dpRocketX < winWidth.get()) {
                        dpRocketX = dpRocketX + 4;
                        // -496
                        //DeadpoolInYourArea.LOGGER.info("DpTapeX: " + dpTapeX);
                        DeadpoolInYourArea.LOGGER.info("DpRocketX: " + dpRocketX);
                        DeadpoolInYourArea.LOGGER.info("winWidth: " + winWidth.get());
                    }
                } else {
                    dpRocketX = -64;
                }
            }

        });
    }

    public static double getDPBigY1() {
        return dpBigY1;
    }

    public static int getDpTapeX() {
        return dpTapeX;
    }

    public static int getDpRocketX() {
        return dpRocketX;
    }

    public static int getDpRocketY() {
        return dpRocketY;
    }
}
