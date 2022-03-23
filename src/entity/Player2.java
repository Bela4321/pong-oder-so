package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
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
        getPlayerImage();
    }

    public void getPlayerImage(){
        try{
            playerLeft= ImageIO.read(getClass().getResourceAsStream("/res/Player2_left.png"));
            playerRight= ImageIO.read(getClass().getResourceAsStream("/res/Player2_right.png"));
            playerLeftBall= ImageIO.read(getClass().getResourceAsStream("/res/Player2_left_ball.png"));
            playerRightBall= ImageIO.read(getClass().getResourceAsStream("/res/Player2_right_ball.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void update() {
        if (hasBall) {
            speed=2;
        } else {
            speed=4;
        }
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
        if ((!(velocityX ==0) || !(velocityY ==0))) {directionX=velocityX;directionY=velocityY;}
        //enforce x-y boundarys
        int xMin=GamePanel.screenWidth/2;
        int xMax=GamePanel.screenWidth-sizeX;
        int yMin=0;
        int yMax=GamePanel.screenHeight-sizeY;

        x=Math.max(xMin,Math.min(xMax,x));
        y=Math.max(yMin,Math.min(yMax,y));

        //create Ball
        if (hasBall&& keyH.firePlayer2) {
            GamePanel.ball = new Ball(this);
            hasBall =false;
            if (timer>0){
                GamePanel.ball.speedX+=Math.signum(GamePanel.ball.speedX)*recievedSpeed/10*GamePanel.boostMod;
                GamePanel.ball.speedY+=Math.signum(GamePanel.ball.speedY)*recievedSpeed/10*GamePanel.boostMod;
            }
        }
        timer--;
    }
}
