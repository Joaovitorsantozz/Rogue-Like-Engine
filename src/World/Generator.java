package World;

import Main.Game;
import Main.HandlerGame;
import World.Templates.RoomTemplates;
import World.Templates.Template;

import java.util.Random;

public class Generator {
    public int opendDir, random;
    public Random rand = new Random();
    public boolean spawned;
    public Template templates;
    private Level actualLevel;
    public int lastRoom, repeat;
    public static String room = "Dungeon";

    public Generator(boolean startroom, String room) {
        Generator.room = room;
        opendDir = rand.nextInt(5);
        templates = new Template(room);
        if (!startroom) Gen();
        else StartRoom();
    }

    public void Gen() {
        if (!spawned) {
            switch (opendDir) {
                case 1 -> {
                    Game.handler.ClearObjects();
                    random = rand.nextInt(templates.bottom.length);
                    setActualLevel(HandlerGame.level=new Level(templates.bottom[random]));
                    getLevel().setWidth((templates.bottom[random].getWidth()));
                }
                case 2 -> {
                    Game.handler.ClearObjects();
                    random = rand.nextInt(templates.top.length);
                    setActualLevel(HandlerGame.level=new Level(templates.top[random]));
                    getLevel().setWidth((templates.top[random].getWidth()));
                }
                case 3 -> {
                    Game.handler.ClearObjects();
                    random = rand.nextInt(templates.left.length);
                    setActualLevel(HandlerGame.level=new Level(templates.left[random]));
                    getLevel().setWidth((templates.left[random].getWidth()));
                }
                case 4 -> {
                    Game.handler.ClearObjects();
                    random = rand.nextInt(templates.right.length);
                    setActualLevel(HandlerGame.level=new Level(templates.right[random]));
                    getLevel().setWidth((templates.right[random].getWidth()));
                }
            }
            NotSameLevel();
            Game.handler.resetKeys();
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

    public void StartRoom() {
        setActualLevel(new Level(templates.startroom));
        spawned = true;
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
