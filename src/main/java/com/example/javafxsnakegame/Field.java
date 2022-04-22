package com.example.javafxsnakegame;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Field extends Pane {
    private int w , h;

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
    int score = 0 ;

    ArrayList<Block> blocks = new ArrayList<>();
    Snake snake;
    Food food;

    Field (int weight , int height){
        this.w= weight;
        this.h=height;
        setMinSize(w*MainSnake.BLOCk_size,h*MainSnake.BLOCk_size);
        setBackground(new Background(new BackgroundFill(Color.WHITESMOKE,null,null)));
        setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,new BorderWidths(1))));
        addFood();

    }
    public boolean isEaten (){
        if (food==null)return false;

        return food.getXfood()==snake.head.X && food.getYfood()==snake.head.Y;

    }

    public void update() {
        for (Block b : blocks) {
            b.update();
        }
        if (isEaten()) {
            score++;
            addFood();
            addNewBlock();
        }
    }


    public boolean isDead(){
        for (Block b : blocks){
            if (b!=snake.head)
                if (b.X==snake.head.X&&b.Y==snake.head.Y)
                    return true;
            }
        return false;
    }


    public void addNewBlock (){
        Block b = new Block(snake.tail.oldX, snake.tail.oldY ,snake.tail ,this );
        snake.tail=b;
        addBlock(b);
    }

    public void addSnake (Snake snake){
        this.snake=snake;
        for(Block b : snake.blocks){
            addBlock(b);
        }
    }
    private void addBlock (Block b ){
        getChildren().add(b);
        blocks.add(b);
    }
    public void addFood (){
        int X = (int) (Math.random()*w);
        int Y = (int) (Math.random()*h);
        Food food = new Food(X,Y);
        getChildren().add(food);
        getChildren().remove(this.food);
        this.food=food;
    }





}
