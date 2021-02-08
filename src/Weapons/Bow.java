package Weapons;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import GameObject.GameObject;
import Main.HandlerGame;
import Main.utils.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bow extends WeaponBase implements Renderable, Tickable {
    BufferedImage sprite = HandlerGame.spr.getSprite(16, 48, 16, 16);
    public static double mx, my, angle;

    public Bow(int x, int y, int damage, ID id) {
        super(x, y, damage, id);
        this.spr = HandlerGame.spr.getSprite(16, 48, 16, 16);
        setDepth(Depth.MEDIUM);
        setHeight(48);
        setWidth(48);
    }

    @Override
    public void Attack() {
        if (handler.isAttack()) {
            handler.setAttack(false);
            float dx = (float) Math.cos(angle);
            float dy = (float) Math.sin(angle);
            handler.add(new Arrow((owner.getX()+4)*owner.getDir(),owner.getY()+16, ID.Default, dx, dy, angle + 90));
        }
    }

    @Override
    public void Render(Graphics g) {
        if (owner != null) {
            angle = Math.atan2(my - this.getY(), mx - this.getX());
            setX(owner.getX()+48);
            setY(owner.getY()+24);
            ((Graphics2D) g).rotate(angle, getX()-getWidth()/2f, getY());
            drawDefaultTex(g, sprite);
            g.fillRect((owner.getX()+4)*owner.getDir(),owner.getY()+16,16,16);
            ((Graphics2D) g).rotate(-angle, getX()-getWidth()/2f, getY());
            System.out.println(angle);

        }
    }

    @Override
    public void Update() {
        angle=Math.atan2(my-this.getY(),mx-this.getX());
        Attack();
    }
}
