package Main;

import java.awt.event.*;
import java.util.Arrays;

import Entity.Global.ID;
import Entity.Player;
import GameObject.GameObject;
import GameObject.GameObjectHandler;

public class KeyInput implements KeyListener, FocusListener {
    GameObjectHandler handler;
    public static boolean[] press = new boolean[65536];
    KeyEvent ke;

    public KeyInput(GameObjectHandler hand) {
        this.handler = hand;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int b = e.getKeyCode();
        ke = e;
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject ee = handler.object.get(i);
            if (ee.getId() == ID.Player) {
                if (b == KeyEvent.VK_W) handler.setUp(true);
                if (b == KeyEvent.VK_S) handler.setDown(true);
                if (b == KeyEvent.VK_D) handler.setRight(true);
                if (b == KeyEvent.VK_A) handler.setLeft(true);
            }
        }
        if(b==KeyEvent.VK_1)handler.uiHandler.inv.setOnslot(1);
        if(b==KeyEvent.VK_2)handler.uiHandler.inv.setOnslot(2);
        if(b==KeyEvent.VK_3)handler.uiHandler.inv.setOnslot(3);
        if(b==KeyEvent.VK_4)handler.uiHandler.inv.setOnslot(4);
        if(b==KeyEvent.VK_5)handler.uiHandler.inv.setOnslot(5);
        if(b==KeyEvent.VK_6)handler.uiHandler.inv.setOnslot(6);
        if(b==KeyEvent.VK_7)handler.uiHandler.inv.setOnslot(7);
        if(b==KeyEvent.VK_8)handler.uiHandler.inv.setOnslot(8);
        Arrays.fill(press, true);
    }
    public void keyReleased(KeyEvent e) {
        int b = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject ee = handler.object.get(i);
            if (ee.getId() == ID.Player) {
                if (b == KeyEvent.VK_W) handler.setUp(false);
                if (b == KeyEvent.VK_S) handler.setDown(false);
                if (b == KeyEvent.VK_D) handler.setRight(false);
                if (b == KeyEvent.VK_A) handler.setLeft(false);
            }
        }
        Arrays.fill(press, false);
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject ee = handler.object.get(i);
            if(ee.getId()==ID.Player) {
                handler.setUp(false);
                handler.setDown(false);
                handler.setRight(false);
                handler.setLeft(false);
            }
        }
    }
}
