package entity;

import display.Scoreboard;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Ball extends InertEntity {
    BufferedImage ballIMG;

    public int size= 40;

    public double virtualX;
    public double virtualY;



    public Ball(Player player) {
        sizeX=size;
        sizeY=size;
        speedX=player.directionX;
        speedY=player.directionY;
        virtualX=x= player.x;
        virtualY=y= player.y;
        if (player.directionY>0.01){
            speedY+= player.speed+ player.kickingSpeed;
            virtualY=y+= player.sizeY;
            }
        if (player.directionY<-0.01){
            speedY-= player.speed+ player.kickingSpeed;
            virtualY=y-= sizeY;
        }
        if (player.directionX<-0.01){
            speedX-= player.speed+ player.kickingSpeed;
            virtualX=x-=sizeX;
        }
        if (player.directionX>0.01){
            speedX+= player.speed+ player.kickingSpeed;
            virtualX=x+= player.sizeX;
        }
        try {
            ballIMG= ImageIO.read(getClass().getResourceAsStream("/res/Ball.png"));
        } catch (Exception e) {
            e.printStackTrace();
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
            GamePanel.kickoff(1);
        }
        if (virtualX+size>=GamePanel.screenWidth) {
            speedX*=-1;
            Scoreboard.player1Scored();
            GamePanel.kickoff(2);
        }
        //enforce x-y boundarys
        double xMin=0;
        double xMax=GamePanel.screenWidth;
        double yMin=0;
        double yMax=GamePanel.screenHeight;

        virtualX=Math.max(xMin,Math.min(xMax,virtualX));
        virtualY=Math.max(yMin,Math.min(yMax,virtualY));


        x=(int)Math.round(virtualX);
        y=(int)Math.round(virtualY);
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(ballIMG,x,y,size, size,null);
    }
}
