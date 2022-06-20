package com.example.groupproject;

import android.content.Context;
import android.util.Log;

import java.util.Random;

public class Fish extends androidx.appcompat.widget.AppCompatImageView {
    private int x_speed;
    private int y_speed;
    private int x_pos;
    private int y_pos;
    private int score;
    private boolean alive;
    private int fishType;
    private static final Random rand = new Random();

    public Fish(Context context) {
        super(context);
    }

    public void setData(int x_pos, int y_pos, int fishType) {
        this.fishType = fishType;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        switch(fishType){
            case 1: initializeBasic(1, 1, 10); break;
            case 2: initializeBasic(2, 2, 20); break;
            case 3: initializeBasic(3, 3, 30); break;
            case 4: initializeBasic(4, 1, 40); break;
            case 5: initializeBasic(1, 2, 20); break;
            case 6: initializeBasic(2, 1, 20); break;
            case 7: initializeBasic(1, 3, 30); break;
            case 8: initializeBasic(3, 1, 30); break;
            case 9: initializeBasic(1, 4, 40); break;
            default: initializeBasic(1, 1, 5); break;
        }
        this.alive = true;
    }

    private void initializeBasic(int x_speed, int y_speed, int score){
        int value1 = rand.nextInt(2) == 1 ? 1 : -1;
        int value2 = rand.nextInt(2) == 1 ? 1 : -1;
        this.x_speed = x_speed * value1;
        this.y_speed = y_speed * value2;
        this.score = score;
    }

    public int getX_speed() {
        return x_speed;
    }

    public void setX_speed(int x_speed) {
        this.x_speed = x_speed;
    }

    public int getY_speed() {
        return y_speed;
    }

    public void setY_speed(int y_speed) {
        this.y_speed = y_speed;
    }

    public int getX_pos() {
        return x_pos;
    }

    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int coin) {
        this.score = coin;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getFishType(){return fishType;}
}
