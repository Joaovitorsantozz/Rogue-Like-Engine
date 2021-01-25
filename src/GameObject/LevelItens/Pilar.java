package GameObject.LevelItens;

import EngineInterfaces.Renderable;
import Entity.Global.ID;
import GameObject.GameObject;
import Main.utils.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pilar extends GameObject implements Renderable {
    private BufferedImage act;
    private BufferedImage[]imgs=new BufferedImage[3];

    public Pilar(int x, int y, ID id,int tex) {
        super(x, y, id);
        setWidth(32*3);
        setHeight(48*3);
        setDepth(22);
        imgs[0]=new LoadImage("/Level/Pilar.png").getImage();
        imgs[1]=new LoadImage("/Level/BrokenPilar.png").getImage();
        imgs[2]=new LoadImage("/Level/OldBrokenPilar.png").getImage();
        this.act=imgs[tex];
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX()+32,getY()+getHeight()-24,14*3-20,16);
    }
    public Rectangle[] getOtherBounds(){return null;}
    @Override
    public void Render(Graphics g) {
        drawDefaultTex(g,act);
    }
}
