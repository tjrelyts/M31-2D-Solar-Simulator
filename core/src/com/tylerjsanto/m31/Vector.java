package com.tylerjsanto.m31;

public class Vector {

    public double x;
    public double y;

    public Vector() {
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double len() {
        return Math.sqrt(x * x + y * y);
    }

    public double len2() {
        return x * x + y * y;
    }

    public Vector sub(Vector v) {
        x -= v.x;
        y -= v.y;
        return this;
    }

    public Vector sub(double x, double y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector add(Vector v) {
        x += v.x;
        y += v.y;
        return this;
    }

    public Vector add(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector nor() {
        double len = len();
        if (len != 0) {
            x /= len;
            y /= len;
        }
        return this;
    }

    public double dst(Vector v) {
        final double x_d = v.x - x;
        final double y_d = v.y - y;
        return Math.sqrt(x_d * x_d + y_d * y_d);
    }

    public double dst2(Vector v) {
        final double x_d = v.x - x;
        final double y_d = v.y - y;
        return x_d * x_d + y_d * y_d;
    }
}
