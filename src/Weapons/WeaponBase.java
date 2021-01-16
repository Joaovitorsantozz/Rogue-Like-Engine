package Weapons;

import Entity.Global.ID;
import GameObject.GameObject;
import Main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import GameObject.GameObjectHandler;
public abstract class WeaponBase extends GameObject {
    protected BufferedImage weapon;
    private int damage;
    public GameObject owner;
    public GameObjectHandler handler;
    public WeaponBase(int x, int y, int damage, ID id) {
        super(x, y, id);
        this.id = id;
        this.damage = damage;
        this.handler= Game.handler;
    }

    public void setWeapon(BufferedImage weapon) {
        this.weapon = weapon;
    }

    public BufferedImage getWeapon() {
        return weapon;
    }
    public abstract void Attack();

    @Override
    public Rectangle getBounds() {
        return null;
    }

    public GameObject getOwner() {
        return owner;
    }

    public void setOwner(GameObject owner) {
        this.owner = owner;
    }

}
