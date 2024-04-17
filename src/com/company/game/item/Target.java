package com.company.game.item;

import com.company.game.Configuration;
import javafx.scene.shape.Ellipse;

public class Target extends Item {
    private Ellipse ellipse;

    public Target() {
        super("target", Configuration.TARGET_PATH);
    }

    public Ellipse getEllipse() {
        if (ellipse == null) {
            ellipse = new Ellipse();
            ellipse.setRadiusX(10);
            ellipse.setRadiusY(18);
            ellipse.setCenterX(getLayoutX() + getFitWidth() / 2 + 5);
            ellipse.setCenterY(getLayoutY() + getFitHeight() / 2 - 5);
            ellipse.setOpacity(0);
        }
        return ellipse;
    }

    public double getXCoordinate() {
        return getLayoutX() * Configuration.PIXEL_TO_METERS;
    }
    public double getYCoordinate() {
        return 0;
    }
    public boolean collide(Arrow arrow) {
        return ellipse.getBoundsInParent().intersects(arrow.getBoundsInParent());
    }
}
