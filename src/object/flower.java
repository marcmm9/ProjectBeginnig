package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class flower extends SuperObject{

    public flower(){
        name = "flower";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/flowers.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
