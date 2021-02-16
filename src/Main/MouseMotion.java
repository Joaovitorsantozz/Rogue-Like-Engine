package Main;

import Entity.Global.ID;
import Weapons.Bow;
import Weapons.Sword;
import GameObject.GameObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import GameObject.GameObjectHandler;
public class MouseMotion extends MouseAdapter {
    public GameObjectHandler handler;
    public static double mouseX,mouseY;
    public MouseMotion(GameObjectHandler hand){this.handler=hand;}

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        for(int i=0;i<handler.object.size();i++){
            GameObject ee=handler.object.get(i);
            if(ee.getId()== ID.Weapon){
                if(e.getButton()==MouseEvent.BUTTON1) {
                    handler.setAttack(true);
                    Bow.mx=e.getX()+Game.handlergame.cam.getX();
                    Bow.my=e.getY()+Game.handlergame.cam.getY();
                }
            }

        }
    }

    public void mouseReleased(MouseEvent e) {
        for(int i=0;i<handler.object.size();i++){
            GameObject ee=handler.object.get(i);
            if(ee.getId()== ID.Weapon){
                if(e.getButton()==MouseEvent.BUTTON1) {
                    handler.setAttack(false);
                }
            }
        }

    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}


    public void mouseWheelMoved(MouseWheelEvent e){}

    public void mouseDragged(MouseEvent e){}

    public void mouseMoved(MouseEvent e){
        for(int i=0;i<handler.object.size();i++){
            GameObject ee=handler.object.get(i);
            if(ee instanceof Sword){
                ((Sword) ee).rx=e.getX()+Game.handlergame.cam.getX();
                ((Sword) ee).ry=e.getY()+Game.handlergame.cam.getY();
            }
            Bow.mx=e.getX()+Game.handlergame.cam.getX();
            Bow.my=e.getY()+Game.handlergame.cam.getY();
            mouseX=e.getX()+Game.handlergame.cam.getX();
            mouseY=e.getY()+Game.handlergame.cam.getY();
        }
    }
}
