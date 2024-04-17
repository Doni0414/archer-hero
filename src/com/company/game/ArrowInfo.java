package com.company.game;

import javafx.scene.text.Text;

public class ArrowInfo extends Text {
    private static final String FORMAT = "Стрела:\nСкорость: %.2fм/c\nУгол: %.2f\u00B0";

    public void build() {
        setText(getFormattedText(0, 0));
    }

    public void update(double speed, double angle) {
        setText(getFormattedText(speed, angle));
    }

    public static String getFormattedText(double speed, double angle) {
        return String.format(FORMAT, speed, angle);
    }
}
