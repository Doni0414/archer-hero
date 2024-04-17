package com.company.game;

import com.company.game.block.Block;
import com.company.game.item.Arrow;
import com.company.game.item.Target;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Game extends Pane {
    private String title;
    private Background background;
    private GameMap gameMap;
    private InformationArea informationArea;
    private double dragStartX;
    private double dragStartY;
    private double dragEndX;
    private double dragEndY;

    private Timeline timeline;

    public Game(String title, double w, double h) {
        setTitle(title);
        setWidth(w);
        setHeight(h);
    }

    public void start() {
        background = generateBackground("C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\backgrounds");
        gameMap = generateGameMap(Configuration.GAME_MAP_WIDTH, Configuration.GAME_MAP_HEIGHT);
        informationArea = generateInformationArea(Configuration.H, gameMap.getTarget());

        getChildren().add(background);
        getChildren().add(gameMap);
        getChildren().add(informationArea);

        setOnMousePressed(e -> {
            dragStartX = e.getX();
            dragStartY = e.getY();
        });

        setOnMouseDragged(e -> {
            dragEndX = e.getX();
            dragEndY = e.getY();
            gameMap.getPlayer().preAttack();

            double speed = getSpeed(dragStartX, dragStartY, dragEndX, dragEndY);
            double angle = getAngle(dragStartX, dragStartY, dragEndX, dragEndY);

            informationArea.update(speed, angle);
        });

        setOnMouseReleased(e -> {
            gameMap.getPlayer().idle();

            double speed = getSpeed(dragStartX, dragStartY, dragEndX, dragEndY);
            double angle = getAngle(dragStartX, dragStartY, dragEndX, dragEndY);

            Arrow arrow = new Arrow(speed, angle);

            arrow.setX(gameMap.getPlayer().getLayoutX() + gameMap.getPlayer().getFitWidth());
            arrow.setY(gameMap.getPlayer().getLayoutY() + 20);

            getChildren().add(arrow);

            timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, event -> {
                        arrow.move();
                        if (gameMap.checkCollision(arrow)) {
                            timeline.stop();
                        }
                    }),
                    new KeyFrame(Duration.seconds(0.033))
            );

            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        });
    }

    private Background generateBackground(String path) {
        Background background = new Background(path, getWidth(), getHeight());
        background.build();
        return background;
    }

    private GameMap generateGameMap(int width, int height) {
        double blockSize = getWidth() / width;
        GameMap gameMap = new GameMap(width, height, blockSize);
        gameMap.build();
        return gameMap;
    }

    private InformationArea generateInformationArea(double h, Target target) {
        InformationArea area = new InformationArea(target);
        area.build();
        return area;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public double getSpeed(double x1, double y1, double x2, double y2) {
        return Math.min(Math.hypot(x1 - x2, y1 - y2) * Configuration.PIXEL_TO_METERS, Configuration.ARROW_MAX_SPEED);
    }
    public double getAngle(double x1, double y1, double x2, double y2) {
        return Math.toDegrees(Math.atan((y2 - y1) / (x1 - x2)));
    }
}
