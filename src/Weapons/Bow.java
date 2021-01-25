package Weapons;

import EngineInterfaces.Renderable;
import Entity.Global.Depth;
import Entity.Global.ID;
import GameObject.GameObject;
import Main.HandlerGame;
import Main.utils.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bow extends WeaponBase implements Renderable {
    BufferedImage sprite= HandlerGame.spr.getSprite(16,48,16,16);
    public Bow(int x, int y, int damage, ID id) {
        super(x, y, damage, id);
        this.spr= HandlerGame.spr.getSprite(16,48,16,16);
        setDepth(Depth.MEDIUM);
        setHeight(48);
        setWidth(48);
    }

    @Override
    public void Attack() {

    }

    @Override
    public void Render(Graphics g) {
        if(owner!=null){
            setX(owner.getX()+32);
            setY(owner.getY());
            drawDefaultTex(g,sprite);
        }

    }

}
