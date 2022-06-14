package com.schfr.catchingbutterflies;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;

import java.util.Random;

public class Controller {

    public Group Char;
    public Arc meshNet;
    public AnchorPane Net;
    int bugFrequency;

    Random rand = new Random();

    Bug[] bugList;
    BugHunter hunter;
    public Canvas canvas;
    public GraphicsContext gContex;

    public void start() {
        gContex = canvas.getGraphicsContext2D();
        hunter = new BugHunter((int) Char.getLayoutX(), (int) Char.getLayoutY());
        bugFrequency = 3;
        bugs();
    }

    public void update() {
        gContex.clearRect(0, 0, canvas.getHeight(), canvas.getWidth());;
        for (Bug b : bugList) {
            gContex.fillOval(b.xPos, b.yPos, Var.bugSize, Var.bugSize);
            if (b.randomPos == 0) {
                if (b.xPos <= canvas.getHeight()) {
                    b.xPos += b.flyingSpeed;
                }
            }
            if (b.randomPos == 1) {
                if (b.xPos >= -Var.bugSize) {
                    b.xPos -= b.flyingSpeed;
                }
            }
            if (b.randomPos == 2) {
                if (b.yPos <= canvas.getHeight()) {
                    b.yPos += b.flyingSpeed;
                }
            }
            if (b.randomPos == 3) {
                if (b.yPos >= -Var.bugSize) {
                    b.yPos -= b.flyingSpeed;
                }
            }
        }
        Char.setLayoutX(hunter.locationX);
        Char.setLayoutY(hunter.locationY);
        Net.setLayoutX(hunter.locationX + 60);
        Net.setLayoutY(hunter.locationY - 50);
        catchingBugs();
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
    public void setKeypressend(KeyEvent e){
        if (e.getCode() == KeyCode.W){
            hunter.locationY -= hunter.runningSpeed;
        }
        if (e.getCode() == KeyCode.A){
            hunter.locationX -= hunter.runningSpeed;
        }
        if (e.getCode() == KeyCode.S){
            hunter.locationY += hunter.runningSpeed;
        }
        if (e.getCode() == KeyCode.D){
            hunter.locationX += hunter.runningSpeed;
        }
    }

    public void netDirection(MouseEvent mouseEvent) {
        hunter.netAngle = (int) calculateAngle(Net.getLayoutX(), Net.getLayoutY()+80, mouseEvent.getX(), mouseEvent.getY());
        Net.setRotate(hunter.netAngle);
    }
    public double calculateAngle(double x1, double y1, double x2, double y2){
        double angle = Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        angle = angle + Math.ceil( -angle / 360 ) * 360;
        angle += 90;

        return angle;
    }
    public void catchingBugs(){
        for (Bug b : bugList){
            if(meshNet.getParent().getParent().getBoundsInParent().intersects(b.xPos, b.yPos, Var.bugSize, Var.bugSize)){
                System.out.println("Pooop");
                hunter.points += 1;
            }
        }
        System.out.println(hunter.points);
    }

}