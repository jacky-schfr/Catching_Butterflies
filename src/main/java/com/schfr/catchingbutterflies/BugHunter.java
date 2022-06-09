package com.schfr.catchingbutterflies;

public class BugHunter {
    int locationX, locationY, netAngle, runningSpeed, points, lvl;


    public BugHunter(int x, int y) {
        locationX = x;
        locationY = y;
        netAngle = 0;
        points = 0;
        runningSpeed = 10;
        lvl = 0;
    }

    public void bugCatch(){
        points += 1;

    }
}
