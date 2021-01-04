package World;

import GameObject.GameObject;
import Main.utils.LoadImage;

import java.awt.image.BufferedImage;

public class RoomTemplates {
    public BufferedImage[]bottom;
    public BufferedImage[]right;
    public BufferedImage[]left;
    public BufferedImage[]top;

    public RoomTemplates(){
        //bottom door rooms
        bottom=new BufferedImage[3];
        bottom[0]=new LoadImage("/Level/RoomTemplates/B.png").getImage();
        bottom[1]=new LoadImage("/Level/RoomTemplates/RB.png").getImage();
        bottom[2]=new LoadImage("/Level/RoomTemplates/TB.png").getImage();
        //Top door rooms
        top=new BufferedImage[4];
        top[0]=new LoadImage("/Level/RoomTemplates/T.png").getImage();
        top[1]=new LoadImage("/Level/RoomTemplates/TB.png").getImage();
        top[2]=new LoadImage("/Level/RoomTemplates/TL.png").getImage();
        top[3]=new LoadImage("/Level/RoomTemplates/TR.png").getImage();
        //right door rooms
        left=new BufferedImage[3];
        left[0]=new LoadImage("/Level/RoomTemplates/L.png").getImage();
        left[1]=new LoadImage("/Level/RoomTemplates/LR.png").getImage();
        left[2]=new LoadImage("/Level/RoomTemplates/TL.png").getImage();
        //left door rooms
        right=new BufferedImage[4];
        right[0]=new LoadImage("/Level/RoomTemplates/LR.png").getImage();
        right[1]=new LoadImage("/Level/RoomTemplates/R.png").getImage();
        right[2]=new LoadImage("/Level/RoomTemplates/RB.png").getImage();
        right[3]=new LoadImage("/Level/RoomTemplates/TR.png").getImage();
    }
}
