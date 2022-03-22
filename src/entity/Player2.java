package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player2 extends Player{

    public Player2(KeyHandler keyH) {
        super(keyH);
        playerColor = Color.BLUE;
    }
    public void setDefaultValues() {
        x =GamePanel.screenWidth/10*8-sizeX;
        y=(GamePanel.screenHeight-sizeY)/2;
        speed = 4;
        hasBall = false;
    }
    public void update() {
        velocityX = velocityY =0;
        //update player Movement+variable
        if (keyH.upPlayer2){
            y-=speed;
            velocityY -=speed;
        }
        if (keyH.downPlayer2){
            y+=speed;
            velocityY += speed;
        }
        if (keyH.leftPlayer2){
            x-=speed;
            velocityX -= speed;
        }
        if (keyH.rightPlayer2){
            x+=speed;
            velocityX +=speed;
        }
        //create Ball
        if (hasBall&& keyH.firePlayer2) {
            GamePanel.ball = new Ball(this);
            hasBall =false;
            if (timer>0){
                GamePanel.ball.speedX*=1.5;
            }
        }
        timer--;
    }
}
