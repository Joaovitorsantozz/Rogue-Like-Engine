package World;

import Entity.Global.ID;
import Entity.Global.TileType;
import Entity.Player;
import GameObject.SpawnPointRoom;
import Main.Game;
import Main.utils.LoadImage;
import Weapons.Sword;

import java.awt.image.BufferedImage;

public class Level extends World {
    public int[] p;
    private  Player player;
    public Level(BufferedImage level) {
        super(level);
        setWidth(spr.getWidth());
        setHeight(spr.getHeight());
        for (int xx = 0; xx < level.getWidth(); xx++) {
            for (int yy = 0; yy < level.getHeight(); yy++) {
                p = new int[getWidth() * getHeight()];
                int pa = spr.getRGB(xx, yy);
                spr.getRGB(0, 0, getWidth(), getHeight(), p, 0, getWidth());
                BitMap(xx, yy, pa);
                if (pa == 0xFF0026FF){
                    player=new Player(xx * 32, yy * 32, ID.Player, Game.handler);
                    add(player);
                }
            }
        }
    }
    public  Player getPlayer(){
        return player;
    }
}