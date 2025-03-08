package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyHandler;

    public  Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyHandler = keyH;

        setDefaultValues();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }
    public void update(){
        if(keyHandler.upPressed)
            y -= speed;
        else if(keyHandler.downPressed)
            y += speed;
        else if(keyHandler.leftPressed)
            x -= speed;
        else  if(keyHandler.rightPressed)
            x += speed;
    }
    public void draw(Graphics2D g2d){

        g2d.setColor(Color.WHITE);

        g2d.fillRect(x, y, gp.titleSize, gp.titleSize);
    }

}
