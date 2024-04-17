package com.company.game;

import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Configuration {
    public final static double W = 400;
    public final static double H = 400;
    public final static double INFORMATION_AREA_TEXT_RATIO = 6 / 198.0;
    public static final int GAME_MAP_WIDTH = 10;
    public static final int GAME_MAP_HEIGHT = 10;
    public static Font INTER_FONT;
    public final static String PLAYER_PATH = "C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\entities\\player.idle\\idle1.png";
    public final static String PLAYER_IDLE_PATH = "C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\entities\\player.idle";
    public final static String PLAYER_PREATTACK_PATH = "C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\entities\\player\\preattack\\preattack.png";
    public final static String PLAYER_ATTACK_PATH = "";
    public final static double PLAYER_BLOCK_RATIO = 22 / 18.0;
    public final static double PLAYER_WIDTH_HEIGHT_RATIO = 15 / 22.0;
    public static final String TARGET_PATH = "C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\items\\target\\target.png";
    public static final double TARGET_BLOCK_RATIO = 28 / 18.0;
    public static final String ARROW_PATH = "C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\items\\arrow\\13.png";
    public static final double G = 9.8;
    public static final double ARROW_MAX_SPEED = 30;
    public static final double PIXEL_TO_METERS = 1 / 10.0;

    static {
        try {
            INTER_FONT = Font.loadFont(new FileInputStream("C:\\Users\\сулпак\\Downloads\\Inter\\Inter-Regular.otf"), H * INFORMATION_AREA_TEXT_RATIO);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
