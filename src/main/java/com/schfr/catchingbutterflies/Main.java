package com.schfr.catchingbutterflies;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("frame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);

        Controller controller = fxmlLoader.getController();

        stage.setTitle("Catching Butterflies");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        scene.setOnKeyPressed(controller::setKeypressend);

        controller.start();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.update();
            }
        };
        timer.start();
    }

    public static void main(String[] args) {
        launch();
    }
}