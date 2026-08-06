package net.auuugh.client;

import net.auuugh.DeadpoolInYourArea;
import net.auuugh.effect.ModEffects;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class DisplayScreenTick implements ClientModInitializer {
    private static MinecraftClient client = MinecraftClient.getInstance();
    //Global
    private static Random random = new Random();

    //DP-Big.png
    private static double dpBigY1 = 54;
    private static boolean dpBigCycle = true;
    //true = +
    //false = -

    //DP-Big Flipped
    private static double dpBigY2 = 34;
    private static boolean dpBigCycle2 = true;
    private static int flipSwitchCounter = 0;
    private static int flipSwitchChecker = 0;
    private static boolean flipSwitch = false;

    //DP-Tape.png
    private static int dpTapeX = -496 - 64;
    private static int dpTapeEnd = 0;
    //private static boolean dpTapeCycle = true;

    //DP-Rocket
    private static int dpRocketX = -64 - 16;
    private static int dpRocketY = 0;
    private static boolean changeRocketY = false;

    private static int dpRocketX2 = 256;
    private static int dpRocketY2 = 0;
    private static boolean changeRocketY2 = false;

    //DP-Scooter
    private static int dpScooterX = 0;
    private static int dpScooterY = 0;
    private static int scooterDestination = 0;
    private static int dpScooterCounter = 0;
    private static boolean scooterFinished = true;
    private static int scooterDelay = 0;

    //DP-Run
    private static int dpRunX = 0;
    private static int dpRunY = 0;
    private static int runDestination = 0;
    private static int runCounter = 0;
    private static boolean runFinished = true;
    private static int runDelay = 0;

    //Scooter & Run Spawner
    private static int rsSpawner = 0;

    //SFX
    private static int sfxCounter = 0;

    public static void register() {
        if (MinecraftClient.getInstance().world != null && client != null) {
            //DisplayScreenTick.math();
        }
    }

    @Override
    public void onInitializeClient() {
        AtomicInteger winWidth = new AtomicInteger();
        AtomicInteger winHeight = new AtomicInteger();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (MinecraftClient.getInstance().world != null && client != null) {
                winWidth.set(client.getWindow().getScaledWidth());
                winHeight.set(client.getWindow().getScaledHeight());
                flipSwitchCounter++;
                DeadpoolInYourArea.LOGGER.info("winWidth: " + winWidth.get());
                DeadpoolInYourArea.LOGGER.info("winHeight: " + winHeight.get());
                if (client.player.hasStatusEffect(ModEffects.DP_CLUTTER)) {
                    sfxCounter++;
                    if (sfxCounter == 100) {
                        sfxCounter = 0;
                    }

                    //Movement math for the pngs
                    //DP-Big.png + flipped
                    if (flipSwitchCounter % 40 == 0) {
                        flipSwitchChecker = random.nextInt(99);
                        //DeadpoolInYourArea.LOGGER.info("flipSwitchChecker: " + flipSwitchChecker);
                        flipSwitchCounter = 0;
                        if (flipSwitchChecker % 2 == 0) {
                            flipSwitch = true;
                        } else {
                            flipSwitch = false;
                        }
                        //DeadpoolInYourArea.LOGGER.info("flipSwitch: " + flipSwitch);
                    }

                    if (flipSwitch) {
                        //DP-Big.png
                        double y2 = 54;
                        double y3 = 34;

                        if (dpBigCycle2) {
                            dpBigY1 += (y2 - dpBigY1) * 0.2;
                            //DeadpoolInYourArea.LOGGER.info("DpBigY1 (up): " + dpBigY1);
                            if (dpBigY1 >= 53.9 || dpBigY1 > y2) {
                                dpBigY1 = y2;
                                dpBigCycle2 = false;
                            }
                        } else {
                            dpBigY1 += (y3 - dpBigY1) * 0.2;
                            //DeadpoolInYourArea.LOGGER.info("DpBigY1 (down): " + dpBigY1);
                            if (dpBigY1 <= 35.00001 || dpBigY1 < y3) {
                                dpBigY1 = y3;
                                dpBigCycle2 = true;
                            }
                        }
                    } else {
                        dpBigY1 = -128;
                    }

                    if (!flipSwitch) {
                        //DP-Big flipped
                        double y4 = 34;
                        double y5 = 14;

                        if (dpBigCycle) {
                            dpBigY2 += (y4 - dpBigY2) * 0.2;
                            //DeadpoolInYourArea.LOGGER.info("DpBigY1 (up): " + dpBigY1);
                            if (dpBigY2 >= 33.9 || dpBigY2 > y4) {
                                dpBigY2 = y4;
                                dpBigCycle = false;
                            }
                        } else {
                            dpBigY2 += (y5 - dpBigY2) * 0.2;
                            //DeadpoolInYourArea.LOGGER.info("DpBigY1 (down): " + dpBigY1);
                            if (dpBigY2 <= 15.00001 || dpBigY2 < y5) {
                                dpBigY2 = y5;
                                dpBigCycle = true;
                            }
                        }
                    } else {
                        dpBigY2 = -128;
                    }

                    //DP-Tape
                    dpTapeEnd = (-1024 + winWidth.get());
                    //DeadpoolInYourArea.LOGGER.info("Window Width: " + client.getWindow().getScaledWidth());
                    DeadpoolInYourArea.LOGGER.info("DpTapeX: " + dpTapeX);
                    //DeadpoolInYourArea.LOGGER.info("DpTapeEnd: " + dpTapeEnd);
                    if (dpTapeX < dpTapeEnd) {
                        dpTapeX = dpTapeX + 8;
                        // -496
                    } else if (dpTapeX > dpTapeEnd) {
                        dpTapeX--;
                    }

                    //DP-Rocket
                    if (changeRocketY) {
                        dpRocketY = random.nextInt(0, winHeight.get() - 32);
                        //DeadpoolInYourArea.LOGGER.info("Rocket Y: " + dpRocketY);
                        changeRocketY = false;
                    }

                    if (dpRocketX < winWidth.get() + 32) {
                        dpRocketX = dpRocketX + 16;
                        //DeadpoolInYourArea.LOGGER.info("DpRocketX: " + dpRocketX);
                        //DeadpoolInYourArea.LOGGER.info("winWidth: " + winWidth.get());
                    } else {
                        dpRocketX = -64;
                        changeRocketY = true;
                    }

                    //DP-Rocket Flipped
                    //DeadpoolInYourArea.LOGGER.info("dpRocketX2: " + dpRocketX2);
                    //DeadpoolInYourArea.LOGGER.info("dpRocketY2: " + dpRocketY2);
                    //DeadpoolInYourArea.LOGGER.info("changeRocketY2: " + changeRocketY2);
                    if (changeRocketY2) {
                        dpRocketY2 = random.nextInt(0, winHeight.get() - 32);
                        changeRocketY2 = false;
                    }

                    if (dpRocketX2 > -48) {
                        dpRocketX2 = dpRocketX2 - 32;
                    } else {
                        dpRocketX2 = winWidth.get() + 32;
                        changeRocketY2 = true;
                    }

                    //DP-Scooter
                    if (scooterFinished) {
                        if (scooterDelay > 0) {
                            scooterDelay--;
                        } else {
                            dpScooterX = random.nextInt(winWidth.get() / 2, winWidth.get() - 128);
                            dpScooterY = random.nextInt(0, 84);
                            scooterDestination = dpScooterX - 16;

                            scooterFinished = false;
                            //DeadpoolInYourArea.LOGGER.info("dpScooterX: " + dpScooterX + "\ndpScooterY: " + dpScooterY);
                            //DeadpoolInYourArea.LOGGER.info("Destination X: " + scooterDestinationX + "\nDestination Y: " + scooterDestinationY);
                        }
                    }
                    //DeadpoolInYourArea.LOGGER.info("winWidth: " + winWidth.get());
                    if (dpScooterX > scooterDestination) {
                        dpScooterCounter++;
                        //DeadpoolInYourArea.LOGGER.info("dpScooterCounter: " + dpScooterCounter);
                        if (dpScooterCounter % 5 == 0) {
                            dpScooterX--;
                        }
                        if (dpScooterCounter % 10 == 0) {
                            dpScooterX--;
                            dpScooterY--;
                        }
                        if (dpScooterCounter % 20 == 0) {
                            dpScooterCounter = 0;
                        }
                    } else {
                        if (!scooterFinished) {
                            scooterDelay = random.nextInt(20, 61);
                            //DeadpoolInYourArea.LOGGER.info("Scooter Delay: " + scooterDelay);
                            dpScooterX = -128;
                            dpScooterY = -128;
                        }
                        scooterFinished = true;
                    }

                    //DP-Run
                    if (runFinished) {
                        if (runDelay > 0) {
                            runDelay--;
                        } else {
                            dpRunX = random.nextInt(0, 64);
                            dpRunY = random.nextInt(64, 96);

                            runDestination = dpRunX + 64;

                            runFinished = false;
                        }
                    }

                    if (dpRunX < runDestination) {
                        runCounter++;
                        dpRunX++;

                        if (runCounter % 4 == 0) {
                            dpRunX++;
                            dpRunY--;
                        }
                        if (runCounter % 20 == 0) {
                            runCounter = 0;
                        }
                    } else {
                        if (!runFinished) {
                            runDelay = random.nextInt(20, 61);
                            dpRunX = -128;
                            dpRunY = -128;
                        }
                        runFinished = true;
                    }
                } else {
                    dpTapeX = -1024 - 64;
                    sfxCounter = 0;
                    dpRocketX = -128;
                    dpRocketX2 = winWidth.get() + 64;
                }
            }
        });
    }

    public static double getDPBigY1() {
        return dpBigY1;
    }

    public static double getDPBigY2() {
        return dpBigY2;
    }

    ////////////////////////////////////////////////////////////

    public static int getDpTapeX() {
        return dpTapeX;
    }

    ////////////////////////////////////////////////////////////

    public static int getDpRocketX() {
        return dpRocketX;
    }

    public static int getDpRocketY() {
        return dpRocketY;
    }

    public static int getDpRocketX2() {
        return dpRocketX2;
    }

    public static int getDpRocketY2() {
        return dpRocketY2;
    }

    ////////////////////////////////////////////////////////////

    public static int getDpScooterX() {
        return dpScooterX;
    }

    public static int getDpScooterY() {
        return dpScooterY;
    }

    ////////////////////////////////////////////////////////////

    public static int getDpRunX() {
        return dpRunX;
    }

    public static int getDpRunY() {
        return dpRunY;
    }

    ////////////////////////////////////////////////////////////

    public static int getSfxCounter() {
        return sfxCounter;
    }
}
