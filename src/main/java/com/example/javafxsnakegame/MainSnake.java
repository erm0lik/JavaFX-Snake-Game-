package com.example.javafxsnakegame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSnake extends Application {

     static int BLOCk_size = 40;
    int weight = 30 , height = 15 ;
    static int it = 5;
    long then = System.nanoTime();
        Field field;


    public void start(Stage stage) throws IOException {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

         field = new Field(weight,height);
        field.addSnake(new Snake(it,field));
        Label lb1 = new Label("Score : 0 ");
        lb1.setFont(Font.font("Herculanum" , 30));

        root.getChildren().addAll(lb1,field);

         AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if ( l - then > 1000000000/10 ) {
                    field.update();
                    then = l ;
                    lb1.setText("Score : " + field.score);
                if (field.isDead()){
                    stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("You lost ");
                    alert.setContentText("Your skore : "+ field.score);

                    Platform.runLater(alert::showAndWait);
                    alert.setOnHidden(s-> {
                        start();
                        root.getChildren().clear();
                        field = new Field(weight,height);
                        field.addSnake(new Snake(it,field));
                        lb1.setText("Score : 0");
                        root.getChildren().addAll(lb1,field);
                    });


                }           } }
        };
        timer.start();



        Scene scene = new Scene(root);
        scene.setOnKeyPressed(e->{
            if (e.getCode().equals(KeyCode.UP)&&field.snake.getDirection()!=Block.DOWN){
                field.snake.setDirection(Block.UP);
            }
            if (e.getCode().equals(KeyCode.DOWN)&&field.snake.getDirection()!=Block.UP){
                field.snake.setDirection(Block.DOWN);
            }
            if (e.getCode().equals(KeyCode.RIGHT)&&field.snake.getDirection()!=Block.LEFT){
                field.snake.setDirection(Block.RIGHT);
            }
            if (e.getCode().equals(KeyCode.LEFT)&&field.snake.getDirection()!=Block.RIGHT){
                field.snake.setDirection(Block.LEFT);
            }


        });

        stage.setScene(scene);
        stage.setTitle("SnakeGame");
        stage.setResizable(false);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}