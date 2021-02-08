package Entity;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import Entity.particles.ParticleHandler;
import GameObject.GameObject;
import GameObject.GameObjectHandler;
import GameObject.LevelItens.ArchAltar;
import Graphics.UI.Inventory;
import Main.Game;
import Main.HandlerGame;
import Main.utils.Animator;
import Main.utils.LoadImage;
import Weapons.Bow;
import Weapons.Sword;
import Weapons.WeaponBase;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends GameObject implements Tickable, Renderable {
    public GameObjectHandler hand;
    public float speed = 5f;
    private BufferedImage spr = new LoadImage("/GameObject/Player.png").getImage(), anim[], idle[];
    Animator an;
    public WeaponBase equiped;
    public Inventory inventory = Game.handler.uiHandler.inv;
    public boolean attack;
    public Player(int x, int y, ID id, GameObjectHandler hand) {
        super(x, y, id);
        // TODO Auto-generated constructor stub
        this.hand = hand;
        this.dir = 1;
        setDepth(20);
        setWidth(16 * 3);
        setHeight(16 * 3);
        an = new Animator(20, 3);
        anim = new LoadImage("/GameObject/Player.png").CutHor(3, 0, 0, 16, 16, spr);
        idle = new LoadImage("/GameObject/Player.png").CutHor(3, 0, 16, 16, 16, spr);
        //////////////////
        inventory.setItem(1,new Bow(inventory.getX(),inventory.getY(),10,ID.Weapon));
    }

    @Override
    public void Update() {
        x += getVelX();
        y += getVelY();
        // Call Methods//
        Col();
        Move(this.hand, speed);

        setItensByInventory();
    }

    private void setItensByInventory() {
        if (inventory.getObjectIndex(inventory.getOnslot()) != null) {
            if (this.equiped == null) {
                this.equiped = inventory.getObjectIndex(inventory.getOnslot());
                inventory.storage[inventory.getOnslot()].setOwner(HandlerGame.player);
            } else {
                this.equiped.setOwner(null);
                this.equiped = inventory.getObjectIndex(inventory.getOnslot());
                inventory.storage[inventory.getOnslot()].setOwner(HandlerGame.player);
            }
        } else {
            if (this.equiped != null) {
                this.equiped.setOwner(null);
                this.equiped = null;
            }
        }
    }

    protected void Col() {
        for (int i = 0; i < Game.handler.object.size(); i++) {
            GameObject e = Game.handler.object.get(i);
            if(!(e instanceof ArchAltar)) {
                if (e.getId() == ID.Block) {
                    if (getBounds().intersects(e.getBounds())) {
                        x += velX * -1;
                        y += velY * -1;
                    }
                }
            }else{
                if(getBounds().intersects(e.getBounds())||getBounds().intersects(((ArchAltar) e).getOtherBounds())){
                    x += velX * -1;
                    y += velY * -1;
                }
            }
        }
    }

    public void Render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //Anim\\
        if (Move(hand, speed)) {
            an.setAnimation(anim);
            an.setMaxFrames(25);
            CreateParticles();
        } else {
            an.setAnimation(idle);
            an.setMaxFrames(40);
        }
        if (getDir() != 1) {
            g.drawImage(an.getAnimation(), getX() + 44, getY(), getWidth() * -1, getHeight(), null);
        } else if (getDir() != -1) {
            drawDefaultTex(g, an.getAnimation());
        }
    }

    private void CreateParticles() {
        if (hand.isRight()) {
            if (new Random().nextInt(100) < 10) {
                new ParticleHandler().CreateParticlesOval(2, 10, getX() + new Random().nextInt(10)
                        , getY() + getHeight() - 10, 0, getDir() / 10F, Color.white);
            }
        } else if (hand.isLeft()) {
            if (new Random().nextInt(100) < 10) {
                new ParticleHandler().CreateParticlesOval(2, 10, (getX() + getWidth()) + new Random().nextInt(10)
                        , getY() + getHeight() - 10, 0, getDir() / 10F, Color.white);
            }
        } else if (hand.isUp()) {
            if (new Random().nextInt(100) < 10) {
                new ParticleHandler().CreateParticlesOval(2, 10, (getX() + 5) + new Random().nextInt(10)
                        , getY() + getHeight() - 10, 0, getDir() / 10F, Color.white);
            }
        } else if (hand.isDown()) {
            if (new Random().nextInt(100) < 10) {
                new ParticleHandler().CreateParticlesOval(2, 10, getX() + new Random().nextInt(10)
                        , getY() - 10, 0, getDir() / 10F, Color.white);
            }
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

}