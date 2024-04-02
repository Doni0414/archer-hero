package com.company.game.entity;

import com.company.game.Sprite;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Entity extends Sprite {
    protected int hp;
    protected int maxHP;
    protected String idlePath;
    protected String preAttackPath;
    protected String attackPath;
    protected List<Image> idleImages;
    protected List<Image> preAttackImages;
    protected List<Image> attackImages;

    protected double desiredWidth;
    protected double desiredHeight;

    public Entity(String name, String path, int hp, int maxHP, String idlePath, String preAttackPath, String attackPath, double desiredWidth, double desiredHeight) {
        super(name, path);
        this.hp = hp;
        this.maxHP = maxHP;
        this.idlePath = idlePath;
        this.preAttackPath = preAttackPath;
        this.attackPath = attackPath;
        this.desiredWidth = desiredWidth;
        this.desiredHeight = desiredHeight;

        resizeToDesired();
    }

    public void idle() {
        if (idleImages == null) {
            loadIdleImages();
        }
//        animate(idleImages);

    }

    private void loadIdleImages() {
        File file = new File(idlePath);
        idleImages = new ArrayList<>();
        for (File f: file.listFiles()) {
            idleImages.add(new Image(f.getAbsolutePath()));
        }
    }

    public void preAttack() {

    }

    public void attack() {

    }

    public void animate(List<Image> images) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for (Image image: images) {
                    setImage(image);
                    resizeTo(desiredWidth, desiredHeight);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        timer.start();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void resizeToDesired() {
        resizeTo(desiredWidth, desiredHeight);
    }
}
