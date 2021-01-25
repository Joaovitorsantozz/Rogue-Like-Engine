package World.Templates;

import Main.utils.LoadImage;

import java.awt.image.BufferedImage;

public class GrassTemplate {
    public BufferedImage[]bottom;
    public BufferedImage[]right;
    public BufferedImage[]left;
    public BufferedImage[]top;
    public GrassTemplate(){
        //bottom door rooms
        bottom=new BufferedImage[3];
        bottom[0]=new LoadImage("/Level/GrassTemplate/B.png").getImage();
        bottom[1]=new LoadImage("/Level/GrassTemplate/RB.png").getImage();
        bottom[2]=new LoadImage("/Level/GrassTemplate/TB.png").getImage();
        //Top door rooms
        top=new BufferedImage[4];
        top[0]=new LoadImage("/Level/GrassTemplate/T.png").getImage();
        top[1]=new LoadImage("/Level/GrassTemplate/TB.png").getImage();
        top[2]=new LoadImage("/Level/GrassTemplate/TL.png").getImage();
        top[3]=new LoadImage("/Level/GrassTemplate/TR.png").getImage();
        //right door rooms
        left=new BufferedImage[3];
        left[0]=new LoadImage("/Level/GrassTemplate/L.png").getImage();
        left[1]=new LoadImage("/Level/GrassTemplate/LR.png").getImage();
        left[2]=new LoadImage("/Level/GrassTemplate/TL.png").getImage();
        //left door rooms
        right=new BufferedImage[4];
        right[0]=new LoadImage("/Level/GrassTemplate/LR.png").getImage();
        right[1]=new LoadImage("/Level/GrassTemplate/R.png").getImage();
        right[2]=new LoadImage("/Level/GrassTemplate/RB.png").getImage();
        right[3]=new LoadImage("/Level/GrassTemplate/TR.png").getImage();
    }
}
