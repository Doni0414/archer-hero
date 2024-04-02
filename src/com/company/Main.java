package com.company;

import com.company.game.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        double w = 400, h = 400;
        Game game = new Game("Arch Hero", w, h);
        Scene scene = new Scene(game, w, h);
        stage.setScene(scene);
        stage.setTitle("Arch Hero");
        stage.show();

        game.start();
    }
}
