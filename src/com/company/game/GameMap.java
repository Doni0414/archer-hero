package com.company.game;

import com.company.game.entity.Player;
import com.company.game.item.Arrow;
import com.company.game.item.Target;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;

public class GameMap extends Pane {
    private Player player;
    private Target target;
    private BlockMap blockMap;
    public GameMap(int width, int height, double blockSize) {
        this.blockMap = new BlockMap(width, height, blockSize);
    }

    public void build() {
        generateBlockMap();
        spawnPlayer();
        spawnTarget();

        player.idle();
    }
    public void generateBlockMap() {
        blockMap.generate();
        getChildren().add(blockMap);
    }
    public void spawnPlayer() {
        layout();
        Bounds bounds = getBoundsInParent();

        double playerHeight = blockMap.getBlockSize() * Configuration.PLAYER_BLOCK_RATIO;
        double playerWidth = playerHeight * Configuration.PLAYER_WIDTH_HEIGHT_RATIO;

        player = new Player(
                "Hero", Configuration.PLAYER_PATH, 100, 100,
                Configuration.PLAYER_PATH,
                Configuration.PLAYER_PREATTACK_PATH,
                Configuration.PLAYER_ATTACK_PATH,
                playerWidth, playerHeight
        );

        player.setLayoutX(20);
        player.setLayoutY(bounds.getHeight() - blockMap.getBlockSize() - playerHeight + 1);

        getChildren().add(player);
    }
    public void spawnTarget() {
        layout();
        Bounds bounds = getBoundsInParent();

        double targetSize = blockMap.getBlockSize() * Configuration.TARGET_BLOCK_RATIO;
        target = new Target();
        getChildren().add(target);
        target.resizeTo(targetSize, targetSize);
        target.setLayoutX(bounds.getWidth() - 20 - targetSize);
        target.setLayoutY(bounds.getHeight() - blockMap.getBlockSize() - targetSize + 10);
        getChildren().add(target.getEllipse());
    }

    public Target getTarget() {
        return target;
    }

    public Player getPlayer() {
        return player;
    }

    public BlockMap getBlockMap() {
        return blockMap;
    }

    public boolean checkCollision(Arrow arrow) {
        return blockMap.checkCollision(arrow) || target.collide(arrow);
    }
}