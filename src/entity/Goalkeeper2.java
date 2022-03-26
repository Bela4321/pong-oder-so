package entity;

import main.GamePanel;
import main.KeyHandler;

public class Goalkeeper2 extends Goalkeeper{
    public Goalkeeper2(KeyHandler keyH) {
        super(keyH);
        x= (int) (GamePanel.screenWidth*0.9)-sizeX;
        y= (GamePanel.screenHeight/2-sizeY/2);
    }

    public void update() {
        if (keyH.upKeeper2){
            y-=speed;
        }
        if (keyH.downKeeper2){
            y+=speed;
        }
        if (GamePanel.persuingKeepers){
            if (GamePanel.ball!=null&&!(keyH.upKeeper2||keyH.downKeeper2)){
                if(GamePanel.ball.y+GamePanel.ball.sizeY/2+20>y+sizeY){
                    y+=speed;
                } else if (GamePanel.ball.y+GamePanel.ball.sizeY/2-20<y){
                    y-=speed;
                }
            }
        }
    }
}
