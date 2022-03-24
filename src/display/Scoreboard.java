package display;

import main.GamePanel;

import java.awt.*;

public class Scoreboard {
    static Graphics2D g2;
    static int scorePlayer1 = 0;
    static int scorePlayer2 = 0;

    public static void reset(){scorePlayer1=scorePlayer2=0;}

    public static void player1Scored(){scorePlayer1++;}
    public static void player2Scored(){scorePlayer2++;}

    public void draw(Graphics2D g2) {
        this.g2=g2;
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 60).deriveFont(Font.BOLD));
        g2.setColor(Color.MAGENTA);
        String text = scorePlayer1+" : "+scorePlayer2;
        int x= getXforCenteredText(text);
        g2.drawString(text, x,50);
    }
    public static int getXforCenteredText(String text) {
        int length= (int) g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x =GamePanel.screenWidth/2-length/2;
        return x;
    }
}
