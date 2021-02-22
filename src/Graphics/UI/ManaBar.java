package Graphics.UI;

import Main.utils.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ManaBar extends UI{
    private BufferedImage manabar=new LoadImage("/UI/ManaBar.png").getImage();
    public double actualmana=100,maxmana=100,decreasemana=2.5,controlmana;
    public boolean decrease,increase;
    private int time;
    public ManaBar(int x, int y) {
        super(x, y);
        setWidth(manabar.getWidth()*3);
        setHeight(manabar.getHeight()*3);
    }

    @Override
    public void update() {
        if(decrease){
            actualmana-=decreasemana;
            controlmana+=decreasemana;
            if(controlmana>=10){
                controlmana=0;
                decrease=false;
            }
        }
        if(!decrease){
            if(actualmana<100&&actualmana!=100){
                time++;
                if(time>60){
                    time=0;
                    increase=true;
                }
            }
        }
        if(increase){
            actualmana+=4;
            if(actualmana>=100){
                actualmana=100;
                increase=false;
            }
        }
    }

    @Override
    public void drawComponents(Graphics g) {
        int mw=(int)((actualmana/maxmana)*170);
        g.setColor(new Color(5, 80, 175));
        g.fillRect(getX()+90,getY()+24,mw,23);
        g.drawImage(manabar,getX(),getY(),getWidth(),getHeight(),null);
        update();
    }
}
