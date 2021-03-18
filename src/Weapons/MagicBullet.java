package Weapons;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import Entity.particles.ParticleHandler;
import GameObject.GameObject;
import GameObject.LevelItens.Pilar;
import Main.Game;
import Main.HandlerGame;
import Main.utils.Animator;
import Main.utils.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MagicBullet extends WeaponBase implements Renderable, Tickable {
    public double angle;
    public int speed = 15;
    public int life;
    public BufferedImage animation[];
    Animator anim;
    public MagicBullet(int x, int y, ID id, int damage, double dx, double dy, double angle) {
        super(x, y, damage, id);
        this.velX = (float) dx;
        this.velY = (float) dy;
        this.spr = new LoadImage("/GameObject/fireball.png").getImage();
        animation = new LoadImage(null).CutHor(7, 0, 0, 16, 16, spr);
        setWidth(16 * 3);
        setHeight(16 * 3);
        setDepth(Depth.MEDIUM - 1);
        this.angle = angle;
        anim = new Animator(10, 7);
    }

    @Override
    public void Attack() {

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void Render(Graphics g) {
        anim.setAnimation(animation);
        ((Graphics2D) g).rotate(angle, getX() + getWidth() / 2f, getY());
        drawDefaultTex(g, anim.getAnimSolo());
        ((Graphics2D) g).rotate(-angle, getX() + getWidth() / 2f, getY());
    }

    @Override
    public void Update() {
        x += speed * velX;
        y += speed * velY;
        if (new Random().nextInt(100) < 30) {
            new ParticleHandler().CreateParticlesImage(10, 10, getX() + new Random().nextInt(30)
                    , getY() - new Random().nextInt(30), 0, getDir() / 10F, HandlerGame.spr.getSprite(22, 83, 6, 6));
        }
        life++;
        if (life > 120) {
            Game.handler.DeleteObject(this);
        }
        Collision();
    }

    private void Collision() {
        for (int i = 0; i < Game.handler.object.size(); i++) {
            GameObject ee = Game.handler.object.get(i);
            if (ee.getId() == ID.Block&&!(ee instanceof Pilar)) {
                if (getBounds().intersects(ee.getBounds())) {
                    new ParticleHandler().CreateParticlesRectPerfect(70,15,getX(),getY(),4,
                            new Random().nextFloat(),new Random().nextFloat(),new Color(104,194,211));
                    Game.handler.object.remove(this);
                }
            }
        }
    }
}
