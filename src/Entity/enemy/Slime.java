package Entity.enemy;

import EngineInterfaces.LivingEntity;
import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import Entity.particles.ParticleHandler;
import GameObject.GameObject;
import Main.Game;
import Main.HandlerGame;
import Main.utils.Animator;
import Main.utils.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import GameObject.GameObjectHandler;

public class Slime extends GameObject implements Tickable, Renderable, LivingEntity {
    private Animator anim;
    private BufferedImage spr = new LoadImage("/GameObject/Enemy/Slime.png").getImage();
    private BufferedImage[] animation = new LoadImage(null).Cut(10, 0, 0, 16, 16, spr);
    private float speed = 2.2f;
    public int life = 25;
    private boolean isdamage;
    int cur;
    private GameObjectHandler hand = new GameObjectHandler();
    public Slime(int x, int y, ID id) {
        super(x, y, id);
        anim = new Animator(2, 10);
        anim.setAnimation(animation);
        setDepth(Depth.MEDIUM + 10);
        setWidth(16 * 3);
        setHeight(16 * 3);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void Render(Graphics g) {
        if (!isdamage) {
            drawDefaultTex(g, anim.getAnimation());
        } else {
            cur++;
            if(cur<5) {
                drawDefaultTex(g, spr.getSubimage(0, spr.getHeight() - 16, 16, 16));
            }else{
                isdamage=false;
                cur=0;
            }
        }
    }

    @Override
    public void Update() {
        x += velX;
        y += velY;
        Move();
        Collision();
        Move(hand,speed);
        if (life <= 0) {
            Game.handler.DeleteObject(this);
            Game.handlergame.cam.setX(Game.handlergame.cam.getX() + new Random().nextInt(40));
            Game.handlergame.cam.setY(Game.handlergame.cam.getY() + new Random().nextInt(40));
            new ParticleHandler().CreateParticlesImage(20,25,getX(),getY(),
                    new Random().nextFloat()*2,new Random().nextFloat()*2, HandlerGame.spr.getSprite(37,83,6,6));
        }
    }

    private void Move() {
        for (int i = 0; i < Game.handler.object.size(); i++) {
            GameObject ee = Game.handler.object.get(i);
            if (ee.getId() == ID.Player) {
                hand.setRight(this.getX() < ee.getX());
                hand.setLeft(this.getX() > ee.getX());
                hand.setDown(this.getY() < ee.getY());
                hand.setUp(this.getY() > ee.getY());
            }
        }
    }

    private void Collision() {
        for (int i = 0; i < Game.handler.object.size(); i++) {
            GameObject ee = Game.handler.object.get(i);
            if (ee.getId() == ID.Block) {
                if (getBounds().intersects(ee.getBounds())) {
                    x += velX * -1;
                    y += velY * -1;
                }
            } else if (ee.getId() == ID.Bullet) {
                if (ee.getBounds().intersects(getBounds())) {
                    life -= 5;
                    isdamage = true;
                    Game.handler.object.remove(ee);
                }
            }
            if (ee.getId() == ID.Enemy) {
                if (ee == this) {
                    continue;
                }
                if (getBounds().intersects(ee.getBounds())) {
                    x += velX * -1;
                    y += velY * -1;
                }
            }
        }
    }
}
