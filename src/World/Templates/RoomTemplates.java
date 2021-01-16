package World.Templates;

import GameObject.GameObject;
import Main.utils.LoadImage;
import World.World;

import java.awt.image.BufferedImage;

public class RoomTemplates {
    public RoomTemplates act;
    public GrassByome grasstemplate;
    public BufferedImage[]bottom;
    public BufferedImage[]right;
    public BufferedImage[]left;
    public BufferedImage[]top;
    public BufferedImage startRoom=new LoadImage("/Level/RoomTemplates/EntryRoom.png").getImage();
    public String template="Central";
    public RoomTemplates(){
        //bottom door rooms
        switch (template){
            case "Grass" ->{
                grasstemplate = new GrassByome();
                setTemplates(grasstemplate);
            }
        }
    }
    private void setTemplates(RoomTemplates rp){
        this.bottom=rp.bottom;
        this.top=rp.top;
        this.left=rp.left;
        this.right=rp.right;
    }
}
