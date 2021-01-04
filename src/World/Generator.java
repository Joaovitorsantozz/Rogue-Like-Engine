package World;

import Main.Game;

import java.util.HashSet;
import java.util.Random;

public class Generator {
    public int opendDir, random;
    public Random rand = new Random();
    public boolean spawned;
    private RoomTemplates templates;
    private Level actualLevel;
    public int lastRoom,repeat;
    public Generator() {
        opendDir=rand.nextInt(5);
        templates=new RoomTemplates();
        Gen();

    }
    public void Gen(){
        if(!spawned){
            Game.handler.ClearObjects();
            if(opendDir==1||opendDir==0){
                //Bottom
                random= rand.nextInt(templates.bottom.length);
                Level level=new Level(templates.bottom[random]);
                setActualLevel(level);
            }else if(opendDir==2){
                //Top
                random= rand.nextInt(templates.top.length);
                Level level=new Level(templates.top[random]);
                setActualLevel(level);
            }else if(opendDir==3){
                //Left
                random= rand.nextInt(templates.left.length);
                Level level=new Level(templates.left[random]);
                setActualLevel(level);
            }else if(opendDir==4){
                //Right
                random= rand.nextInt(templates.right.length);
                Level level=new Level(templates.right[random]);
                setActualLevel(level);
            }
            NotSameLevel();
            spawned=true;

        }else{
            lastRoom=opendDir;
        }
    }
    public void NotSameLevel(){
        if(opendDir==lastRoom){
            repeat++;
        }else{
            repeat=0;
        }
        if(repeat>=2&&repeat<=4){
            repeat=0;
            opendDir=rand.nextInt(4-repeat);
        }
    }
    public Level getLevel(){
        return actualLevel;
    }
    public void setActualLevel(Level act){
        this.actualLevel=act;
    }

    public int getOpendDir() {
        return opendDir;
    }
}
