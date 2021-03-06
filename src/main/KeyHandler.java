package main;

import display.Scoreboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean firePlayer1, upPlayer1, downPlayer1, leftPlayer1, rightPlayer1,firePlayer2, upPlayer2, downPlayer2, leftPlayer2, rightPlayer2, upKeeper1, downKeeper1, upKeeper2, downKeeper2;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code= e.getKeyCode();

        //Title State
        if (GamePanel.gameState==GamePanel.TITLESTATE) {
            if (code== KeyEvent.VK_W){
                TitleScreen.commandNumber--;}
            if (code== KeyEvent.VK_S){
                TitleScreen.commandNumber++;}
            if (TitleScreen.commandNumber<0){TitleScreen.commandNumber=2;}
            if (TitleScreen.commandNumber>2) {TitleScreen.commandNumber=0;}
            if (code==KeyEvent.VK_ENTER) {
                if (TitleScreen.commandNumber==0){GamePanel.reset();GamePanel.gameState=GamePanel.PLAYSTATE;}
                if (TitleScreen.commandNumber==1){GamePanel.gameState=GamePanel.PLAYSTATE;}
                if (TitleScreen.commandNumber==2) {GamePanel.gameState=GamePanel.SETTINGSSTATE;TitleScreen.commandNumber=0;}

            }
        }

        //Settings State
        if(GamePanel.gameState==GamePanel.SETTINGSSTATE){
            if (code== KeyEvent.VK_W){
                SettingsScreen.commandNumber--;}
            if (code== KeyEvent.VK_S){
                SettingsScreen.commandNumber++;}
            if (SettingsScreen.commandNumber<0){SettingsScreen.commandNumber=2;}
            if (SettingsScreen.commandNumber>2) {SettingsScreen.commandNumber=0;}

            if (code==KeyEvent.VK_ENTER) {
                if (SettingsScreen.commandNumber==0){GamePanel.persuingKeepers=!GamePanel.persuingKeepers;}
                if (SettingsScreen.commandNumber==1){GamePanel.boostMod++;if (GamePanel.boostMod>20){GamePanel.boostMod=0;}}
                if (SettingsScreen.commandNumber==2){GamePanel.gameState=GamePanel.TITLESTATE;SettingsScreen.commandNumber=0;}

            }
        }
        if (code==KeyEvent.VK_ESCAPE){
            GamePanel.gameState=GamePanel.TITLESTATE;
        }

        if (code== KeyEvent.VK_E){upPlayer1 =true;}
        if (code== KeyEvent.VK_D){downPlayer1 = true;}
        if (code== KeyEvent.VK_S){leftPlayer1 =true;}
        if (code== KeyEvent.VK_F){rightPlayer1 =true;}
        if (code== KeyEvent.VK_W) {firePlayer1 =true;}
        if (code== KeyEvent.VK_I){upPlayer2 =true;}
        if (code== KeyEvent.VK_K){downPlayer2 = true;}
        if (code== KeyEvent.VK_J){leftPlayer2 =true;}
        if (code== KeyEvent.VK_L){rightPlayer2 =true;}
        if (code== KeyEvent.VK_O) {firePlayer2 =true;}
        if (code== KeyEvent.VK_Q) {upKeeper1=true;}
        if (code== KeyEvent.VK_A) {downKeeper1=true;}
        if (code== KeyEvent.VK_UP) {upKeeper2 =true;}
        if (code== KeyEvent.VK_DOWN) {downKeeper2 =true;}


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code= e.getKeyCode();

        if (code== KeyEvent.VK_E){upPlayer1 =false;}
        if (code== KeyEvent.VK_D){downPlayer1 = false;}
        if (code== KeyEvent.VK_S){leftPlayer1 =false;}
        if (code== KeyEvent.VK_F){rightPlayer1 =false;}
        if (code== KeyEvent.VK_W) {firePlayer1 =false;}
        if (code== KeyEvent.VK_I){upPlayer2 =false;}
        if (code== KeyEvent.VK_K){downPlayer2 = false;}
        if (code== KeyEvent.VK_J){leftPlayer2 =false;}
        if (code== KeyEvent.VK_L){rightPlayer2 =false;}
        if (code== KeyEvent.VK_O) {firePlayer2 =false;}
        if (code== KeyEvent.VK_Q) {upKeeper1=false;}
        if (code== KeyEvent.VK_A) {downKeeper1=false;}
        if (code== KeyEvent.VK_UP) {upKeeper2 =false;}
        if (code== KeyEvent.VK_DOWN) {downKeeper2 =false;}

    }
}
