package World;

import EngineInterfaces.Renderable;
import EngineInterfaces.Tickable;
import Entity.Global.ID;
import GameObject.GameObject;

import java.awt.*;

public class Trail extends GameObject implements Tickable, Renderable {

    public Trail(int x, int y, ID id) {
        super(x, y, id);

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public void Render(Graphics g) {

    }

    @Override
    public void Update() {

    }
}
