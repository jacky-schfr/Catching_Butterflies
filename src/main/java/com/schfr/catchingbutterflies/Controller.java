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
            gContex.fillOval(b.xPos, b.yPos, Var.bugSize, Var.bugSize);
        }
        hunter.lvl += 1;
        bugFrequency += 2;
        System.out.println(Arrays.toString(bugList));
    }

    public void bugs(){
        Var.bugX = 0;
        Var.bugY = 0;
        bugList = new Bug[bugFrequency];
        for(int  i = 0; i<bugFrequency; i++){
            startSide();
         bugList[i] = new Bug(Var.bugX, Var.bugY);
        }
    }
    public void startSide(){
        int boundSize = (int) (canvas.getHeight() - Var.bugSize);
        int sideValue = rand.nextInt(4);
        System.out.println(sideValue);

        if(sideValue == 0){
            Var.bugX = 0;
            Var.bugY = rand.nextInt(boundSize);
        }
        if(sideValue == 1){
            Var.bugX = boundSize;
            Var.bugY= rand.nextInt(boundSize);
        }
        if (sideValue == 2){
            Var.bugY = 0;
            Var.bugX = rand.nextInt(boundSize);
        }
        if (sideValue == 3){
            Var.bugY = boundSize;
            Var.bugX = rand.nextInt(boundSize);
        }
    }
}