package com.schfr.catchingbutterflies;

public class Var {
    public static long currentTime;
    public static long lvlTimer, bugTimer;
    static int bugX, bugY, bugSize = 30, bugNum, minSpeed, maxSpeed;




    public static long setTimer() {
        return System.currentTimeMillis();
    }
}
