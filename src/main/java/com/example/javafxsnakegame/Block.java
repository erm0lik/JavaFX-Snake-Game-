package com.example.javafxsnakegame;

import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {
    int X , Y , oldX ,oldY;

    int maxX , maxY ;

    static final int UP = 0 , RIGHT = 1 , DOWN = 2 , LEFT = 3 ;

    Block prev ;
    Block add ;
    int direction = LEFT;

    Block (int X , int Y , Block prev , Field f){
        super(MainSnake.BLOCk_size,MainSnake.BLOCk_size);
        this.X=X;
        this.Y=Y;
        this.prev=prev;
        setTranslateX(this.X*MainSnake.BLOCk_size);
        setTranslateY(this.Y*MainSnake.BLOCk_size);
        maxX=f.getW();
        maxY=f.getH();

    }
    public void update (){

        oldX=X;
        oldY=Y;
        if (prev == null){
            switch (direction){
                case UP : movedUp();break;
                case RIGHT:  movedRight();break;
                case DOWN:  movedDown();break;
                case LEFT:  movedLeft();break;
            }

        }
        else {
            X = prev.oldX;
            Y = prev.oldY;
        }
        updatePosition();
    }
    public void movedUp(){
        Y--;
        if (Y < 0)Y=maxY-1;
    }
    public void movedDown(){
        Y++;
        if (Y>=maxY)Y=0;
    }
    public void movedRight(){

        X++;
        if (X>=maxX)X=0;
    }
    public void movedLeft(){
        X--;
        if (X < 0)X=maxX-1;
    }
    public void updatePosition (){
        setTranslateX(X*MainSnake.BLOCk_size);
        setTranslateY(Y*MainSnake.BLOCk_size);
    }
}
