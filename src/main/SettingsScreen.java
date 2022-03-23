package main;

import java.awt.*;

public class SettingsScreen {
    Graphics2D g2;
    public static int commandNumber=0;

    public void draw(Graphics2D g2) {
        this.g2=g2;

        g2.setColor(Color.MAGENTA);
        g2.fillRect(0,0,GamePanel.screenWidth,GamePanel.screenHeight);
        //menu
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 30).deriveFont(Font.BOLD,70F));

        //title
        String text="Settings";
        int x = getXforCenteredText(text);
        int y=GamePanel.tileSize*3;
        g2.setColor(Color.BLACK);
        g2.drawString(text,x+5,y+5);
        g2.setColor(Color.WHITE);
        g2.drawString(text,x,y);

        //settings
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 30).deriveFont(Font.BOLD,48F));

        if (GamePanel.persuingKeepers){
            text="AUTO GOALKEEPERS X";
        } else {
            text="AUTO GOALKEEPERS O";
        }
        x = getXforCenteredText(text);
        y+=GamePanel.tileSize*4;
        g2.drawString(text,x,y);
        if (commandNumber==0) {
            g2.drawString(">",x-GamePanel.tileSize,y);
        }

        text = "Boost Mod.:"+GamePanel.boostMod;
        x = getXforCenteredText(text);
        y+=GamePanel.tileSize*3/2;
        g2.drawString(text,x,y);
        if (commandNumber==1) {
            g2.drawString(">",x-GamePanel.tileSize,y);
        }

        //return
        text="Return";
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
