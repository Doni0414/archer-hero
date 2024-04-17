package com.company.game;

import com.company.game.block.Air;
import com.company.game.block.Block;
import com.company.game.block.ground.Ground;
import com.company.game.block.ground.GroundType;
import com.company.game.item.Arrow;
import javafx.scene.layout.GridPane;

public class BlockMap extends GridPane {
    private int mapWidth;
    private int mapHeight;
    private double blockSize;
    private Block[][] blocks;

    public BlockMap(int width, int height, double blockSize) {
        this.mapWidth = width;
        this.mapHeight = height;
        this.blocks = new Block[width][height];
        this.blockSize = blockSize;
    }

    public void generate() {
        setHgap(0);
        setVgap(0);
        int lastRow = mapHeight - 1;
        int lastCol = mapWidth - 1;
        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                setBlock(j, i, new Air());
            }
        }
        setBlock(0, lastRow, new Ground(GroundType.TYPE2));
        for (int i = 1; i < lastCol; i++) {
            setBlock(i, lastRow, new Ground(GroundType.TYPE3));
        }
        setBlock(lastCol, lastRow, new Ground(GroundType.TYPE4));
    }

    public void setBlock(int x, int y, Block block) {
        block.resizeTo(blockSize, blockSize);
        blocks[y][x] = block;
        add(block, x, y);
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
    }

    public double getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(double blockSize) {
        this.blockSize = blockSize;
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    public void setBlocks(Block[][] blocks) {
        this.blocks = blocks;
    }

    public boolean checkCollision(Arrow arrow) {
        for (Block[] bs: blocks) {
            for (Block block: bs) {
                if (!(block instanceof Air) && arrow.getBoundsInParent().intersects(block.getBoundsInParent())) {
                    return true;
                }
            }
        }
        return false;
    }
}
