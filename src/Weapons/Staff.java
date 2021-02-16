package Weapons;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import Main.Game;
import Main.HandlerGame;
import Main.MouseMotion;
import Main.utils.Animator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Staff extends WeaponBase implements Renderable, Tickable {
    private double angle;
    float dx, dy;
    private BufferedImage sprite = HandlerGame.spr.getSprite(48, 48, 16, 16);
    private int knockback;
    private boolean activeKnockback;

    public Staff(int x, int y, int damage, ID id) {
        super(x, y, damage, id);
        this.spr = sprite;
        setWidth(48);
        setHeight(48);
        setDepth(Depth.MEDIUM);
    }

    @Override
    public void Render(Graphics g) {
        if (owner != null) {
            setX(owner.getX() + 48);
            setY(owner.getY() + 4);
            ((Graphics2D) g).rotate(angle, owner.getX() + getWidth() / 2f, owner.getY() + 30);
            drawDefaultTex(g, sprite);
            ((Graphics2D) g).rotate(-angle, owner.getX() + getWidth() / 2f, owner.getY() + 30);

        }
    }

    @Override
    public void Update() {
        if (owner != null) Attack();
    }

    @Override
    public void Attack() {
        angle = Math.atan2(MouseMotion.mouseY - getY(), MouseMotion.mouseX - getX());
        if (handler.isAttack()) {
            activeKnockback = true;
            handler.setAttack(false);
            dx = (float) Math.cos(angle);
            dy = (float) Math.sin(angle);
            handler.add(new MagicBullet((int) ((getX() + getWidth() / 2f) - 40), (int) (getY() + getHeight() / 2f), ID.Bullet, this.damage, dx, dy, angle + 90));
        }

    }

    private int KnockBack() {
        if (knockback < 10) {
            knockback++;
        } else {
            knockback = 0;
            activeKnockback = false;
        }
        return knockback;
    }
}
