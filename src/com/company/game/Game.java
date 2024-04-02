package com.company.game;

import javafx.scene.layout.Pane;

public class Game extends Pane {
    private String title;

    public Game(String title, double w, double h) {
        setTitle(title);
        setWidth(w);
        setHeight(h);
    }

    public void start() {
        generateBackground("C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\backgrounds");
        generateGameMap(10, 10);
    }

    private void generateBackground(String path) {
        Background background = new Background(path, getWidth(), getHeight());
        background.build();
        getChildren().add(background);
    }

    private void generateGameMap(int width, int height) {
        double blockSize = getWidth() / width;
        GameMap gameMap = new GameMap(width, height, blockSize);
        gameMap.build();
        getChildren().add(gameMap);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
