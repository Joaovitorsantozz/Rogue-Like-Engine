package GameObject.LevelItens;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.ID;
import Entity.particles.ParticleHandler;
import GameObject.GameObject;
import Main.Game;
import Main.utils.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Pilar extends GameObject implements Renderable, Tickable {
    private BufferedImage act;
    private BufferedImage[]imgs=new BufferedImage[3];
    private int life,tex;
    private BufferedImage particle=new LoadImage("/Level/PilarSlice.png").getImage(),particles[];

    public Pilar(int x, int y, ID id,int tex) {
        super(x, y, id);
        setWidth(32*3);
        setHeight(48*3);
        setDepth(22);
        imgs[2]=new LoadImage("/Level/Pilar.png").getImage();
        imgs[1]=new LoadImage("/Level/BrokenPilar.png").getImage();
        imgs[0]=new LoadImage("/Level/OldBrokenPilar.png").getImage();
        this.act=imgs[tex];
        particles=new LoadImage(null).CutHor(4,0,0,8,8,particle);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX()+32,getY()+getHeight()-24,14*3-20,16);
    }

    @Override
    public void Render(Graphics g) {
        drawDefaultTex(g,act);
    }

    @Override
    public void Update() {
        Collision();

    }
    private void Collision(){
        for(int i=0;i< Game.handler.object.size();i++){
            GameObject go=Game.handler.object.get(i);
            if(go.getId()==ID.Bullet){
                if(go.getBounds().intersects(getBounds())) {
                    new ParticleHandler().CreateParticlesImage(4,10,getX()+32,getY()+getHeight()-24,
                            new Random().nextFloat(),new Random().nextFloat(),particles[new Random().nextInt(4)]);
                    Game.handler.object.remove(go);
                }
            }
        }
    }
}
