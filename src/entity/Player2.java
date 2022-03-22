package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player2 extends Entity{
    //ball initialisation
    public Ball ball = null;
    //boost cozuntdown
    int timer =0;
    public void catchBall(){timer=30;}
    //speed boost added on player movement
    int kickingSpeed= 2;
    public boolean hasBall = true;

    KeyHandler keyH;

    public Player1(KeyHandler keyH) {
        this.keyH= keyH;
        sizeX= GamePanel.tileSize;
        sizeY=GamePanel.tileSize;

        setDefaultValues();
    }
    public void setDefaultValues() {
        x =300;
        y=100;
        speed = 4;
    }
    public void update() {
        //update player Movement
        if (keyH.upPlayer){
            y-=speed;
        }
        if (keyH.downPlayer){
            y+=speed;
        }
        if (keyH.leftPlayer){
            x-=speed;
        }
        if (keyH.rightPlayer){
            x+=speed;
        }
        //create Ball
        if (hasBall&& keyH.fire) {
            ball = new Ball(this, keyH);
            hasBall =false;
            if (timer>0){
                ball.speedX*=2;
                ball.speedY*=2;
            }
        }
        if(!hasBall){
            ball.update();
        }
        timer--;
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(x,y,sizeX, sizeY);
        if (!hasBall){
            ball.draw(g2);
        }
    }
}
