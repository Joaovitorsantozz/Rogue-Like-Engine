package Entity.enemy;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import GameObject.GameObject;
import Main.Game;
import Main.utils.Animator;
import Main.utils.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import GameObject.GameObjectHandler;
public class Slime extends GameObject implements Tickable, Renderable {
    private Animator anim;
    private BufferedImage spr = new LoadImage("/GameObject/Enemy/Slime.png").getImage();
    private BufferedImage[] animation = new LoadImage(null).Cut(10, 0, 0, 16, 16, spr);
    private float speed =2.2f;
    private GameObjectHandler hand=new GameObjectHandler();
    public Slime(int x, int y, ID id) {
        super(x, y, id);
        anim = new Animator(2, 10);
        anim.setAnimation(animation);
        setDepth(Depth.MEDIUM+10);
        setWidth(16 * 3);
        setHeight(16 * 3);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void Render(Graphics g) {
        drawDefaultTex(g, anim.getAnimation());
    }

    @Override
    public void Update() {
        x += velX;
        y += velY;
        Collision();
        Move();
    }

    private void Move() {
        for (int i = 0; i < Game.handler.object.size(); i++) {
            GameObject ee=Game.handler.object.get(i);
            if(ee.getId()==ID.Player){
              if(this.getX()<ee.getX())velX=speed;
              else if(this.getX()>ee.getX())velX=-speed;

              if(this.getY()<ee.getY())velY=speed;
              else if(this.getY()>ee.getY())velY=-speed;

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
            }
            if(ee.getId()==ID.Enemy){
                if(ee==this){
                    continue;
                }
                if (ee.getBounds().intersects(getBounds())) {
                    x += velX * -1;
                    y += velY * -1;
                }
            }
        }
    }
}
