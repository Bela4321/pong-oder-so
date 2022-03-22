package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public abstract class Goalkeeper extends Entity{

    KeyHandler keyH;
    //size of goalkeeper



    public Goalkeeper(KeyHandler keyH) {
        sizeX=GamePanel.tileSize/2;
        sizeY=GamePanel.tileSize*3;
        this.keyH= keyH;
        speed = 8;
    }

    //updates location
    public abstract void update();
    //draws Goalkeeper
    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(x,y,sizeX, sizeY);
    }
}
