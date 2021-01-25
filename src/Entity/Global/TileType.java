package Entity.Global;

import Main.HandlerGame;
import World.Generator;
import World.Tile;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.logging.Handler;

public enum TileType {
    Wall(), DownWall(), RightWall(), LeftWall(), Bricks(),
    Floor(), DownBrick(), Grass();

    public BufferedImage SetImage(BufferedImage spr, Tile t) {
        switch (this) {
            case Wall, DownWall:
                spr = HandlerGame.spr.getSprite(0, 0, 16, 16);
                t.setDepth(Depth.LITTLE + 1);
                break;
            case Floor:

                if (new Random().nextInt(10) < 3)
                    spr = HandlerGame.spr.getSprite(16, 16, 16, 16);
                else if (new Random().nextInt(10) > 3 && new Random().nextInt() < 6)
                    spr = HandlerGame.spr.getSprite(32, 16, 16, 16);
                else
                    spr = HandlerGame.spr.getSprite(48, 16, 16, 16);
                break;
            case RightWall:
                spr = HandlerGame.spr.getSprite(64, 0, 16, 16);
                break;
            case LeftWall:
                spr = HandlerGame.spr.getSprite(80, 0, 16, 16);
                break;
            case Bricks:
                spr = HandlerGame.spr.getSprite(16, 0, 16, 16);
                break;
            case DownBrick:
                spr = HandlerGame.spr.getSprite(32, 0, 16, 16);
                break;
            case Grass:
                spr=HandlerGame.grassspr.getSprite(0,0,16,16);
                break;
            default:
                break;
        }
        return spr;
    }
}
