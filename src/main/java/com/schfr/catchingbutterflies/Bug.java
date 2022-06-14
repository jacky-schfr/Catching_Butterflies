package com.schfr.catchingbutterflies;

import java.util.Random;

public class Bug {
    int flyingSpeed, xPos, yPos, randomPos;
    Random r = new Random();

    public Bug(int x, int y){
        xPos = x;
        yPos = y;
        flyingSpeed = r.nextInt(1, 3);
//        flyingSpeed = 0;
    }
}
