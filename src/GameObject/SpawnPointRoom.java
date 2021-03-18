package GameObject;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import Entity.Global.TileType;
import GameObject.LevelItens.ArchAltar;
import GameObject.LevelItens.Totem;
import Graphics.Transition;
import Main.Game;
import Main.HandlerGame;
import Main.KeyInput;
import Main.utils.LoadImage;
import Main.utils.Text.FlashString;
import World.Generator;
import World.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class SpawnPointRoom extends GameObject implements Tickable, Renderable {
    public BufferedImage portal = new LoadImage("/Level/Gate.png").getImage();
    public BufferedImage totem = new LoadImage("/GameObject/Toten.png").getImage();
    private int time;
    private boolean switchLevel;

    public SpawnPointRoom(int x, int y, ID id) {
        super(x, y, id);
        setWidth(16 * 3);
        setHeight(16 * 3);
        setDepth(Depth.PORTAL);
        if (this.getId() == ID.GrassPortal && Generator.room.equals("Dungeon")) {
            Game.handler.add(new ArchAltar(getX() - 100, getY() + 30, ID.Block));
        }else if(this.getId()==ID.Portal){
            Game.handler.add(new Totem(getX()-28,getY()-64,ID.Block,setBufferedImage()));
        }
    }

    @Override
    public void Update() {
        Collision();
        // if(new Random().nextInt(100)<4)  new ParticleHandler().CreateParticlesOval(20,13,getX()+new Random().nextInt(10),getY()+new Random().nextInt(10), (float) new Random().nextInt(3)/2,
        //         (float)new Random().nextInt(3)/2,Color.BLACK);

    }

    int setBufferedImage() {
        for (int i = 0; i < Game.handler.object.size(); i++) {
            GameObject go = Game.handler.object.get(i);
            if (go instanceof Tile) {
                if (((Tile) go).getTileType() == TileType.Grass)
                    if (getY() + 128 == go.getY())return 1;
                    else if(getY()-128==go.getY())return 2;
            }
        }
        return 0;
    }

    void Collision() {
        for (int i = 0; i < Game.handler.object.size(); i++) {
            GameObject ee = Game.handler.object.get(i);
            if (ee.getId() == ID.Player) {
                if (getBounds().intersects(ee.getBounds())) {
                    Game.tran.increase = true;
                    Arrays.fill(KeyInput.press, false);
                    if (Game.tran.alpha > 250) HandlerGame.gen = new Generator(false, "Grass");
                    if (this.getId() == ID.GrassPortal) {
                        FlashString.restart = true;
                        FlashString.start = true;
                        Transition.canshowbyome = true;
                    }
                    //Game.handler.object.remove(this);
                    break;
                }
            }

        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void Render(Graphics g) {
        if (getId() == ID.Default) {
            setDepth(Depth.LITTLE);
            g.setColor(Color.red);
            g.drawImage(new LoadImage("/GameObject/Transition.png").getImage(), getX(), getY(), 32, 32, null);
        }
    }
}
