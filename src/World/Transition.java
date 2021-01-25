package World;

import Main.Game;

import java.awt.*;

public class Transition {
    public int width=Game.W;
    public int height=Game.H;
    public int alpha,time;
    public boolean increase,decrease;
    public Transition() {
    }

    public void drawTransition(Graphics graphics) {
        if(increase){
            if(alpha<255)alpha+=5;
            if(alpha>253){
                increase=false;
                decrease=true;
            }
        }else if(decrease){
            ++time;
            if(time>180) {
                if (alpha > 0) alpha-=3;
            }
            if(alpha==1)decrease=false;
        }

        graphics.setColor(new Color(0,0,0,alpha));
        graphics.fillRect(0,0,width,height);

    }
    /*
    void drawMoreBounds(Graphics graphics){
        if(morebounds<48)morebounds+=0.4;
        if(morebounds>46){
            more=false;
            less=true;
        }
        for(int x=0;x< Game.W/16;x++){
            for(int y=0;y<Game.H/16;y++){
                graphics.setColor(Color.BLACK);
                graphics.fillOval(x*32,y*32,(int)morebounds,(int)morebounds);
            }
        }
    }
    void drawLessBounds(Graphics graphics){
        if(lessbounds>0)lessbounds-=0.4;
        if(lessbounds==1)less=false;
        for(int x=0;x< Game.W/16;x++){
            for(int y=0;y<Game.H/16;y++){
                graphics.setColor(Color.BLACK);
                graphics.fillOval(x*32,y*32,(int)lessbounds,(int)lessbounds);
            }
        }
    }
     */
}
