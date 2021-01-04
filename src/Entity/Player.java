package Entity;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import GameObject.GameObject;
import GameObject.GameObjectHandler;
import Main.Game;
import Main.HandlerGame;

import java.awt.*;

public class Player extends GameObject implements Tickable, Renderable {
    public GameObjectHandler hand;
    public float speed = 5f,jumpforce=15f;
    public Player(int x, int y, ID id, GameObjectHandler hand) {
        super(x, y, id);
        // TODO Auto-generated constructor stub
        this.hand = hand;
        this.dir = 1;
        setDepth(Depth.HIGHT+2);
        setWidth(16 * 3);
        setHeight(16 * 3);
        //////////////////
    }

    @Override
    public void Update() {
        x += getVelX();
        y += getVelY();
        // Call Methods//
        Col();
        Move(this.hand,speed);

    }


    protected void Col() {
        for (int i = 0; i < Game.handler.object.size(); i++) {
            GameObject e = Game.handler.object.get(i);
            if(e.getId()== ID.Block){
                if(getBounds().intersects(e.getBounds())){
                    x+=getVelX()*-1;
                    y+=getVelY()*-1;
                }
            }
        }
    }

    public void Render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //Anim\\
        g.setColor(Color.blue);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(),getY(),getWidth(),getHeight());
    }


}