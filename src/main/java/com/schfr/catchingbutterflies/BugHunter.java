package com.schfr.catchingbutterflies;

public class BugHunter {
    int locationX, locationY, netAngle, runningSpeed, lvl, bugCatch;


    public BugHunter(int x, int y) {
        locationX = x;
        locationY = y;
        netAngle = 0;
        runningSpeed = 10;
        lvl = 0;
        bugCatch = 0;
    }
    public void lvlUp(){
        if (bugCatch == 2){
            lvl = 1;
            Var.bugNum += 3;
            Var.minSpeed += 1;
            Var.maxSpeed += 1;
        }
        if (bugCatch == 5){
            lvl = 2;
            Var.bugNum += 3;
        }
        if (bugCatch == 9){
            lvl = 3;
            Var.bugNum += 3;
            Var.minSpeed += 1;
            Var.maxSpeed += 1;
        }
    }
}
