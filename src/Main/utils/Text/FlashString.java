package Main.utils.Text;

import Main.utils.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FlashString extends Effect {
    public static boolean increase, decrease;
    private int alpha = 255;
    public static boolean restart, start;
    public int cur;

    public FlashString(Font font, int x, int y) {
        super(font, x, y);
    }

    @Override
    public void draw(Graphics g, String text) {
        if (alpha >= 254) decrease = true;
        if (alpha <= 1) increase = true;

        if (decrease && alpha >= 1) {
            increase = false;
            alpha -= 5;
        }
        if (increase && alpha < 255) {
            decrease = false;
            alpha += 5;
        }
        g.setFont(font);
        g.setColor(new Color(255, 255, 255, alpha));
        g.drawString(text, x, y);
    }

    public void FadeOut(Graphics g, String text) {
        if (start) {
            cur++;
            decrease = true;
        }
        if(cur>=60) {
            if (decrease) {
                if (getAlpha() >= 1) alpha -= 5;

            }
        }
        if (restart) {
            restart = false;
            setAlpha(255);
            cur=0;
        }
        g.setFont(font);
        g.setColor(new Color(255, 255, 255, getAlpha()));
        g.drawString(text, x, y-20);
        if(alpha>10)g.drawImage(new LoadImage("/UI/Bar.png").getImage(), 330, 300, 64 * 9, 4, null);
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
}
