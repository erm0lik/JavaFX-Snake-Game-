package com.example.javafxsnakegame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Food extends Rectangle {

    public int getXfood() {
        return X;
    }


    public int getYfood() {
        return Y;
    }

    int X , Y ;
    public Food(int X , int Y){
        super(MainSnake.BLOCk_size,MainSnake.BLOCk_size);
        this.X=X;
        this.Y=Y;
        setTranslateX(this.X*MainSnake.BLOCk_size);
        setTranslateY(this.Y*MainSnake.BLOCk_size);
        setFill(Color.RED);
    }
}
