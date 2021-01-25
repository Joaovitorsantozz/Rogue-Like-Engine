package GameObject.LevelItens;

import EngineInterfaces.Renderable;
import Entity.Global.Depth;
import Entity.Global.ID;
import GameObject.GameObject;
import Main.HandlerGame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Rock extends GameObject implements Renderable {
    public BufferedImage rock= HandlerGame.grassspr.getSprite(40,0,19,16);
    public Rock(int x, int y, ID id) {
        super(x, y, id);
        this.spr=rock;
        setWidth(19*3);
        setHeight(16*3);
        setDepth(Depth.MEDIUM);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
    public Rectangle[] getOtherBounds(){return null;}
    @Override
    public void Render(Graphics g) {
        drawDefaultTex(g,rock);
    }
}
