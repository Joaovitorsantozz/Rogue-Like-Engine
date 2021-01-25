package Main;

import Entity.Player;
import GameObject.Camera;
import GameObject.SpawnPointRoom;
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
        gen=new Generator(true,"Dungeon");
        level=gen.getLevel();
        cam = level.getCamera();
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
