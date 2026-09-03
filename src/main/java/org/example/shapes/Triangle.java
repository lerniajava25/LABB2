package org.example.shapes;

import org.example.Ray;
import org.example.Vector3D;

public class Triangle implements Shape {
    private Vector3D first;
    private Vector3D second;
    private Vector3D third;

    public Triangle(Vector3D first, Vector3D second, Vector3D third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public boolean hit(Ray ray) {
        Vector3D edge1 = subtract(second, first);
        Vector3D edge2 = subtract(third, first);
        Vector3D h = cross(ray.direction, edge2);

        double a = dot(edge1, h);
        if (a > -0.000001 && a < 0.000001) {
            return false;
        }

        double f = 1.0 / a;
        Vector3D s = subtract(ray.origin, first);
        double u = f * dot(s, h);
        if (u < 0 || u > 1) {
            return false;
        }

        Vector3D q = cross(s, edge1);
        double v = f * dot(ray.direction, q);
        if (v < 0 || u + v > 1) {
            return false;
        }

        double distance = f * dot(edge2, q);
        return distance > 0.000001;
    }

    private Vector3D subtract(Vector3D a, Vector3D b) {
        return new Vector3D(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    private Vector3D cross(Vector3D a, Vector3D b) {
        return new Vector3D(
                a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x
        );
    }

    private double dot(Vector3D a, Vector3D b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }
}
