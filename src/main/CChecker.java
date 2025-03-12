package src.main;

import src.entity.Entity;

public class CChecker {

    GamePanel gp;

    public CChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity){

        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.titleSize;
        int entityRightCol = entityRightWorldX/gp.titleSize;
        int entityTopRow = entityTopWorldY/gp.titleSize;
        int entityBottomRow = entityBottomWorldY/gp.titleSize;

        int tileNum1, tileNum2;

        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.titleSize;
                tileNum1 = gp.tM.mapTileNumber[entityLeftCol][entityTopRow];
                tileNum2 = gp.tM.mapTileNumber[entityRightCol][entityTopRow];
                if(gp.tM.tile[tileNum1].collision == true | gp.tM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.titleSize;
                tileNum1 = gp.tM.mapTileNumber[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tM.mapTileNumber[entityRightCol][entityBottomRow];
                if(gp.tM.tile[tileNum1].collision == true | gp.tM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.titleSize;
                tileNum1 = gp.tM.mapTileNumber[entityLeftCol][entityTopRow];
                tileNum2 = gp.tM.mapTileNumber[entityLeftCol][entityBottomRow];
                if(gp.tM.tile[tileNum1].collision == true | gp.tM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gp.titleSize;
                tileNum1 = gp.tM.mapTileNumber[entityRightCol][entityTopRow];
                tileNum2 = gp.tM.mapTileNumber[entityRightCol][entityBottomRow];
                if(gp.tM.tile[tileNum1].collision == true | gp.tM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
        }
    }
}
