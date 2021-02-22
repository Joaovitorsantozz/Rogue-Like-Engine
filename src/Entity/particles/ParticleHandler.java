package Entity.particles;

import Entity.Global.ID;
import Main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ParticleHandler {

    public void CreateParticlesRect(int maxCount,int life,int x, int y,int w,float velX,float velY,Color color) {
        for (int i = 0; i < maxCount; i++) {
            Particles particle=new Particles(x, y,w,velX,velY,life,color,ID.Particle,null,true);
            particle.setOval(false);
            Game.handler.particles.add(particle);
        }
    }
    public void CreateParticlesOval(int maxCount,int life,int x, int y,float velX,float velY,Color color) {
        for (int i = 0; i < maxCount; i++) {
            Particles particle=new Particles(x, y,8,velX,velY,life,color,ID.Particle,null,true);
            particle.setOval(true);
            Game.handler.particles.add(particle);
        }
    }
    public void CreateAmount(int counts,int life, int particlescounts, int x, int y,int w,float velX,float velY,Color color) {
        for (int i = 0; i < counts; i++) {
            CreateParticlesRect(particlescounts,life,x + i * 128, y, w, velX,velY,color);
        }
    }
    public void CreateParticlesImage(int maxCount,int life,int x, int y, float velX, float velY,BufferedImage t) {
        for (int i = 0; i < maxCount; i++) {
            Game.handler.particles.add(new Particles(x, y,8,velX,velY,life,null,ID.Particle,t,true));
        }
    }
    public void CreateParticlesRectPerfect(int maxCount,int life,int x, int y,int w,float velX,float velY,Color color) {
        for (int i = 0; i < maxCount; i++) {
            Particles particle=new Particles(x, y,w,velX,velY,life,color,ID.Particle,null,false);
            particle.setOval(false);
            Game.handler.particles.add(particle);
        }
    }
}
