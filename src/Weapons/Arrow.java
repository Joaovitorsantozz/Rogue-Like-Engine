package Weapons;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import GameObject.GameObject;
import Main.Game;
import Main.HandlerGame;

import java.awt.*;

public class Arrow extends GameObject implements Tickable, Renderable {
    public double angle;
    public int speed = 10;
    public int life;

    public Arrow(int x, int y, ID id, double dx, double dy, double angle) {
        super(x, y, id);
        this.velX = (float) dx;
        this.velY = (float) dy;
        this.spr = HandlerGame.spr.getSprite(32, 48, 16, 16);
        setWidth(16 * 3);
        setHeight(16 * 3);
        setDepth(Depth.MEDIUM);
        this.angle = angle;
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public void Render(Graphics g) {
        g.setColor(Color.gray);
        g.fillOval(getX(), getY(), 16, 16);
    }

    @Override
    public void Update() {
        x += speed * velX;
        y += speed * velY;

        life++;
        if (life > 120) {
            Game.handler.DeleteObject(this);
        }
    }
}
