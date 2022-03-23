package main;

import java.awt.*;
import java.security.PublicKey;

public class TitleScreen {
    Graphics2D g2;
    public static int commandNumber=0;

    public void draw(Graphics2D g2) {
        this.g2=g2;

        g2.setColor(Color.MAGENTA);
        g2.fillRect(0,0,GamePanel.screenWidth,GamePanel.screenHeight);
        //menu
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 30).deriveFont(Font.BOLD,80F));

        //title
        String text="Pong Soccer";
        int x = getXforCenteredText(text);
        int y=GamePanel.tileSize*4;
        g2.setColor(Color.BLACK);
        g2.drawString(text,x+5,y+5);
        g2.setColor(Color.WHITE);
        g2.drawString(text,x,y);

        //new Game
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 30).deriveFont(Font.BOLD,48F));
        text="NEW GAME";
        x = getXforCenteredText(text);
        y+=GamePanel.tileSize*4;
        g2.drawString(text,x,y);
        if (commandNumber==0) {
            g2.drawString(">",x-GamePanel.tileSize,y);
        }

        //load game
        text="LOAD GAME";
        x = getXforCenteredText(text);
        y+=GamePanel.tileSize*3/2
        ;
        g2.drawString(text,x,y);
        if (commandNumber==1) {
            g2.drawString(">",x-GamePanel.tileSize,y);
        }

        //settings
        text="SETTINGS";
        x = getXforCenteredText(text);
        y+=GamePanel.tileSize*3/2;
        g2.drawString(text,x,y);
        if (commandNumber==2) {
            g2.drawString(">",x-GamePanel.tileSize,y);
        }
        
    }

    public int getXforCenteredText(String text) {
        int length= (int) g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x =GamePanel.screenWidth/2-length/2;
        return x;
    }
}
