package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Flower extends SuperObject{

    public Flower(){
        name = "flower";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/flower.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
