package Weapons;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import Graphics.UI.ManaBar;
import Graphics.UI.UI;
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
    private boolean activeKnockback, canAttack;
    private boolean overflow;
    Animator animator;
    private BufferedImage[]anim=new BufferedImage[2];
    public Staff(int x, int y, int damage, ID id) {
        super(x, y, damage, id);
        anim[0]=sprite;
        anim[1]=HandlerGame.spr.getSprite(64,48,16,16);
        this.spr = sprite;
        setWidth(48);
        setHeight(48);
        setDepth(Depth.MEDIUM);
        animator=new Animator(5,2);
        animator.setAnimation(anim);
    }

    @Override
    public void Render(Graphics g) {
        if (owner != null) {
            setX(owner.getX() + 48);
            setY(owner.getY() + 4);
            ((Graphics2D) g).rotate(angle, owner.getX() + getWidth() / 2f, owner.getY() + 30);
            if(overflow){
                drawDefaultTex(g,animator.getAnimation());
            }else{
                drawDefaultTex(g,sprite);
            }
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
            for (UI ui : Game.handler.uiHandler.UI) {
                if (ui instanceof ManaBar) {
                    if (((ManaBar) ui).actualmana > 0) {
                        ((ManaBar) ui).decrease = true;
                        if (!((ManaBar) ui).increase) {
                            handler.add(new MagicBullet((int) ((getX() + getWidth() / 2f) - 40), (int) (getY() + getHeight() / 2f), ID.Bullet, this.damage, dx, dy, angle + 90));
                        }
                    }
                }
            }
        }
        for (UI ui : Game.handler.uiHandler.UI) {
            if (ui instanceof ManaBar) {
                if(((ManaBar) ui).increase)overflow=true;
                else overflow=false;
            }
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
