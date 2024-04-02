package com.company.game.entity;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;

import java.util.List;

public class EntityAnimationTimer extends AnimationTimer {
    private List<Image> images;

    public EntityAnimationTimer(List<Image> images) {
        this.images = images;
    }

    @Override
    public void handle(long l) {
        for (Image image: images) {

        }
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
