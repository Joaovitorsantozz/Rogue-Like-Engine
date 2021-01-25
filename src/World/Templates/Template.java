package World.Templates;

import Main.utils.LoadImage;

import java.awt.image.BufferedImage;

public class Template {
    public BufferedImage[]bottom;
    public BufferedImage[]right;
    public BufferedImage[]left;
    public BufferedImage[]top;
    public BufferedImage startroom=new LoadImage("/Level/RoomTemplates/EntryRoom.png").getImage();
    public Template(String actroom){
        if(actroom.equals("Dungeon")){
            RoomTemplates room=new RoomTemplates();
            this.bottom=room.bottom;
            this.top=room.top;
            this.left=room.left;
            this.right=room.right;
        }else if(actroom.equals("Grass")){
            GrassTemplate grass=new GrassTemplate();
            this.bottom=grass.bottom;
            this.top=grass.top;
            this.left=grass.left;
            this.right=grass.right;
        }
    }
}
