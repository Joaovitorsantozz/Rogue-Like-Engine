package Main.utils;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Animator{
    private int frames,maxFrames,index,maxIndex;
    private BufferedImage anim[];
    public boolean can=true;
    public Animator(int maxFrames, int maxIndex) {
        this.maxIndex=maxIndex;
        this.maxFrames=maxFrames;
        this.anim=new BufferedImage[maxIndex];
    }
    public BufferedImage getAnimation() {
        frames+=2;
        if(frames>maxFrames){
            frames=0;
            index++;
        }
        if(index>=maxIndex) {
            index=0;
        }
        return anim[index];
    }
    public BufferedImage getAnimSolo(){
        frames+=2;
        if(frames>maxFrames){
            frames=0;
            index++;
        }
        if(index>=maxIndex) {
            index=0;
        }
        return anim[index];
    }
    private void clearAnim(){
        Arrays.fill(anim, null);
    }
    public void setAnimation(BufferedImage anim[]){
        this.anim=anim;
    }

    public int getMaxFrames() {
        return maxFrames;
    }
    public int getIndex(){
        return index;
    }
    public void setMaxFrames(int maxFrames) {
        this.maxFrames = maxFrames;
    }
    public int getMaxIndex() {
        return maxIndex;
    }
    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }
    public void setIndex(int id){
        this.index=id;
    }
}
