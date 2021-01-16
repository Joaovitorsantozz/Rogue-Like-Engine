package World.Templates;

import Main.utils.LoadImage;

import java.awt.image.BufferedImage;

public class GrassByome extends RoomTemplates{
    public BufferedImage[]bottomg;
    public BufferedImage[] rightg;
    public BufferedImage[]leftg;
    public BufferedImage[] topg;
    public GrassByome(){
        this.bottom=bottomg;
        this.top=topg;
        this.left=leftg;
        this.right=rightg;
        bottomg=new BufferedImage[3];
        bottomg[0]=new LoadImage("/Level/RoomTemplates/B.png").getImage();
        bottomg[1]=new LoadImage("/Level/RoomTemplates/RB.png").getImage();
        bottomg[2]=new LoadImage("/Level/RoomTemplates/TB.png").getImage();
        //Top door rooms
        topg =new BufferedImage[4];
        topg[0]=new LoadImage("/Level/RoomTemplates/T.png").getImage();
        topg[1]=new LoadImage("/Level/RoomTemplates/TB.png").getImage();
        topg[2]=new LoadImage("/Level/RoomTemplates/TL.png").getImage();
        topg[3]=new LoadImage("/Level/RoomTemplates/TR.png").getImage();
        //right door rooms
        leftg=new BufferedImage[3];
        leftg[0]=new LoadImage("/Level/RoomTemplates/L.png").getImage();
        leftg[1]=new LoadImage("/Level/RoomTemplates/LR.png").getImage();
        leftg[2]=new LoadImage("/Level/RoomTemplates/TL.png").getImage();
        //left door rooms
        rightg =new BufferedImage[4];
        rightg[0]=new LoadImage("/Level/RoomTemplates/LR.png").getImage();
        rightg[1]=new LoadImage("/Level/RoomTemplates/R.png").getImage();
        rightg[2]=new LoadImage("/Level/RoomTemplates/RB.png").getImage();
        rightg[3]=new LoadImage("/Level/RoomTemplates/TR.png").getImage();
    }
}
