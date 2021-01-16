package World;


import Entity.Global.TileType;

import Entity.Global.ID;

import Entity.Player;
import Weapons.Sword;
import GameObject.GameObject;
import Main.Game;
import GameObject.SpawnPointRoom;

import java.awt.image.BufferedImage;


public class World {
    private int WIDTH, HEIGHT;
    public BufferedImage spr;
    private String dir;
    public boolean next = false;

    public World(BufferedImage level) {
        this.spr = level;

    }

    public BufferedImage getSpr() {
        return spr;
    }

    public void setSpr(BufferedImage spr) {
        this.spr = spr;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getWidth() {
        return WIDTH;
    }

    public void setWidth(int wIDTH) {
        WIDTH = wIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public void setHeight(int hEIGHT) {
        HEIGHT = hEIGHT;
    }

    public void BitMap(int xx, int yy, int pa) {
        if (pa == 0xFFFFFFFF) {
            if (xx == getWidth() - 1) {
                add(new Tile(xx * 32, yy * 32, ID.Block, TileType.RightWall));
            } else if (xx == 0) {
                add(new Tile(0, yy * 32, ID.Block, TileType.LeftWall));
            }
            if (yy == 0) {
                add(new Tile(xx * 32, 0, ID.Block, TileType.Wall));
                add(new Tile(xx * 32, 32, ID.Block, TileType.Bricks));
                add(new Tile(xx * 32, 64, ID.Block, TileType.DownBrick));
            }
            if (yy == getHeight() - 1) {
                add(new Tile(xx * 32, yy * 32, ID.Block, TileType.Wall));
                add(new Tile(xx * 32, yy * 32 + 32, ID.Block, TileType.Bricks));
                add(new Tile(xx * 32, yy * 32 + 64, ID.Block, TileType.DownBrick));
            }
        }
        if (xx < getHeight() - 1 && xx > 0) {
            if (yy > 2 && yy < getHeight() - 1) add(new Tile(xx * 32, yy * 32, ID.Floor, TileType.Floor));
        }

        if (pa == 0xFF00FF21) {
            add(new SpawnPointRoom(xx * 32, yy * 32, ID.GrassByome));
            if (xx == 0 || xx == getWidth() - 1) {
                if (getPixel(xx, yy - 2) == 0xFFFFFFFF) {
                    add(new Tile(xx * 32, (yy - 2) * 32, ID.Block, TileType.Bricks));
                    add(new Tile(xx * 32, (yy-1) * 32, ID.Block, TileType.Bricks));
                }
            }
        }
    }

    public int getPixel(int x, int y) {
        int[] p;
        int pa = 0;

        p = new int[getWidth() * getHeight()];
        pa = spr.getRGB(x, y);
        spr.getRGB(0, 0, getWidth(), getHeight(), p, 0, getWidth());

        return pa;
    }

    public void add(GameObject obj) {
        Game.handler.add(obj);
    }
}



