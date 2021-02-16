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
            if (owner.getDir() == 1) {
               // if(mx>owner.getX())
             //   handler.add(new Arrow((int) (getX() + getWidth() / 2f), (int) (getY() + getHeight() / 2f), ID.Default, dx, dy, angle + 90));
            } else if (owner.getDir() == -1) {
              //  if(mx<owner.getX())
              //  handler.add(new Arrow((int) (getX() + getWidth() / 2f), (int) (getY() + getHeight() / 2f), ID.Default, dx, dy, angle + 90));
            }
        }
    }

    @Override
    public void Render(Graphics g) {
        double angle2 = (Math.atan2(my - this.getY(), mx - this.getX()) * (360 / Math.PI * 2));
        if (owner != null) {
            setY(owner.getY() + 4);
            if (owner.getDir() == 1) {
                drawDefaultTex(g, sprite);
                setX(owner.getX() + 48);
            } else if (owner.getDir() == -1) {
                drawDefaultTexInv(g, sprite);
                setX(owner.getX() - 48);
            }
        }
    }

    @Override
    public void Update() {
        angle = Math.atan2(my - this.getY(), mx - this.getX());
        if(owner!=null)Attack();
    }
}
