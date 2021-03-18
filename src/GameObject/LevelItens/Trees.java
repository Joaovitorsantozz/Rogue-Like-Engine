package GameObject.LevelItens;

import EngineInterfaces.Renderable;
import Entity.Global.Depth;
import Entity.Global.ID;
import GameObject.GameObject;
import Main.Game;
import Main.utils.LoadImage;
import World.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Trees extends GameObject implements Renderable {
	private BufferedImage tree = new LoadImage("/GameObject/Vegetation/Spruce.png").getImage();
	private BufferedImage bush = new LoadImage("/GameObject/Vegetation/Bush.png").getImage();
	private BufferedImage bigtree = new LoadImage("/GameObject/Vegetation/Tree.png").getImage();
	private BufferedImage[] imgs = new BufferedImage[3];
	private int depth[],index;
	private List<Trees> trees=new ArrayList<>();
	private boolean canAddToArray;
	public Trees(int x, int y, ID id, int tex) {
		super(x, y, id);
		imgs[0] = tree;
		imgs[1] = bush;
		imgs[2] = bigtree;
		this.spr = imgs[tex];
		setWidth(spr.getWidth() * 3);
		setHeight(spr.getHeight() * 3);
		if (tex == 3) {
			setWidth(spr.getWidth() * 5);
			setHeight(spr.getHeight() * 5);
		}
		setDepth(Depth.HIGHT);
	}

	private void Depth() {
		for(int i=0;i<Game.handler.object.size();i++){
			GameObject ee=Game.handler.object.get(i);
			if(ee instanceof Trees) {
				if(((Trees) ee).canAddToArray) {
					((Trees) ee).canAddToArray=false;
					trees.add((Trees)ee);
				}
			}
		}
		System.out.println(trees.size());
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(0, 0, 32, 32);
	}

	@Override
	public void Render(Graphics g) {
		drawDefaultTex(g, spr);
		for(int i=0;i<Game.handler.object.size();i++) {
			GameObject ee=Game.handler.object.get(i);
			if(ee instanceof Tile) {
				if(this.getY()+this.getWidth()==ee.getX()) {
					Game.handler.object.remove(this);	
				}
			}
		}
	}
}
