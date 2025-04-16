package src.entity;

import src.main.GamePanel;
import src.main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;
    int hasKey = 0;

    public  Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyHandler = keyH;

        screenX = gp.screenWidth/2 - gp.titleSize/2;
        screenY = gp.screenHeight/2 - gp.titleSize/2;

        solidArea = new Rectangle(8, 6, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;


        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX = gp.titleSize * 10; //spwanppoint whole world gp.titlesize* position in txt grid
        worldY = gp.titleSize * 10; //use gp.titlsesize * row/coullum in map file when instantiating the player depending in tile count
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        try{

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/test1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/test1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/test1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/test1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/test1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/test1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/test1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/test1.png"));

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyHandler.upPressed | keyHandler.downPressed | keyHandler.leftPressed | keyHandler.rightPressed) {
            if (keyHandler.upPressed) {
                direction = "up";
            } else if (keyHandler.downPressed) {
                direction = "down";
            } else if (keyHandler.leftPressed) {
                direction = "left";
            } else if (keyHandler.rightPressed) {
                direction = "right";
            }

            // Check tile collision
            collisionOn = false;
            gp.collisionC.checkTile(this);
            int objIndex = gp.collisionC.checkObject(this, true);
            pickUp(objIndex);
            //if collision is false, player can move
            if (!collisionOn) {

                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }
            spriteCounter++;
            if (keyHandler.downPressed | keyHandler.leftPressed | keyHandler.upPressed | keyHandler.rightPressed) {
                if (spriteCounter > 10) {
                    if (spriteNumber == 1)
                        spriteNumber = 2;
                    else if (spriteNumber == 2)
                        spriteNumber = 1;
                    spriteCounter = 0;
                }
            }
        }
    }

    public void pickUp(int index){
        if(index != 999){
            String objectName = gp.obj[index].name;
            switch(objectName){
                case "bubbleTea":
                    //bubble Tea logic
                    break;
                case "flower":
                    //flower logic
                    break;
                case "henry":
                    //henry logic
                    break;
            }
        }
    }
    public void draw(Graphics2D g2d){

        BufferedImage image = null;
        switch (direction) {
            case "up":
                if(spriteNumber == 1)
                    image = up1;
                if(spriteNumber == 2)
                    image = up2;
                break;
            case "down":
                if(spriteNumber == 1)
                    image = down1;
                if(spriteNumber == 2)
                    image = down2;
                break;
            case "left":
                if(spriteNumber == 1)
                    image = left1;
                if(spriteNumber == 2)
                    image = left2;
                break;
            case "right":
                if(spriteNumber == 1)
                    image = right1;
                if(spriteNumber == 2)
                    image = right2;
                break;

        }
        g2d.drawImage(image, screenX, screenY ,gp.titleSize, gp.titleSize, null );

    }

}
