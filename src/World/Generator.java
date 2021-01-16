package World;

import Main.Game;
import World.Templates.RoomTemplates;

import java.util.Random;

public class Generator {
    public int opendDir, random;
    public Random rand = new Random();
    public boolean spawned;
    public RoomTemplates templates;
    private Level actualLevel;
    public int lastRoom, repeat;

    public Generator() {
        opendDir = 0;
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
                case 0->{
                    Game.handler.ClearObjects();
                    setActualLevel(new Level(templates.startRoom));
                }
                case 1-> {
                    Game.handler.ClearObjects();
                    random = rand.nextInt(templates.bottom.length);
                    setActualLevel(new Level(templates.bottom[random]));
                }
                case 2 -> {
                    Game.handler.ClearObjects();
                    random = rand.nextInt(templates.top.length);
                    setActualLevel(new Level(templates.top[random]));
                }
                case 3 -> {
                    Game.handler.ClearObjects();
                    random = rand.nextInt(templates.left.length);
                    setActualLevel( new Level(templates.left[random]));
                }
                case 4 -> {
                    Game.handler.ClearObjects();
                    random = rand.nextInt(templates.right.length);
                    setActualLevel(  new Level(templates.right[random]));
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
