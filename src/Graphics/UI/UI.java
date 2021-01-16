package Graphics.UI;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class UI {
    private int x, y;
    private int width,height;
    public UI(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private BufferedImage UIimage;

    public abstract void update();

    public abstract void drawComponents(Graphics g);

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
