package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Henry extends SuperObject{

    public Henry(){
        name = "Henry";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/henry.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
