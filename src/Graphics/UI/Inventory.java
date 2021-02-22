package Graphics.UI;

import EngineInterfaces.InventoryInterface;
import Entity.Global.ID;
import Entity.Player;
import GameObject.GameObject;
import Main.Game;
import Main.HandlerGame;
import Main.utils.LoadImage;
import Weapons.Staff;
import Weapons.WeaponBase;

import javax.print.attribute.HashAttributeSet;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Inventory extends UI implements InventoryInterface {
    public WeaponBase[] storage;
    private final int maxSize = 8;
    private final BufferedImage hotbar = new LoadImage("/UI/Hotbar.png").getImage();
    private final UIHandler handler;
    private int onslot = 0;
    private BufferedImage[] icon;

    public Inventory(int x, int y, UIHandler handler) {
        super(x, y);
        this.setX(x);
        this.setY(y);
        this.handler = handler;
        storage = new WeaponBase[maxSize + 1];
        icon = new BufferedImage[storage.length];
    }

    public void update() {

    }

    @Override
    public void drawComponents(Graphics g) {

        for (int i = 0; i < maxSize; i++) {
            handler.drawTexWithOffset(g, hotbar, i * 50,this);
            if (i == onslot - 1) {
                handler.drawTexWithOffset(g, new LoadImage("/UI/FocusSlot.png").getImage(), i * 50,this);

            }
            if (getObjectIndex(i) != null) {
                g.drawImage(storage[i].getSpr(), getX()+8 + ((i - 1)) * 50, getY()+12, 32, 32, null);
            }

        }
    }


    @Override
    public int getSize() {
        return storage.length;
    }

    @Override
    public int getMaxSize() {
        return storage.length - 1;
    }

    @Override
    public WeaponBase getObjectIndex(int index) {
        return storage[index];
    }

    public int getEmptySlot() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) return i;
        }
        return -1;
    }

    public void setOnslot(int x) {
        this.onslot = x;

    }

    public BufferedImage setIcon(int i) {
        return icon[i] = storage[i].getSpr();
    }

    public void setItem(int slot, WeaponBase obj) {
        storage[slot] = obj;
        Game.handler.add(obj);
    }

    public int getOnslot() {
        return this.onslot;
    }
}
