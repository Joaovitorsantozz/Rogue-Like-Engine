package World;


import Entity.Global.TileType;

import Entity.Global.ID;

import Entity.Player;
import GameObject.GameObject;
import Main.Game;
import GameObject.SpawnPointRoom;
import java.awt.image.BufferedImage;


public  class World {
    private int WIDTH, HEIGHT;
    public BufferedImage spr;
    private String dir;
    public boolean next=false;
    public World(BufferedImage level) {
        this.spr=level;

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

    public void BitMap(int xx, int yy,int pa) {
        if(pa==0xFFFFFFFF){
            add(new Tile(xx*32,yy*32,ID.Block,TileType.Bricks));
        }
        if(pa==0xFF0026FF)add(new Player(xx*32,yy*32,ID.Player,Game.handler));
        if(pa==0xFF00FF21)add(new SpawnPointRoom(xx*32,yy*32,ID.Default));
    }
    public void add(GameObject obj){
        Game.handler.add(obj);
    }
}



