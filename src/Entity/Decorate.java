package Entity;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import GameObject.GameObject;
import Main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Decorate extends GameObject implements Renderable, Tickable {
    private final BufferedImage spr;

    public Decorate(int x, int y, ID id, BufferedImage spr) {
        super(x, y, id);
        this.spr = spr;
        setWidth(32);
        setHeight(32);
        setDepth(Depth.HIGHT);
    }

    @Override
    public void Render(Graphics g) {
        drawDefaultTex(g, spr);
    }

    @Override
    public void Update() {
        checkCol();
    }

    private void checkCol() {
        for (int i = 0; i < Game.handler.object.size(); i++) {
            GameObject ee = Game.handler.object.get(i);
            if (ee.getId() == ID.Block) {
                if (getBounds().intersects(ee.getBounds())) {
                    Game.handler.DeleteObject(this);
                    break;
                }
            }
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

}
