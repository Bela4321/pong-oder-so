package main;

import entity.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final static int originalTileSize = 16; //16x16 tile
    final static int scale = 3;

    public static final int tileSize = originalTileSize*scale; ///48x48 tile size
    final static int maxScreenCol = 16;
    final static int maxScreenRow = 12;
    public static final int screenWidth = tileSize*maxScreenCol; //768 pixels
    public static final int screenHeight = tileSize*maxScreenRow; //576 pixels


    //FPS
    int FPS= 60;

    //keyHandler for inputs
    KeyHandler keyH = new KeyHandler();
    //thread for gameloop
    Thread gameThread;
    //free moving Player
    Player player = new Player(keyH);
    //goalkeeper initialisation
    Goalkeeper keeper1 = new Goalkeeper1(keyH,70,150);
    Goalkeeper keeper2 = new Goalkeeper2(keyH, 690,150);

    //displayed Window initialisation
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    //initialise game loop
    public void startGameThread(){
        gameThread =new Thread(this);
        gameThread.start();
    }

    //run game loop
    @Override
    public void run() {

        double drawInterval= 1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;

        while(gameThread != null) {
            currentTime = System.nanoTime();

            delta+= (currentTime-lastTime)/drawInterval;

            lastTime=currentTime;
            if (delta>=1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    //update information
    public void update(){
        player.update();
        keeper1.update();
        keeper2.update();
        collisionUpdate();
    }

    //check different collisions and update accordingly
    public void collisionUpdate(){
        if(CollissionCheck.check(keeper1, player.ball)){
            player.ball.speedX=Math.abs(player.ball.speedX);
            player.ball.speedY+=CollissionCheck.calcYchange(keeper1, player.ball);
        }
        else if (CollissionCheck.check(keeper2,player.ball)){
            player.ball.speedX=-Math.abs(player.ball.speedX);
            player.ball.speedY+=CollissionCheck.calcYchange(keeper2, player.ball);
        }
        if (CollissionCheck.check(player,player.ball)) {
            player.ball= null;
            player.hasBall=true;
            player.catchBall();
        }
    }

    //draw objects
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        //also draws Ball
        player.draw(g2);
        keeper1.draw(g2);
        keeper2.draw(g2);

        g2.dispose();
    }
}