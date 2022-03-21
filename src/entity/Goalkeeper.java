package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public abstract class Goalkeeper extends Entity{

    KeyHandler keyH;
    //size of goalkeeper



    public Goalkeeper(KeyHandler keyH,int startX, int startY) {
        sizeX=GamePanel.tileSize/2;
        sizeY=GamePanel.tileSize*3;
        this.keyH= keyH;
        x = startX;
        y = startY;
        speed = 8;
    }

    //updates location
    public abstract void update(); /*{
        if (keyH.upKeeper1){
            y-=speed;
        }
        if (keyH.downKeeper1){
            y+=speed;
        }

    }*/
    //draws Goalkeeper
    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(x,y,sizeX, sizeY);
    }
}
