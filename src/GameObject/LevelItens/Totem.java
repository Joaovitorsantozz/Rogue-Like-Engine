package GameObject.LevelItens;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import GameObject.GameObject;
import Main.Game;
import Main.utils.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Totem extends GameObject implements Tickable, Renderable {
    private BufferedImage toten,uptoten=new LoadImage("/GameObject/Toten.png").getImage(),
            backtoten=new LoadImage("/GameObject/BackTotem.png").getImage();
    public Totem(int x, int y, ID id,int tex) {
        super(x, y, id);
        setDepth(Depth.HIGHT+10);
        if(tex==1){
            toten=uptoten;
        }else{
            toten=backtoten;
        }
        setWidth(toten.getWidth());
        setHeight(toten.getHeight());
    }

    @Override
    public void Render(Graphics g) {
        drawDefaultTex(g,toten);
        DrawBounds((Graphics2D)g);
    }

    @Override
    public void Update() {
        for(int i=0;i< Game.handler.object.size();i++){
            GameObject ee=Game.handler.object.get(i);
            if(ee instanceof Rock){
                if(getBounds().intersects(ee.getBounds()))Game.handler.object.remove(ee);
            }
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX()+24,getY()+getHeight()-10,48,10);
    }
}
