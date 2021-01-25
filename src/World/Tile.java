package World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.Depth;
import Entity.Global.ID;
import Entity.Global.TileType;
import Entity.particles.ParticleHandler;
import GameObject.GameObject;
import Main.HandlerGame;

public 	class Tile extends GameObject implements Renderable {
	private BufferedImage spr;
	private TileType t;


	public Tile(int x, int y, ID id, TileType tt) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		t = tt;
		setDepth(Depth.LITTLE);
		setWidth(32);
		setHeight(32);
		spr=t.SetImage(spr,this);
		
	}



	public TileType getTileType() {
		return t;
	}

	public void setTileType(TileType tile) {
		t = tile;
	}


	public void Render(Graphics g) {
		// TODO Auto-generated method stub
		drawDefaultTex(g,spr);
	}

	@Override
	public Rectangle getBounds() {return new Rectangle(getX(),getY(),getWidth(),getHeight()); }

}
