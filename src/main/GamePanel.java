package main;

import display.Scoreboard;
import entity.*;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final static int originalTileSize = 16; //16x16 tile
    final static int scale = 3;

    public static final int tileSize = originalTileSize*scale; ///48x48 tile size
    final static int maxScreenCol = 32;
    final static int maxScreenRow = 16;
    public static final int screenWidth = tileSize*maxScreenCol; //1536 pixels
    public static final int screenHeight = tileSize*maxScreenRow; //768 pixels


    //FPS
    int FPS= 60;

    //keyHandler for inputs
    static KeyHandler keyH = new KeyHandler();
    //sounds
    public static Sound sound=new Sound();
    //thread for gameloop
    Thread gameThread;
    //free moving Player
    static Player1 player1 = new Player1(keyH);
    //Player2
    static Player2 player2= new Player2(keyH);
    //goalkeeper initialisation
    static Goalkeeper keeper1 = new Goalkeeper1(keyH);
    static Goalkeeper keeper2 = new Goalkeeper2(keyH);
    //initialise Ball
    public static Ball ball = null;
    //initialise Scoreborad
    public static Scoreboard scoreboard = new Scoreboard();
    //title Screen
    TitleScreen titleScreen = new TitleScreen();
    //settingsScreen
    SettingsScreen settingsScreen = new SettingsScreen();
    //Settings
    public static boolean persuingKeepers=true;
    public static int boostMod=3;


    //Game States
    public static int gameState;
    public static final int TITLESTATE=0;
    public  static final int PLAYSTATE =1;
    public  static final int SETTINGSSTATE =2;


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
        gameState=TITLESTATE;
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
        if (gameState==PLAYSTATE){
            player1.update();
            player2.update();
            keeper1.update();
            keeper2.update();
            if (ball!=null){ball.update();}
            collisionUpdate();
        } else if (gameState==SETTINGSSTATE) {

        } else if(gameState==TITLESTATE){

        }

    }

    //check different collisions and update accordingly
    public void collisionUpdate(){
        if(CollissionCheck.check(keeper1, GamePanel.ball)){
            GamePanel.ball.speedX=Math.abs(GamePanel.ball.speedX);
            GamePanel.ball.speedY+=CollissionCheck.calcYchange(keeper1, GamePanel.ball);
        }
        else if (CollissionCheck.check(keeper2, GamePanel.ball)){
            GamePanel.ball.speedX=-Math.abs(GamePanel.ball.speedX);
            GamePanel.ball.speedY+=CollissionCheck.calcYchange(keeper2, GamePanel.ball);
        }
        if (CollissionCheck.check(player1, GamePanel.ball)) {
            player1.catchBall();
            GamePanel.ball= null;
        }
        if (CollissionCheck.check(player2, GamePanel.ball)) {
            player2.catchBall();
            GamePanel.ball= null;
        }
    }

    //draw objects
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        if (gameState==PLAYSTATE) {
            GamePanel.drawBackground(g2);
            player1.draw(g2);
            player2.draw(g2);
            keeper1.draw(g2);
            keeper2.draw(g2);
            if (ball != null) {ball.draw(g2);}
            scoreboard.draw(g2);
        } else if(gameState==TITLESTATE){
            titleScreen.draw(g2);
        } else if (gameState==SETTINGSSTATE){
            settingsScreen.draw(g2);
        }


        g2.dispose();
    }
    public static void kickoff(int playerNumber) {
        if (playerNumber==1){
            //return ball to player1 (2 scored)
            ball=null;
            player1.hasBall=true;
        } else if (playerNumber==2) {
            //return ball to player2 (1 scored)
            ball=null;
            player2.hasBall=true;
        }
    }


    public static void reset(){
        player1= new Player1(keyH);
        player2 = new Player2(keyH);
        ball=null;
        keeper1= new Goalkeeper1(keyH);
        keeper2= new Goalkeeper2(keyH);
        Scoreboard.reset();
    }


    public static void drawBackground(Graphics2D g2) {
        BufferedImage backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(GamePanel.class.getResourceAsStream("/res/textures/Background.png"));
        }catch(Exception e) {
            e.printStackTrace();
        }
        g2.drawImage(backgroundImage,0,0,GamePanel.screenWidth,GamePanel.screenHeight,null);
    }
}
