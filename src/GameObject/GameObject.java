package GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Comparator;

import Entity.Global.ID;


public abstract class GameObject {
	protected int x, y,dir;
	protected float velX = 0, velY = 0;
	protected ID id;
	private int depth;
	private int width, height;
	public BufferedImage spr;
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}


	public abstract Rectangle getBounds();
	protected static Comparator<GameObject> nodeSorter = Comparator.comparingInt(n0 -> n0.depth);

	public double calculateDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	public void DrawBounds(Graphics2D g2){
		g2.setColor(Color.red);
		g2.draw(getBounds());
	}
	public void drawDefaultTex(Graphics g, BufferedImage sprite){
		g.drawImage(sprite,getX(),getY(),getWidth(),getHeight(),null);
	}
	public void drawDefaultTexInv(Graphics g,BufferedImage sprite){
		g.drawImage(sprite,getX()+getWidth(),getY(),getWidth()*-1,getHeight(),null);
	}
	public boolean Move(GameObjectHandler hand, float speed){
		if (hand.isRight()) {velX = speed;setDir(1);}
		else if(!hand.isLeft())velX=0;
		// Left
		if (hand.isLeft()) {velX = -speed;setDir(-1);}
		else if(!hand.isRight())velX=0;

		if(hand.isUp()){ velY=-speed;}
		else if(!hand.isDown())velY=0;

		if(hand.isDown()){velY=speed;}
		else if(!hand.isUp())velY=0;

		return velX!=0|velY!=0;
	}

	public int getWidth() { return width; }
	public void setWidth(int width) { this.width = width; }
	public int getHeight() { return height; }
	public void setHeight(int height) { this.height = height; }
	public void setId(ID id) { this.id = id; }
	public int getDepth() { return depth; }
	public void setDepth(int depth) { this.depth = depth; }
	public int getX() { return this.x; }
	public void setX(int nx) { this.x = nx; }
	public int getY() { return  this.y; }
	public void setY(int ny) { this.y = ny; }
	public float getVelX() { return velX; }
	public void setVelX(float velX) { this.velX = velX; }
	public float getVelY() { return velY; }
	public void setVelY(float velY) { this.velY = velY; }
	public ID getId() { return id; }
	public int getDir() { return dir; }
	public void setDir(int dir) { this.dir = dir; }
	public BufferedImage getSpr(){return this.spr;}
}
