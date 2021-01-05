package GameObject;

import EngineInterfaces.Tickable;
import Entity.Global.ID;
import Entity.Global.TileType;
import Main.Game;
import Main.HandlerGame;
import World.Generator;
import World.Tile;

import java.awt.*;
import java.util.Random;

public class SpawnPointRoom extends GameObject implements Tickable {
    public SpawnPointRoom(int x, int y, ID id) {
        super(x, y, id);
        setWidth(32 * 3);
        setHeight(32 * 3);
    }

    @Override
    public void Update() {
        Collision();


    }



    void Collision() {
        for (int i = 0; i < Game.handler.object.size(); i++) {
            GameObject ee = Game.handler.object.get(i);
            if (ee.getId() == ID.Player) {
                if (getBounds().intersects(ee.getBounds())) {
                    HandlerGame.gen = new Generator();
                    Game.handler.DeleteObject(this);
                    break;
                }
            }
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}
