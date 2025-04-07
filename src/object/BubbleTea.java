package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BubbleTea extends SuperObject{
    public BubbleTea() {
        name = "bubbleTea";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/bubble_tea.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
