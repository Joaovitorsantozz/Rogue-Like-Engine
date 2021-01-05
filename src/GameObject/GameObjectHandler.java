package GameObject;


import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.ID;
import Entity.Player;
import Entity.particles.Particles;
import Main.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameObjectHandler {
	public List<GameObject> object = new ArrayList<>();
	public List<Particles>particles= new ArrayList<>();



	private boolean right = false, left = false,up = false,down=false,attack=false;
	public void update() {
		for (int i=0;i<object.size();i++) {
			GameObject ee=object.get(i);
			if(ee instanceof Tickable)((Tickable) ee).Update();
		}
		for (int i=0;i<particles.size();i++) { particles.get(i).tick(); }
		object.sort(GameObject.nodeSorter);
	}

	public void render(Graphics2D g) {
		for (int i=0;i<object.size();i++) {
			GameObject ee=object.get(i);
			if(ee instanceof Renderable)((Renderable) ee).Render(g);
		}
		for (int i=0;i<particles.size();i++) { particles.get(i).render(g); }

	}
	public void ClearObjects(){

		particles.clear();
		object.clear();
	}
	public void add(GameObject obj) {
		object.add(obj);
	}
	public void DeleteObject(GameObject obj) {
		object.remove(obj);
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public boolean isAttack() {
		return attack;
	}

	public void setAttack(boolean attack) {
		this.attack = attack;
	}
	public boolean isUp() { return up; }
	public void setUp(boolean up) { this.up = up; }
	public boolean isDown() { return down; }
	public void setDown(boolean down) { this.down = down; }
}
