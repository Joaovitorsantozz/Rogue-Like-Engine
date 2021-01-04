package Main;

import java.awt.event.*;
import java.util.Arrays;

import Entity.Global.ID;
import Entity.Player;
import GameObject.GameObject;
import GameObject.GameObjectHandler;

public class KeyInput implements KeyListener, FocusListener {
	GameObjectHandler handler;
	public boolean[] press=new boolean[65536];
	public KeyInput(GameObjectHandler hand) {
		this.handler = hand;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		int b=e.getKeyCode();
		for(int i=0;i<handler.object.size();i++){
			GameObject ee=handler.object.get(i);
			if(ee.getId()==ID.Player){
				if(b==KeyEvent.VK_W)handler.setUp(true);
				if(b==KeyEvent.VK_S)handler.setDown(true);
				if(b==KeyEvent.VK_D)handler.setRight(true);
				if(b==KeyEvent.VK_A)handler.setLeft(true);
			}
		}
		//Arrays.fill(press, true);
	}

	public void keyReleased(KeyEvent e) {
		int b=e.getKeyCode();
		for(int i=0;i<handler.object.size();i++){
			GameObject ee=handler.object.get(i);
			if(ee.getId()==ID.Player){
				if(b==KeyEvent.VK_W)handler.setUp(false);
				if(b==KeyEvent.VK_S)handler.setDown(false);
				if(b==KeyEvent.VK_D)handler.setRight(false);
				if(b==KeyEvent.VK_A)handler.setLeft(false);
			}
		}
		//Arrays.fill(press, false );
	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		Arrays.fill(press, false);
	}
}
