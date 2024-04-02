package com.company.game;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

import java.io.File;

public class BackgroundComponent extends GridPane {
    private String path;
    private double tileHeight;
    private int rows;
    private int cols;

    public BackgroundComponent(String path, double tileHeight, int rows, int cols){
        this.path = path;
        this.tileHeight = tileHeight;
        this.rows = rows;
        this.cols = cols;
    }

    public void generate() {
        int i = 0, j = 0;
        double tileWidth = tileHeight;

        File file =  new File(path);
        for (File f: file.listFiles()) {
            Image image = new Image(f.getAbsolutePath());
            Sprite sprite = new Sprite("background", image);
            sprite.resizeTo(1008, 1008);
            sprite.setFitWidth(tileWidth);
            sprite.setFitHeight(tileHeight);
            add(sprite, j, i);

            j++;
            if (j == cols) {
                i++;
                j = 0;
            }
        }
    }
}
