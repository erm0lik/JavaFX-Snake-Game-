package com.example.javafxsnakegame;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Snake {
    ArrayList<Block> blocks = new ArrayList<>();
    Block head;
    Block tail ;

    public Snake (int ip , Field f){
        int ipx = f.getW() / 2;
        int ipy = f.getH() / 2;

        head = new Block(ipx,ipy,tail,f);

        blocks.add(head);

        tail= head;

        for (int i = 1; i < ip; i++) {
            Block b = new Block(ipx+i,ipy,tail,f);
            blocks.add(b);
            tail = b;
        }
        head.setFill(Color.VIOLET);
    }

    public  int  getDirection(){
        return head.direction;
    }


    public void setDirection (int d ){
        head.direction = d ;
    }
}
