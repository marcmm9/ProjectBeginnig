package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //Settings
    final int originalTitleSize = 16;
    final int scale = 3;

    final int titleSize = originalTitleSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = titleSize * maxScreenCol;
    final int screenHeight = maxScreenRow * titleSize;


    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;


    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while(gameThread != null){
//            System.out.println("Game is Running");
            update();
            repaint();
        }
    }

    public void update(){

        if(keyHandler.upPressed)
            playerY -= playerSpeed;
        else if(keyHandler.downPressed)
            playerY += playerSpeed;
        else if(keyHandler.leftPressed)
            playerX -= playerSpeed;
        else  if(keyHandler.rightPressed)
            playerX += playerSpeed;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(playerX, playerY, titleSize, titleSize);
        g2d.dispose();
    }
}

