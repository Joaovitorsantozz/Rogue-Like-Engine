package Graphics.UI;

import Main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;

public class UIHandler {
    public ArrayList<UI> UI = new ArrayList<>();
    public Inventory inv = new Inventory(Game.W / 2 - 250, Game.H - 100, this);
    public ManaBar manabar = new ManaBar(50, 50);

    public UIHandler() {
        UI.add(inv);
        UI.add(manabar);
    }

    public void drawUI(Graphics g) {
        for (int i = 0; i < UI.size(); i++) {
            UI ui = UI.get(i);
            ui.drawComponents(g);
        }
    }

    public void drawDefaultTex(Graphics g, BufferedImage spr, UI ui) {
        //make
        g.drawImage(spr, ui.getX(), ui.getY(), null);
    }

    public void drawTexWithOffset(Graphics g, BufferedImage spr, int offset,UI ui) {
            g.drawImage(spr, ui.getX() + offset, ui.getY(), null);
    }
}
