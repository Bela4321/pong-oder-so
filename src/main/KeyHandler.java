package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean fire, upPlayer1, downPlayer1, leftPlayer1, rightPlayer1, upKeeper1, downKeeper1,upKeeper2, downKeeper2;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code= e.getKeyCode();

        if (code== KeyEvent.VK_W){
            upPlayer1 =true;}
        if (code== KeyEvent.VK_S){
            downPlayer1 = true;}
        if (code== KeyEvent.VK_A){
            leftPlayer1 =true;}
        if (code== KeyEvent.VK_D){
            rightPlayer1 =true;}
        if (code== KeyEvent.VK_UP) {upKeeper2 =true;}
        if (code== KeyEvent.VK_DOWN) {downKeeper2 =true;}
        if (code== KeyEvent.VK_K) {fire=true;}
        if (code== KeyEvent.VK_T) {upKeeper1=true;}
        if (code== KeyEvent.VK_G) {downKeeper1=true;}

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code= e.getKeyCode();

        if (code== KeyEvent.VK_W){
            upPlayer1 =false;}
        if (code== KeyEvent.VK_S){
            downPlayer1 = false;}
        if (code== KeyEvent.VK_A){
            leftPlayer1 =false;}
        if (code== KeyEvent.VK_D){
            rightPlayer1 =false;}
        if (code== KeyEvent.VK_UP) {upKeeper2 =false;}
        if (code== KeyEvent.VK_DOWN) {downKeeper2 =false;}
        if (code== KeyEvent.VK_K) {fire=false;}
        if (code== KeyEvent.VK_T) {upKeeper1=false;}
        if (code== KeyEvent.VK_G) {downKeeper1=false;}

    }
}
