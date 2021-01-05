package Main;

import Entity.Sword;
import GameObject.GameObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import GameObject.GameObjectHandler;
public class MouseMotion extends MouseAdapter {
    public GameObjectHandler handler;

    public MouseMotion(GameObjectHandler hand){this.handler=hand;}

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}


    public void mouseWheelMoved(MouseWheelEvent e){}

    public void mouseDragged(MouseEvent e){}

    public void mouseMoved(MouseEvent e){
        for(int i=0;i<handler.object.size();i++){
            GameObject ee=handler.object.get(i);
            if(ee instanceof Sword){
                ((Sword)ee).rx=e.getX();
                ((Sword)ee).ry=e.getY();
            }
        }
    }
}
