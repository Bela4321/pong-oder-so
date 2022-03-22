package display;

import main.GamePanel;

import java.awt.*;

public class Scoreboard {
    static int scorePlayer1 = 0;
    static int scorePlayer2 = 0;

    public static void reset(){scorePlayer1=scorePlayer2=0;}

    public static void player1Scored(){scorePlayer1++;}
    public static void player2Scored(){scorePlayer2++;}

    public static void draw(Graphics2D g2) {
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g2.setColor(Color.MAGENTA);
        g2.drawString(scorePlayer1+" : "+scorePlayer2, GamePanel.screenWidth/2,50);
    }
}
