package com.company;

import com.company.game.Configuration;
import com.company.game.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Game game = new Game("Arch Hero", Configuration.W, Configuration.H);
        Scene scene = new Scene(game, Configuration.W, Configuration.H);
        stage.setScene(scene);
        stage.setTitle("Arch Hero");
        stage.show();

        game.start();
    }
}
