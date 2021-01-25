package GameObject.LevelItens;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import GameObject.GameObject;
import Main.utils.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;


public class ArchAltar extends GameObject implements Tickable, Renderable {
    public BufferedImage altar=new LoadImage("/Level/Gate.png").getImage();
    public ArchAltar(int x, int y, ID id) {
        super(x, y, id);
        this.spr=altar;
        setWidth(altar.getWidth()*4);
        setHeight(altar.getHeight()*4);
        setDepth(Depth.PORTAL);
    }

    @Override
    public void Render(Graphics g) {
        drawDefaultTex(g,altar);


    }

    @Override
    public void Update() {

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(),getY()+getHeight()-10,70,10);
    }
    public Rectangle getOtherBounds() {
        return new Rectangle(getX()+getWidth()-68,getY()+getHeight()-10,70,10);
    }
}
