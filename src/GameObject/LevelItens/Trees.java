package GameObject.LevelItens;

import EngineInterfaces.Renderable;
import Entity.Global.Depth;
import Entity.Global.ID;
import GameObject.GameObject;
import Main.utils.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Trees extends GameObject implements Renderable {
    private BufferedImage tree=new LoadImage("/GameObject/Spruce.png").getImage();
    private BufferedImage bush=new LoadImage("/GameObject/Bush.png").getImage();
    private BufferedImage[] imgs=new BufferedImage[2];
    public Trees(int x, int y, ID id,int tex) {
        super(x, y, id);
        imgs[0]=tree;
        imgs[1]=bush;
        this.spr=imgs[tex];
        setWidth(spr.getWidth()*3);
        setHeight(spr.getHeight()*3);
        setDepth(Depth.MEDIUM);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(0,0,32,32);
    }

    @Override
    public void Render(Graphics g) {
        drawDefaultTex(g,spr);
    }
}
