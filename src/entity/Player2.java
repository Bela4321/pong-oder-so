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
        x =450;
        y=200;
        speed = 4;
        hasBall = false;
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
