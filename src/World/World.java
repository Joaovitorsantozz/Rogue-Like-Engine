package World;


import Entity.Global.Pixels;
import Entity.Global.TileType;

import Entity.Global.ID;

import Entity.enemy.Slime;
import GameObject.LevelItens.Grass;
import GameObject.LevelItens.Pilar;
import GameObject.LevelItens.Rock;
import GameObject.GameObject;
import GameObject.LevelItens.Trees;
import Main.Game;
import GameObject.SpawnPointRoom;

import java.awt.image.BufferedImage;
import java.util.Random;


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
        setTiles(xx, yy, pa);
     
        if(pa==0xFF7F3300) {
     		add(new Road(xx*32,yy*32,ID.Floor,4));
     		if(getPixel(xx+1,yy)==Pixels.FLOOR) {
        		add(new Road((xx)*32,yy*32,ID.Floor,1));
        	}
     		if(getPixel(xx-1,yy)==Pixels.FLOOR) {
        		add(new Road(xx*32,yy*32,ID.Floor,0));
        	}
     		if(getPixel(xx,yy-1)==Pixels.FLOOR) {
     			add(new Road(xx*32,yy*32,ID.Floor,3));
     		}
     		if(getPixel(xx,yy+1)==Pixels.FLOOR) {
     			add(new Road(xx*32,yy*32,ID.Floor,2));
     		}
        	if(getPixel(xx+1,yy)==Pixels.FLOOR&&getPixel(xx,yy-1)==Pixels.FLOOR) {
        		add(new Road(xx*32,yy*32,ID.Floor,5));
        	}
        	if(getPixel(xx+1,yy)==Pixels.FLOOR&&getPixel(xx,yy+1)==Pixels.FLOOR) {
        		add(new Road(xx*32,yy*32,ID.Floor,7));
        	}
        	if(getPixel(xx-1,yy)==Pixels.FLOOR&&getPixel(xx,yy+1)==Pixels.FLOOR) {
        		add(new Road(xx*32,yy*32,ID.Floor,8));
        	}
        	if(getPixel(xx-1,yy)==Pixels.FLOOR&&getPixel(xx,yy-1)==Pixels.FLOOR) {
        		add(new Road(xx*32,yy*32,ID.Floor,6));
        	}
        	
        }
        if(Generator.room.equals("Grass")){
            if (xx == WIDTH - 1) {
                add(new Tile((xx + 1) * 32, yy * 32, ID.Block, TileType.DarkGrass));
            }
            if(xx==0){
                add(new Tile((xx - 1) * 32, yy * 32, ID.Block, TileType.DarkGrass));
            }
            if (yy == HEIGHT - 1) {
                add(new Tile((xx) * 32, (yy-1) * 32, ID.Block, TileType.DarkGrass));
            }
        }
        if (pa == 0xFF00FF21) {
            add(new SpawnPointRoom(xx * 32, yy * 32, ID.Portal));
            add(new Tile(xx * 32, yy * 32, ID.Floor, TileType.Grass));
        }
        if (pa == 0xFF808080) {
            add(new Pilar(xx * 32, yy * 32, ID.Block, new Random().nextInt(2)));
        }
        if (pa == 0xFF3F7F47) {
            add(new Tile(xx * 32, yy * 32, ID.Floor, TileType.Grass));
            if (new Random().nextInt(100) < 20) {
                add(new Grass(xx * 32, yy * 32, ID.Default));
            }
        }
    }

    private void setTiles(int xx, int yy, int pa) {
        if (pa == 0xFF11502C) {
            add(new Tile(xx * 32, yy * 32, ID.Block, TileType.DarkGrass));
            if(new Random().nextInt(100)<5){
                add(new Trees((xx) * 32, (yy-3) * 32, ID.Block, new Random().nextInt(3)));
            }
        }

        if (pa == 0xFFFFFFFF) {
            if (Generator.room.equals("Dungeon")) {
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
            } else if (Generator.room.equals("Grass")) {

                if (xx + 1 < getWidth()) {
                    if (getPixel(xx + 1, yy) == Pixels.FLOOR) {
                        add(new Tile(xx * 32, yy * 32, ID.Block, TileType.LeftGrass));
                    }
                }
                if (xx - 1 > 0) {
                    if (getPixel(xx - 1, yy) == Pixels.FLOOR) {
                        add(new Tile(xx * 32, yy * 32, ID.Block, TileType.RightGrass));
                    }
                }
                if (yy + 1 < getHeight()) {
                    if (getPixel(xx, yy + 1) == Pixels.FLOOR) {
                        add(new Tile(xx * 32, yy * 32, ID.Block, TileType.WallGrass));
                    }
                    if (xx - 1 > 0) {
                        if (getPixel(xx - 1, yy) == 0xFF11502C) {
                            if (yy - 1 > 0) {
                                if (getPixel(xx, yy - 1) == 0xFF11502C)
                                    add(new Tile(xx * 32, yy * 32, ID.Block, TileType.LeftGrass));
                            }
                            if (getPixel(xx, yy + 1) == 0xFF11502C)
                                add(new Tile(xx * 32, yy * 32, ID.Block, TileType.BorderLeftGrass));
                        }
                    }
                }
                if (yy - 1 > 0) {
                    if (getPixel(xx, yy - 1) == Pixels.FLOOR) {
                        add(new Tile(xx * 32, yy * 32, ID.Block, TileType.DownGrass));
                    }
                    if (xx + 1 < getWidth()) {
                        if (yy + 1 < getHeight()) {
                            if (getPixel(xx + 1, yy) == 0xFF11502C) {
                                if (getPixel(xx, yy - 1) == 0xFF11502C)
                                    add(new Tile(xx * 32, yy * 32, ID.Block, TileType.RightGrass));
                                if (getPixel(xx, yy + 1) == 0xFF11502C)
                                    add(new Tile(xx * 32, yy * 32, ID.Block, TileType.BorderRightGrass));
                            }
                        }
                    }
                }
            }

        }

        if (xx < getHeight() - 1 && xx > 0) {

            if (yy > 2 && yy < getHeight() - 1) {
                if (Generator.room.equals("Dungeon")) {
                    add(new Tile(xx * 32, yy * 32, ID.Floor, TileType.Floor));
                }
            }
        }
        if (pa == 0xFF000000) {
            int rand = new Random().nextInt(300);
            if (Generator.room.equals("Grass")) {
                if(xx>5&&xx<getWidth()-6) {
                    if (yy > 5 && yy < getHeight() - 6) {
                        if (rand == 11) {
                            add(new Rock(xx * 32, yy * 32, ID.Block));
                        } else if (rand < 10) {
                            add(new Grass(xx * 32, yy * 32, ID.Decorate));
                        }
                    }
                }
                add(new Tile(xx * 32, yy * 32, ID.Floor, TileType.Grass));

            }
        }
        if (pa == 0xFF007F0E) {
            add(new SpawnPointRoom(xx * 32, yy * 32, ID.GrassPortal));
            if (xx == 0 || xx == getWidth() - 1) {
                if (getPixel(xx, yy - 2) == 0xFFFFFFFF) {
                    add(new Tile(xx * 32, (yy - 2) * 32, ID.Block, TileType.Bricks));
                    add(new Tile(xx * 32, (yy - 1) * 32, ID.Block, TileType.Bricks));
                }
            }
        }
        if(pa==0xFFFF0000){
            if(new Random().nextInt(100)<75){
                add(new Slime(xx*32,yy*32,ID.Enemy));
            }
            add(new Tile(xx * 32, yy * 32, ID.Floor, TileType.Grass));
        }
    }

    public int getPixel(int x, int y) {
        int[] p;
        int pa = 0;

        p = new int[getWidth() * getHeight()];
        spr.getRGB(0, 0, getWidth(), getHeight(), p, 0, getWidth());
        return p[x + y * getWidth()];
    }

    public void add(GameObject obj) {
        Game.handler.add(obj);
    }
}



