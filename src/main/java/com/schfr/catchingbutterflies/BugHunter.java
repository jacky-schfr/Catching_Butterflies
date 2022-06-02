package com.schfr.catchingbutterflies;

public class BugHunter {
    int locationX, locationY, netAnkle, runningSpeed, points, lvl;


    public BugHunter(int x, int y) {
        locationX = x;
        locationY = y;
        netAnkle = 0;
        points = 0;
        lvl = 0;
    }

    public void bugCatch(){
        points += 1;

    }
}
