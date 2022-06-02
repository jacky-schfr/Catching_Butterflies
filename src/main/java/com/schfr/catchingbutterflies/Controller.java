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

    AnimationTimer bugTimer = null;

    Random rand = new Random();

    Bug[] bugList;
    BugHunter hunter =  new BugHunter(100, 100);
    public Canvas canvas;
    public GraphicsContext gContex;

    public void start(){
        gContex = canvas.getGraphicsContext2D();
        bugFrequency = 3;
        bugs();
    }
    public void update(){
        for(Bug b :bugList){
            gContex.fillOval(b.xPos, b.yPos, 30, 30);
        }
        // for bug in bugs create circle. jeder circle hat die position vom bug. Jeder Bug wird da gezeichnet wo er hin soll.
        hunter.lvl += 1;
        bugFrequency += 2;
        System.out.println(Arrays.toString(bugList));
    }

    public void bugs(){
        bugList = new Bug[bugFrequency];
        for(int  i = 0; i<bugFrequency; i++){
         bugList[i] = new Bug(rand.nextInt(600), rand.nextInt(400));
        }
    }
}