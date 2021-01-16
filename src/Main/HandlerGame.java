package Main;

import Entity.Player;
import GameObject.Camera;
import Graphics.SpriteSheet;
import Main.utils.FontStyle;
import World.Generator;
import World.Level;

import java.awt.*;

public class HandlerGame {
    public static FontStyle font;
    public static SpriteSheet spr,grassspr;
    public Camera cam;
    public static Level level;
    public static Generator gen;
    public static Player player;
    public HandlerGame() {
        spr = new SpriteSheet("/SpriteSheet.png");
        grassspr=new SpriteSheet("/GrassSheet.png");
        font = new FontStyle();
        cam = new Camera(0, 0);
        gen=new Generator();
        level=gen.getLevel();
        player=level.getPlayer();
    }

    public void tick() {


    }

    public void render(Graphics g) {
    }

    public void renderNotAffect(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

    }
}
