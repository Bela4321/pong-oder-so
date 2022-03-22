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
        x =GamePanel.screenWidth/10*2;
        y=(GamePanel.screenHeight-sizeY)/2;
        speed = 4;
        hasBall=true;
    }
    public void update() {
        velocityX = velocityY =0;
        //update player Movement+variable
        if (keyH.upPlayer1){
            y-=speed;
            velocityY -=speed;
        }
        if (keyH.downPlayer1){
            y+=speed;
            velocityY += speed;
        }
        if (keyH.leftPlayer1){
            x-=speed;
            velocityX -= speed;
        }
        if (keyH.rightPlayer1){
            x+=speed;
            velocityX +=speed;
        }
        //create Ball
        if (hasBall&& keyH.firePlayer1) {
            GamePanel.ball = new Ball(this);
            hasBall =false;
            if (timer>0){
                GamePanel.ball.speedX*=1.5;
            }
        }
        timer--;
    }
}
