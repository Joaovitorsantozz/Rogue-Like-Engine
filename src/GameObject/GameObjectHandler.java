package GameObject;


import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.ID;
import Entity.Player;
import Entity.particles.Particles;
import Graphics.UI.UIHandler;
import Main.Game;
import Weapons.WeaponBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameObjectHandler {
    public List<GameObject> object = new ArrayList<>();
    public List<Particles> particles = new ArrayList<>();
    private boolean right = false, left = false, up = false, down = false, attack = false;
    public UIHandler uiHandler = new UIHandler();

    public void update() {
        for (int i = 0; i < object.size(); i++) {
            GameObject ee = object.get(i);
            if (ee instanceof Tickable) {
                ((Tickable) ee).Update();
            }
        }
        for (int i = 0; i < particles.size(); i++) {
            if(particles.get(i)!=null) particles.get(i).Update();
        }
        object.sort(GameObject.nodeSorter);

    }

    public void render(Graphics2D g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject ee = object.get(i);
            if (ee instanceof Renderable) {
                ((Renderable) ee).Render(g);
            }
        }
        for (int i = 0; i < particles.size(); i++) {
            if(particles.get(i)!=null)particles.get(i).Render(g);
        }
    }

    public void renderNotAffect(Graphics g) {
        uiHandler.drawUI(g);
    }

    public void resetKeys() {
        for (int i = 0; i < object.size(); i++) {
            GameObject ee = object.get(i);
            if (ee.getId() == ID.Player) {
                setUp(false);
                setDown(false);
                setRight(false);
                setLeft(false);
            }
        }
    }

    public void ClearObjects() {
        particles.clear();
        object.clear();
    }

    public void add(GameObject obj) {
        object.add(obj);
    }

    public void DeleteObject(GameObject obj) {
        object.remove(obj);
    }

    public void DeleteByTag(ID id) {
        for (int i = 0; i < object.size(); i++) {
            if (object.get(i).getId() == id) object.remove(object.get(i));
        }
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

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
