package entity;

import display.Scoreboard;
import main.GamePanel;

import java.awt.*;

public class Ball extends InertEntity {
    public int size= 40;

    public double virtualX;
    public double virtualY;



    public Ball(Player player) {
        sizeX=size;
        sizeY=size;
        speedX=player.velocityX;
        speedY=player.velocityY;
        virtualX=x= player.x;
        virtualY=y= player.y;
        if (player.velocityY>0.01){
            speedY+= player.speed+ player.kickingSpeed;
            virtualY=y+= player.sizeY;
            }
        if (player.velocityY<-0.01){
            speedY-= player.speed+ player.kickingSpeed;
            virtualY=y-= sizeY;
        }
        if (player.velocityX<-0.01){
            speedX-= player.speed+ player.kickingSpeed;
            virtualX=x-=sizeX;
        }
        if (player.velocityX>0.01){
            speedX+= player.speed+ player.kickingSpeed;
            virtualX=x+= player.sizeX;
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
        if (virtualX<=0) {
            speedX*=-1;
            Scoreboard.player2Scored();
        }
        if (virtualX+size>=GamePanel.screenWidth) {
            speedX*=-1;
            Scoreboard.player1Scored();
        }
        x=(int)Math.round(virtualX);
        y=(int)Math.round(virtualY);
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.GREEN);
        g2.fillRect(x,y,size, size);
    }
}
