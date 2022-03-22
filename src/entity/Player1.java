package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player1 extends Player{


    public Player1(KeyHandler keyH) {
        super(keyH);
        playerColor= Color.RED;
    }
    public void setDefaultValues() {
        x =300;
        y=100;
        speed = 4;
        hasBall=true;
    }
    public void update() {
        //update player Movement
        if (keyH.upPlayer1){
            y-=speed;
        }
        if (keyH.downPlayer1){
            y+=speed;
        }
        if (keyH.leftPlayer1){
            x-=speed;
        }
        if (keyH.rightPlayer1){
            x+=speed;
        }
        //create Ball
        if (hasBall&& keyH.fire) {
            GamePanel.ball = new Ball(this, keyH);
            hasBall =false;
            if (timer>0){
                GamePanel.ball.speedX*=2;
                GamePanel.ball.speedY*=2;
            }
        }
        timer--;
    }
}
