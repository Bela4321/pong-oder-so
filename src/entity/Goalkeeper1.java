package entity;

import main.GamePanel;
import main.KeyHandler;

public class Goalkeeper1 extends Goalkeeper{
    public Goalkeeper1(KeyHandler keyH) {
        super(keyH);
        x= (int) (GamePanel.screenWidth*0.1);
        y= (GamePanel.screenHeight/2-sizeY/2);

    }

    public void update() {
        if (keyH.upKeeper1){
            y-=speed;
        }
        if (keyH.downKeeper1){
            y+=speed;
        }
        if (GamePanel.ball!=null&&!(keyH.upKeeper1||keyH.downKeeper1)){
            if(GamePanel.ball.y+GamePanel.ball.sizeY/2>y+sizeY/2){
                y+=speed;
            } else if (GamePanel.ball.y+GamePanel.ball.sizeY/2<y+sizeY/2){
                y-=speed;
            }
        }

    }
}
