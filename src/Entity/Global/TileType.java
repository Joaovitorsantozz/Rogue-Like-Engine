package Entity.Global;

import Main.HandlerGame;
import World.Tile;

import java.awt.image.BufferedImage;
import java.util.logging.Handler;

public enum TileType {
    Wall(), DownWall(), RightWall(), LeftWall(), Bricks(),
    Floor();

    public BufferedImage SetImage(BufferedImage spr, Tile t) {
        switch (this) {
            case Wall, DownWall:
                spr = HandlerGame.spr.getSprite(0, 0, 16, 16);
                t.setDepth(Depth.LITTLE + 1);
                break;
            case Floor:
                spr = HandlerGame.spr.getSprite(0, 16, 16, 16);
                break;
            case RightWall:
                spr = HandlerGame.spr.getSprite(32, 0, 16, 16);
                break;
            case LeftWall:
                spr = HandlerGame.spr.getSprite(48, 0, 16, 16);
                break;
            case Bricks:
                spr = HandlerGame.spr.getSprite(16, 0, 16, 16);
                break;
            default:
                break;
        }
        return spr;
    }
}
