package GameObject;

import Main.Game;
import Main.HandlerGame;

public class Camera {
	private float x, y;

	public Camera(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void tick(GameObject obj) {
		x+=((obj.getX()-x)-Game.W/2f)*0.03f;
		y+=((obj.getY()-y)-Game.H/2f)*0.03f;
		if(x<=-Game.W/2f)x=-Game.W/2f;
		if(x>=HandlerGame.level.getWidth()*32-Game.W/2f)x=HandlerGame.level.getWidth()*32-Game.W/2f;
		if(y<=0)y=0;
		if(y>=HandlerGame.level.getHeight()*32-Game.H/2f)y=HandlerGame.level.getHeight()*32-Game.H/2f;
	}
	private void clamp(){}
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
