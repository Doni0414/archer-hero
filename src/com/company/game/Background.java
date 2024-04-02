package com.company.game;

import javafx.scene.layout.HBox;

public class Background extends HBox {
    private String path;
    private double width;
    private double height;

    public Background(String path, double w, double h){
        this.path = path;
        this.width = w;
        this.height = h;
    }

    public void build() {
        int rows = 3;
        int cols = 2;

        double tileHeight = height / rows;
        double tileWidth = tileHeight;

        double componentWidth = tileWidth * cols;
        int numOfComponents = (int) (Math.ceil(width / componentWidth));

        for (int i = 0; i < numOfComponents; i++) {
            BackgroundComponent component = new BackgroundComponent(path, tileHeight, rows, cols);
            component.generate();
            getChildren().add(component);
        }
    }
}
