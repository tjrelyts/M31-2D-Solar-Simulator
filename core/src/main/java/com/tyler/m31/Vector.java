package com.tyler.m31;

/**
 * Represents a mathematical vector in 2D space with some common operations.
 */
public class Vector {

    public double x;
    public double y;

    public Vector() {
    }

    /**
     * Creates a new vector with the defined x and y components.
     *
     * @param x the x-coordinate of the vector.
     * @param y the y-coordinate of the vector.
     */
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector add(Vector other) {
        return this.add(other.x, other.y);
    }

    public Vector add(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public double calculateMagnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public double distanceTo(Vector other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }

    public Vector normalize() {
        double length = calculateMagnitude();
        if (length == 0) {
            System.out.println("Cannot normalize a zero vector.");
            return this;
        }
        return scale(1.0 / length);
    }

    public Vector scale(double scalar) {
        return new Vector(this.x * scalar, this.y * scalar);
    }

    public Vector subtract(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y);
    }
}
