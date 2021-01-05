package World;

import Main.Game;

import java.util.HashSet;
import java.util.Random;

public class Generator {
    public int opendDir, random;
    public Random rand = new Random();
    public boolean spawned;
    private RoomTemplates templates;
    private Level actualLevel;
    public int lastRoom, repeat;

    public Generator() {
        opendDir = rand.nextInt(5);
        templates = new RoomTemplates();
        Gen();

    }

    public void Gen() {
        if (!spawned) {
            //Bottom
            //Top
            //Left
            //Right
            switch (opendDir) {
                case 1, 0 -> {
                    Game.handler.ClearObjects();
                    random = rand.nextInt(templates.bottom.length);
                    Level level = new Level(templates.bottom[random]);
                    setActualLevel(level);
                }
                case 2 -> {
                    Game.handler.ClearObjects();
                    random = rand.nextInt(templates.top.length);
                    Level level = new Level(templates.top[random]);
                    setActualLevel(level);
                }
                case 3 -> {
                    Game.handler.ClearObjects();
                    random = rand.nextInt(templates.left.length);
                    Level level = new Level(templates.left[random]);
                    setActualLevel(level);
                }
                case 4 -> {
                    Game.handler.ClearObjects();
                    random = rand.nextInt(templates.right.length);
                    Level level = new Level(templates.right[random]);
                    setActualLevel(level);
                }
            }
            NotSameLevel();
            spawned = true;
        } else {
            lastRoom = opendDir;
        }

    }


    public void NotSameLevel() {
        if (opendDir == lastRoom) {
            repeat++;
        } else {
            repeat = 0;
        }
        if (repeat >= 2 && repeat <= 4) {
            repeat = 0;
            opendDir = rand.nextInt(4 - repeat);
        }
    }

    public Level getLevel() {
        return actualLevel;
    }

    public void setActualLevel(Level act) {
        this.actualLevel = act;
    }

    public int getOpendDir() {
        return opendDir;
    }
}
