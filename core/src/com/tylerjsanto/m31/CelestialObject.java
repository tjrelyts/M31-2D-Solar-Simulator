package com.tylerjsanto.m31;

import com.badlogic.gdx.math.Vector2;

public class CelestialObject {

    private String name;
    private float mass;
    private float radius;
    private Vector2 position;

    private Vector2 initialVelocity;
    private Vector2 currentVelocity;

    public CelestialObject(String name, float mass, float radius, Vector2 position, Vector2 initialVelocity, Vector2 currentVelocity) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.position = position;
        this.initialVelocity = initialVelocity;
        this.currentVelocity = currentVelocity;
    }

    public String getName() {
        return name;
    }

    public float getMass() {
        return mass;
    }

    public float getRadius() {
        return radius;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getInitialVelocity() {
        return initialVelocity;
    }

    public Vector2 getCurrentVelocity() {
        return currentVelocity;
    }

    public void setCurrentVelocity(Vector2 currentVelocity) {
        this.currentVelocity = currentVelocity;
    }

}
