package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Player extends Entity{
    //res.textures
    BufferedImage playerLeft,playerRight,playerLeftBall,playerRightBall;

    //player Movement
    int velocityX =0, velocityY =0;
    int directionX,directionY=0;

    //player Color
    public Color playerColor;

    //boost countdown
    int timer =0;
    int recievedSpeed= 0;

    public void catchBall(){
        timer=30;hasBall=true;
        recievedSpeed=(int)(Math.abs(GamePanel.ball.speedX)+Math.abs(GamePanel.ball.speedY));
        }


    //speed boost added on player movement
    int kickingSpeed= 4;
    public boolean hasBall;

    KeyHandler keyH;

    public Player(KeyHandler keyH) {
        this.keyH= keyH;
        sizeX= GamePanel.tileSize;
        sizeY=GamePanel.tileSize;

        setDefaultValues();
    }
    public abstract void setDefaultValues();

    public abstract void update();

    public void draw(Graphics2D g2) {
        if(hasBall){
            if(directionX>0){
                g2.drawImage(playerRightBall,x,y,GamePanel.tileSize,GamePanel.tileSize,null);
            } else{
                g2.drawImage(playerLeftBall,x,y,GamePanel.tileSize,GamePanel.tileSize,null);
            }
        } else {
            if(directionX>0){
                g2.drawImage(playerRight,x,y,GamePanel.tileSize,GamePanel.tileSize,null);
            } else{
                g2.drawImage(playerLeft,x,y,GamePanel.tileSize,GamePanel.tileSize,null);
            }
        }
    }
}
