package org.example;

import org.example.shapes.Sphere;
import org.example.shapes.Triangle;

public class Main {
    public static void main(String[] args) throws Exception {
        Scene scene = new Scene();

        Sphere sphere = new Sphere(new Vector3D(0, 0, 5), 1);
        Triangle triangle = new Triangle(
                new Vector3D(-2, -1, 4),
                new Vector3D(2, -1, 4),
                new Vector3D(0, 2, 4)
        );

        scene.addShape(sphere);
        scene.addShape(triangle);

        Renderer renderer = new Renderer(scene);
        renderer.render("image.png");
    }
}
