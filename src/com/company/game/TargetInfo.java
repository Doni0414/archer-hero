package com.company.game;

import com.company.game.item.Target;
import javafx.scene.text.Text;

public class TargetInfo extends Text {
    private Target target;
    public TargetInfo(Target target) {
        this.target = target;
    }
    public void build() {
        String text = String.format("Мишень:\nx: %.2fм\ny: %.2fм", target.getXCoordinate(), target.getYCoordinate());
        setText(text);
    }
}
