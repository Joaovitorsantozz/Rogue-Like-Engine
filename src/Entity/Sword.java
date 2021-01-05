package Entity;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import GameObject.GameObject;
import Main.HandlerGame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sword extends GameObject implements Tickable, Renderable {
    private BufferedImage sword = HandlerGame.spr.getSprite(0, 48, 16, 16);
    private GameObject owner;
    public float rx, ry;
    public int centerx, centery;

    public Sword(int x, int y, ID id, GameObject owner) {
        super(x, y, id);
        setWidth(48);
        setHeight(48);
        setDepth(Depth.MEDIUM);
        this.owner = owner;
        centerx = getWidth() / 2;
        centery = getHeight() / 2;
    }

    @Override
    public void Render(Graphics g) {
        if (owner.getDir() == 1) {
            //right
            setX(owner.getX() + 36);
            setY(owner.getY());
            drawDefaultTex(g, sword);
        } else if (owner.getDir() == -1) {
            //left
            setX(owner.getX() - 32);
            setY(owner.getY());
            g.drawImage(sword,getX()+44,getY(),getWidth()*-1,getHeight(),null);
        } else if (owner.getDir() == 2) {
            //up
            setY(owner.getY()+32);
            g.drawImage(sword,getX(),getY(),getWidth(),getHeight(),null);
        } else if (owner.getDir() == -2) {
            //down
            setY(owner.getY()-32);
            g.drawImage(sword,getX()+44,getY(),getWidth()*-1,getHeight(),null);
        }

    }

    @Override
    public void Update() {

    }



    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}
