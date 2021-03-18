package World;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import Entity.Global.TileType;
import GameObject.GameObject;
import GameObject.LevelItens.Rock;
import Main.Game;
import Main.HandlerGame;

public class Road extends GameObject implements Tickable, Renderable {
	private BufferedImage finalspr,sprs[]=new BufferedImage[9];
	private BufferedImage right,left,up,down,topL,topR,downL,downR;
    public Road(int x, int y, ID id,int tex) {
        super(x, y, id);
        setWidth(32);
        setHeight(32);
        setDepth(Depth.LITTLE+5);
        right=HandlerGame.grassspr.getSprite(96,16,16,16);
        left=HandlerGame.grassspr.getSprite(96,32,16,16);
        down=HandlerGame.grassspr.getSprite(96,64,16,16);
        up=HandlerGame.grassspr.getSprite(96,48,16,16);
        topL=HandlerGame.grassspr.getSprite(112,0,16,16);
        topR=HandlerGame.grassspr.getSprite(112,16,16,16);
        downR=HandlerGame.grassspr.getSprite(112,32,16,16);
        downL=HandlerGame.grassspr.getSprite(112,48,16,16);
        sprs[0]=right;
        sprs[1]=left;
        sprs[2]=up;
        sprs[3]=down;
        sprs[4]=HandlerGame.grassspr.getSprite(96,0,16,16);
        sprs[5]=topR;
        sprs[6]=topL;
        sprs[7]=downR;
        sprs[8]=downL;
        finalspr=sprs[tex];
        
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public void Render(Graphics g) {
    	drawDefaultTex(g,finalspr);
    }

    @Override
    public void Update() {
    	for(int i=0;i<Game.handler.object.size();i++) {
    		GameObject ee=Game.handler.object.get(i);
    		if(ee instanceof Rock) {
    			Game.handler.object.remove(ee);
    		}
    	}
    }
    private void SetImage() {
    	for(int i=0;i<Game.handler.object.size();i++){
    		GameObject ee=Game.handler.object.get(i);
    		if(ee instanceof Tile) {
    			if(((Tile) ee).getTileType()==TileType.Grass)
    				if(ee.getX()+32==getX())finalspr=left;
    		}
    	}
    }
}
