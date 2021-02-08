package World;

import Entity.Global.ID;
import Entity.Global.TileType;
import Entity.Player;
import GameObject.Camera;
import GameObject.SpawnPointRoom;
import Main.Game;
import Main.HandlerGame;
import Main.utils.LoadImage;
import Weapons.Sword;

import java.awt.image.BufferedImage;

public class Level extends World {
    public int[] p;
    private Player player;
    private Camera camera;

    public Level(BufferedImage level) {
        super(level);
        setSpr(level);
        setWidth(level.getWidth());
        setHeight(level.getHeight());
        for (int xx = 0; xx < level.getWidth(); xx++) {
            for (int yy = 0; yy < level.getHeight(); yy++) {
                p = new int[getWidth() * getHeight()];
                int pa = spr.getRGB(xx, yy);
                spr.getRGB(0, 0, getWidth(), getHeight(), p, 0, getWidth());
                BitMap(xx, yy, pa);
                if (pa == 0xFF0026FF) {
                    player = new Player(xx * 32, yy * 32, ID.Player, Game.handler);
                    add(player);
                    camera=new Camera(xx*32,yy*32);
                    if(Generator.room.equals("Grass"))add(new Tile(xx*32,yy*32,ID.Floor,TileType.Grass));
                    else add(new Tile(xx*32,yy*32,ID.Floor,TileType.Floor));
                }
            }
        }
    }

    public Player getPlayer() { return player; }
    public Camera getCamera(){return camera;}
}