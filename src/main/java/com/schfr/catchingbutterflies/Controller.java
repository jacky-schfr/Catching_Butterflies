package com.schfr.catchingbutterflies;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Arc;

import java.util.Arrays;
import java.util.Random;

public class Controller {

    public Group Char;
    public Group Net;
    public Arc netShape;
    int bugFrequency;


    Random rand = new Random();

    Bug[] bugList;
    BugHunter hunter = new BugHunter(100, 100);
    public Canvas canvas;
    public GraphicsContext gContex;

    public void start() {
        gContex = canvas.getGraphicsContext2D();
        bugFrequency = 3;
        bugs();
    }

    public void update() {
        gContex.clearRect(0, 0, canvas.getHeight(), canvas.getWidth());
        for (Bug b : bugList) {
            gContex.fillOval(b.xPos, b.yPos, Var.bugSize, Var.bugSize);
            if (b.randomPos == 0) {
                if (b.xPos <= canvas.getHeight()) {
                    b.xPos += 1;
                }
            }
            if (b.randomPos == 1) {
                if (b.xPos >= -Var.bugSize) {
                    b.xPos -= 1;
                }
            }
            if (b.randomPos == 2) {
                if (b.yPos <= canvas.getHeight()) {
                    b.yPos += 1;
                }
            }
            if (b.randomPos == 3) {
                if (b.yPos >= -Var.bugSize) {
                    b.yPos -= 1;
                }
            }
        }
        hunter.lvl += 1;
        bugFrequency += 2;
    }

    public void bugs() {
        bugList = new Bug[bugFrequency];
        for (int i = 0; i < bugFrequency; i++) {
            bugPosition(i);
        }
    }

    public void bugPosition(int i) {
        int boundSize = (int) (canvas.getHeight() - Var.bugSize);
        int sideValue = rand.nextInt(4);

        if (sideValue == 0) {
            Var.bugX = 0;
            Var.bugY = rand.nextInt(boundSize);
        }
        if (sideValue == 1) {
            Var.bugX = boundSize;
            Var.bugY = rand.nextInt(boundSize);
        }
        if (sideValue == 2) {
            Var.bugY = 0;
            Var.bugX = rand.nextInt(boundSize);
        }
        if (sideValue == 3) {
            Var.bugY = boundSize;
            Var.bugX = rand.nextInt(boundSize);
        }
        bugList[i] = new Bug(Var.bugX, Var.bugY);
        bugList[i].randomPos = sideValue;
    }
}