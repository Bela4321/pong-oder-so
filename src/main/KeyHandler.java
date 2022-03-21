package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean fire, upPlayer, downPlayer, leftPlayer, rightPlayer, upKeeper1, downKeeper1,upKeeper2, downKeeper2;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code= e.getKeyCode();

        if (code== KeyEvent.VK_W){upPlayer =true;}
        if (code== KeyEvent.VK_S){downPlayer = true;}
        if (code== KeyEvent.VK_A){leftPlayer =true;}
        if (code== KeyEvent.VK_D){rightPlayer =true;}
        if (code== KeyEvent.VK_UP) {upKeeper1 =true;}
        if (code== KeyEvent.VK_DOWN) {downKeeper1 =true;}
        if (code== KeyEvent.VK_K) {fire=true;}
        if (code== KeyEvent.VK_T) {upKeeper2=true;}
        if (code== KeyEvent.VK_G) {downKeeper2=true;}

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code= e.getKeyCode();

        if (code== KeyEvent.VK_W){upPlayer =false;}
        if (code== KeyEvent.VK_S){downPlayer = false;}
        if (code== KeyEvent.VK_A){leftPlayer =false;}
        if (code== KeyEvent.VK_D){rightPlayer =false;}
        if (code== KeyEvent.VK_UP) {upKeeper1 =false;}
        if (code== KeyEvent.VK_DOWN) {downKeeper1 =false;}
        if (code== KeyEvent.VK_K) {fire=false;}
        if (code== KeyEvent.VK_T) {upKeeper2=false;}
        if (code== KeyEvent.VK_G) {downKeeper2=false;}

    }
}
