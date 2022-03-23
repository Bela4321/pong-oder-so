package main;

import entity.Ball;
import entity.Collidable;
import entity.Goalkeeper;

public class CollissionCheck {

    public static double calcYchange(Goalkeeper keeper, Ball ball) {
        double relativeHit= ((keeper.y+ keeper.sizeY/2)-(ball.virtualY+ ball.sizeY/2))/ keeper.sizeY;
        return -7*Math.sin(relativeHit);
    }

    public static boolean check(Collidable entity1, Collidable entity2) {
        if (entity2 != null && entity2.x < entity1.x + entity1.sizeX && entity2.x + entity2.sizeX > entity1.x) {
            if (entity2.y + entity2.sizeY > entity1.y && entity2.y < entity1.y + entity1.sizeY) {
                return true;
            }
        }
        return false;
    }
}

