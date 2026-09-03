package org.example.shapes;

import org.example.Ray;
import org.example.Vector3D;

public class Sphere implements Shape {
    private Vector3D center;
    private double radius;

    public Sphere(Vector3D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean hit(Ray ray) {
        double x = ray.origin.x - center.x;
        double y = ray.origin.y - center.y;
        double z = ray.origin.z - center.z;

        double a = ray.direction.x * ray.direction.x
                + ray.direction.y * ray.direction.y
                + ray.direction.z * ray.direction.z;
        double b = 2 * (x * ray.direction.x
                + y * ray.direction.y
                + z * ray.direction.z);
        double c = x * x + y * y + z * z - radius * radius;

        double discriminant = b * b - 4 * a * c;
        return discriminant >= 0;
    }
}
