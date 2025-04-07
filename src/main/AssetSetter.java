package src.main;

import src.object.BubbleTea;
import src.object.Henry;
import src.object.Flower;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new Henry();
        gp.obj[0].worldX = 5 * gp.titleSize; //spawn position Henry
        gp.obj[0].worldY = 5 * gp.titleSize;

        gp.obj[1] = new Flower();
        gp.obj[1].worldX = 10* gp.titleSize;
        gp.obj[1].worldY = 10* gp.titleSize;

        gp.obj[2] = new BubbleTea();
        gp.obj[2].worldX = 5 * gp.titleSize;
        gp.obj[2].worldY = 10* gp.titleSize;
    }
}
