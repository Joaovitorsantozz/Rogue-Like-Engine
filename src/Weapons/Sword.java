package Weapons;

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

public class Sword extends WeaponBase implements Tickable, Renderable {
    private BufferedImage sword = HandlerGame.spr.getSprite(0, 48, 16, 16);
    Animator anim = new Animator(10, 4);
    BufferedImage sheet = new LoadImage("/GameObject/Attack/atc.png").getImage(), anima[];
    private boolean attack;
    public double rx = 0, ry = 0;
    int tx = 0, ty = 0;
    double rot = 0;

    public Sword(int x, int y, int damage, ID id) {
        super(x, y, damage, id);
        setWidth(48);
        setHeight(48);
        setDepth(Depth.MEDIUM);
        anima = new LoadImage(null).Cut(4, 0, 0, 16, 16, sheet);
        anim.setAnimation(anima);
        this.spr=sword;
    }

    @Override
    public void Render(Graphics g) {
        if(owner!=null) {
            if (owner.getDir()==-1) {
                g.drawImage(sword, getX() + 44, getY(), getWidth() * -1, getHeight(), null);
                setX(owner.getX() - 32);
                setY(owner.getY());
            } else if (owner.getDir()==1) {
                drawDefaultTex(g, sword);
                setX(owner.getX() + 32);
                setY(owner.getY());
            }
            DrawAttack(g);
            //  g.fillRect(owner.getX()+owner.getWidth(),owner.getY(),16,16);
            //  g.fillRect(owner.getX()-owner.getWidth() ,owner.getY(),16,16);
                g.fillRect(owner.getX()+14,owner.getY(),16,16);
                g.fillRect((int)rx,(int)ry,16,16);
                g.fillRect(getX(),getY(),4,4);
        }

    }

    private void DrawAttack(Graphics g) {
        if (attack) {
            if (rx>owner.getX()+14) {
                //direita
                anim.setAnimation(anima);
                g.drawImage(anim.getAnimSolo(), getX() + 96, getY() - 20, getWidth() * -3, getHeight() * 2, null);
            } else if (rx<owner.getX()+14) {
                anim.setAnimation(anima);
                g.drawImage(anim.getAnimSolo(), getX() - 116, getY() - 30, getWidth() * 3, getHeight() * 2, null);
            }
        }

}


    @Override
    public void Update() {
        Attack();
    }

    @Override
    public void Attack() {
        if (this.handler.isAttack()) {
            attack = true;
            handler.setAttack(false);
        }
        if (attack) {
            if (anim.getIndex() == 3) {
                attack = false;
                anim.setIndex(0);
            }
        }

    }

    private double mousePos() {
        double dx = Math.cos(rx - getX()),
                dy = Math.sin(ry - getY());
        return Math.atan2(dy, dx);
    }

    public double dx() {
        return Math.cos(rx - getX());
    }

    public double dy() {
        return Math.sin(ry - getY());
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

}
