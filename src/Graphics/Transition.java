package Graphics;

import Main.Game;
import Main.utils.FontStyle;
import Main.utils.LoadImage;
import Main.utils.Text.Text;

import java.awt.*;

public class Transition {
    public int width = Game.W;
    public int height = Game.H;
    public int alpha, time;
    public boolean increase, decrease;
    private Text nameDungeon;
    FontStyle fs = new FontStyle();
    public static boolean showByome,canshowbyome;

    public Transition() {
        nameDungeon = new Text(fs.getFont(100, 150), "Grass Biome", 380, 300);
    }

    public void drawTransition(Graphics graphics) {
        if (increase) {
            if (alpha < 254) alpha += 5;
            if (alpha > 253) {
                increase = false;
                decrease = true;
            }
        } else if (decrease) {
            ++time;
            if (time > 180) {
                if (alpha > 1) alpha -= 3;
            }
            if (alpha < 3) decrease = false;
        }
        if (alpha < 0) alpha = 0;
        if (alpha > 255) alpha = 255;
        graphics.setColor(new Color(0, 0, 0, alpha));
        graphics.fillRect(0, 0, width, height);

        if (decrease && alpha < 10) {
            if(canshowbyome){
                showByome = true;
                canshowbyome=false;
            }
        }
        if(showByome){
            drawByome(graphics);
        }
    }

    public void drawByome(Graphics graphics) {
        nameDungeon.DrawText(graphics, Color.white, "Fadeout");
    }
}
