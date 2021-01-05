package Entity;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import GameObject.GameObject;
import GameObject.GameObjectHandler;
import Main.Game;
import Main.HandlerGame;
import Main.utils.Animator;
import Main.utils.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject implements Tickable, Renderable {
    public GameObjectHandler hand;
    public float speed = 5f, jumpforce = 15f;
    private BufferedImage spr = new LoadImage("/GameObject/Player.png").getImage(), anim[], idle[];
    private int maxFrames = 20, maxIndex = 3;
    Animator an;

    public Player(int x, int y, ID id, GameObjectHandler hand) {
        super(x, y, id);
        // TODO Auto-generated constructor stub
        this.hand = hand;
        this.dir = 1;
        setDepth(Depth.HIGHT + 2);
        setWidth(16 * 3);
        setHeight(16 * 3);
        an = new Animator(maxFrames, maxIndex);
        anim = new LoadImage("/GameObject/Player.png").CutHor(3, 0, 0, 16, 16, spr);
        idle = new LoadImage("/GameObject/Player.png").CutHor(3, 0, 16, 16, 16, spr);
        //////////////////
    }

    @Override
    public void Update() {
        x += getVelX();
        y += getVelY();
        // Call Methods//
        Col();
        Move(this.hand, speed);

    }


    protected void Col() {
        for (int i = 0; i < Game.handler.object.size(); i++) {
            GameObject e = Game.handler.object.get(i);
            if (e.getId() == ID.Block) {
                if (getBounds().intersects(e.getBounds())) {
                    x += getVelX() * -1;
                    y += getVelY() * -1;
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

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }


}