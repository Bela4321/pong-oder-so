package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Ball extends InertEntity {
    public int size= 40;

    public double virtualX;
    public double virtualY;



    public Ball(Player1 player1, KeyHandler keyH) {
        sizeX=size;
        sizeY=size;
        speedX=0;
        speedY=0;
        virtualX=x= player1.x;
        virtualY=y= player1.y;
        if (keyH.downPlayer){
            speedY+= player1.speed+ player1.kickingSpeed;
            virtualY=y+= player1.sizeY;
            }
        if (keyH.upPlayer){
            speedY-= player1.speed+ player1.kickingSpeed;
            virtualY=y-= sizeY;
        }
        if (keyH.leftPlayer){
            speedX-= player1.speed+ player1.kickingSpeed;
            virtualX=x-=sizeX;
        }
        if (keyH.rightPlayer){
            speedX+= player1.speed+ player1.kickingSpeed;
            virtualX=x+= player1.sizeX;
        }
    }
    public void update() {
        //location update
        virtualX +=speedX;
        virtualY +=speedY;
        //check collission with border
        if (virtualY<=0||virtualY+size>=GamePanel.screenHeight) {
            speedY*=-1;
        }
        if (virtualX<=0||virtualX+size>=GamePanel.screenWidth) {
            speedX*=-1;
        }
        x=(int)Math.round(virtualX);
        y=(int)Math.round(virtualY);
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.GREEN);
        g2.fillRect(x,y,size, size);
    }
}
