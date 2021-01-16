package Graphics.UI;

import Main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class UIHandler {
    public LinkedList<UI> UI=new LinkedList<>();
    public Inventory inv=new Inventory(Game.W/2-250,Game.H-100,this);
    public UIHandler(){
        UI.add(inv);
    }
    public void drawUI(Graphics g){
        for(UI ui:UI){
            ui.drawComponents(g);
        }
    }
    public void drawDefaultTex(Graphics g, BufferedImage spr){
        //make
        for(UI ui:UI){
            g.drawImage(spr,ui.getX(),ui.getY(),null);
        }
    }
    public void drawTexWithOffset(Graphics g,BufferedImage spr,int offset){
        for(UI ui:UI){
            g.drawImage(spr,ui.getX()+offset,ui.getY(),null);
        }
    }
}
