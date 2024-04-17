package com.company.game;

import com.company.ImageUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sprite extends ImageView {
    protected String name;

    public Sprite(String name, String path) {
        this(name, new Image(path));
    }
    public Sprite(String name, Image image) {
        super(image);
        this.name = name;
    }
    public void resizeTo(double width, double height) {
        setImage(ImageUtils.resizeWithoutLoss(getImage(), (int) width, (int) height));
        setFitWidth(width);
        setFitHeight(height);
    }

    public void resizeWithKeepRatio(double height) {
        double w = getImage().getWidth(), h = getImage().getHeight();
        double ratio = w / h;
        resizeTo(height * ratio, height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
