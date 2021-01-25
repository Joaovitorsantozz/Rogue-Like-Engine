package GameObject.LevelItens;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import GameObject.GameObject;
import Main.HandlerGame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Grass extends GameObject implements Renderable {
    public BufferedImage grass;
    public Grass(int x, int y, ID id) {
        super(x, y, id);
        if(new Random().nextInt(2)==0){
            grass= HandlerGame.grassspr.getSprite(16,0,16,16);
        }else{
            grass= HandlerGame.grassspr.getSprite(16,16,16,16);
        }
        setDepth(Depth.MEDIUM);
        setWidth(16*3);
        setHeight(16*3);
    }

    @Override
    public void Render(Graphics g) {
        drawDefaultTex(g,grass);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
