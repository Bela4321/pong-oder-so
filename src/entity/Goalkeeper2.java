package entity;

import main.KeyHandler;

public class Goalkeeper2 extends Goalkeeper{
    public Goalkeeper2(KeyHandler keyH, int startX, int startY) {
        super(keyH, startX, startY);
    }

    public void update() {
        if (keyH.upKeeper2){
            y-=speed;
        }
        if (keyH.downKeeper2){
            y+=speed;
        }

    }
}
