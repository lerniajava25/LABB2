package org.example;

import org.example.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private List<Shape> shapes;

    public Scene() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public boolean hit(Ray ray) {
        for (Shape shape : shapes) {
            if (shape.hit(ray)) {
                return true;
            }
        }

        return false;
    }
}
