package World;

import Main.Game;
import Main.HandlerGame;

public class LevelSwitch {
    public static int LEVEL = 1;
    public static boolean next, rest;

    public void upd() {
        if (next) {
            next = false;
            ToNextLevel();
        }
        if (rest) {
            rest = false;
            Restart();
        }
    }

    public void ToNextLevel() {
        Game.handler.ClearObjects();
        LEVEL++;
        String nt = "/Level/level" + LEVEL + ".png";
        //HandlerGame.level = new Level(nt);
    }


    public void Restart() {
        Game.handler.ClearObjects();
      // HandlerGame.level = new Level("/Level/level" + LEVEL + ".png");
    }

}
