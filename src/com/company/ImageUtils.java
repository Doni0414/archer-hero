package com.company;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class ImageUtils {
    public static WritableImage resizeWithoutLoss(Image image, int desiredWidth, int desiredHeight) {
        WritableImage res = new WritableImage((int)desiredWidth, (int)desiredHeight);

        PixelReader reader = image.getPixelReader();
        PixelWriter writer = res.getPixelWriter();

        double scaleX = desiredWidth / image.getWidth();
        double scaleY = desiredHeight / image.getHeight();

        for (int y = 0; y < desiredHeight; y++) {
            for (int x = 0; x < desiredWidth; x++) {
                int originalX = (int) (x / scaleX);
                int originalY = (int) (y / scaleY);
                writer.setArgb(x, y, reader.getArgb(originalX, originalY));
            }
        }
        return res;
    }
}
