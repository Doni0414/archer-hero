package com.company.game.block.ground;

import com.company.game.block.Block;
import javafx.scene.image.Image;

public class Ground extends Block {
    public Ground(GroundType groundType) {
        super("Ground", groundType.getPath());
    }
}