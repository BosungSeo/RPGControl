package com.onebee.rpgcontrol.app.Core;

import java.util.Random;

public class GameRandomGenerator {
    private static GameRandomGenerator mInstance = new GameRandomGenerator();
    private Random mRandomGenerator = new Random();
    public static GameRandomGenerator getInstance()
    {
        return mInstance;
    }
    public int getRandomInt(int value)
    {
        return mRandomGenerator.nextInt(value);
    }
    public int getPercent()
    {
        return mRandomGenerator.nextInt(100);
    }
}
