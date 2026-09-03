package org.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Renderer {
    private Scene scene;

    public Renderer(Scene scene) {
        this.scene = scene;
    }

    public void render(String fileName) throws IOException {
        int width = 200;
        int height = 200;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Vector3D direction = new Vector3D(
                        (x - 100) / 100.0,
                        (100 - y) / 100.0,
                        1
                );
                Ray ray = new Ray(new Vector3D(0, 0, 0), direction);

                if (scene.hit(ray)) {
                    image.setRGB(x, y, 255 << 16);
                } else {
                    image.setRGB(x, y, 0);
                }
            }
        }

        ImageIO.write(image, "png", new File(fileName));
    }
}
