package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public abstract class Player extends Entity{
    //player Color
    public Color playerColor;

    //boost countdown
    int timer =0;
    public void catchBall(){timer=30;hasBall=true;}
    //speed boost added on player movement
    int kickingSpeed= 2;
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
        g2.setColor(playerColor);
        g2.fillRect(x,y,sizeX, sizeY);

    }
}
