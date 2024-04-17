package com.company.game;

import com.company.game.item.Target;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class InformationArea extends StackPane {
    private TargetInfo targetInfo;
    private ArrowInfo arrowInfo;
    public InformationArea(Target target) {
        targetInfo = new TargetInfo(target);
        arrowInfo = new ArrowInfo();
    }

    public void build() {
        VBox vBox = new VBox(Configuration.H * 7 / 198.0);
        vBox.setPrefWidth(100);
        vBox.setPadding(new Insets(10));

        targetInfo.build();
        arrowInfo.build();

        vBox.getChildren().addAll(targetInfo, arrowInfo);

        vBox.layout();

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(200);
        rectangle.setHeight(vBox.getBoundsInParent().getHeight() + 5);
        rectangle.setStyle("-fx-fill: D9D9D9;");
        rectangle.setStrokeWidth(1);
        rectangle.setStroke(Color.BLACK);
        rectangle.setOpacity(0.2);

        getChildren().add(rectangle);
        getChildren().add(vBox);

        targetInfo.setFont(Configuration.INTER_FONT);
        arrowInfo.setFont(Configuration.INTER_FONT);
    }

    public void update(double speed, double angle) {
        arrowInfo.update(speed, angle);
    }
}
