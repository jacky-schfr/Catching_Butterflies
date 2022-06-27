package com.schfr.catchingbutterflies;

import java.util.Random;

public class Bug {
    int flyingSpeed, xPos, yPos, randomPos;
    Random r = new Random();

    public Bug(int x, int y, int speedMin, int speedMax){
        xPos = x;
        yPos = y;
        flyingSpeed = r.nextInt(speedMin, speedMax);
//        flyingSpeed = 0;
    }
}
