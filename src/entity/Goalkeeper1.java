package entity;

import main.KeyHandler;

public class Goalkeeper1 extends Goalkeeper{
    public Goalkeeper1(KeyHandler keyH, int startX, int startY) {
        super(keyH, startX, startY);
    }

    public void update() {
        if (keyH.upKeeper1){
            y-=speed;
        }
        if (keyH.downKeeper1){
            y+=speed;
        }

    }
}
