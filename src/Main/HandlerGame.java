package Main;

import Entity.Global.ID;
import Entity.Player;
import GameObject.Camera;
import Graphics.SpriteSheet;
import Main.utils.FontStyle;
import World.Generator;
import World.Level;

import java.awt.*;

public class HandlerGame {
    public static FontStyle font;
    public static SpriteSheet spr;
    public Camera cam;
    //public ConsoleStyle con;
    //public static ConsoleHandler ch;
    public static Level level;
    public static boolean tran;
    public static Generator gen;
    public HandlerGame() {
        spr = new SpriteSheet("/SpriteSheet.png");
        font = new FontStyle();
        cam = new Camera(0, 0);
        gen=new Generator();
        level=gen.getLevel();
        // con=new ConsoleStyle(350,Game.H-60);
        // ch=new ConsoleHandler();
    }

    public void tick() {

      /*  try {
            ch.UpdateButtons();
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }*/

    }

    public void render(Graphics g) {

    }

    public void renderNotAffect(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //con.drawConsole(g);
        //   ch.drawButtons(g);
    }
}
