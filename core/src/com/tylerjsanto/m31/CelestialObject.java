package com.tylerjsanto.m31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class CelestialObject {

    private String name;
    private float mass;
    private float radius;
    private Vector2 position;
    private Vector2 velocity;

    private boolean anchored;

    private float AU = 1.4960e11f; // 1 Astronomical Unit in meters
    private float distScale = 50 / AU; // 250 pixels per AU

    private float SR = 6.957e8f; // 1 Solar Radius in meters
    private float radiScale = 50 / SR; // 100 pixels per SR

    public CelestialObject(String name, float mass, float radius, Vector2 position, Vector2 velocity, boolean anchored) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.position = position;
        this.velocity = velocity;
        this.anchored = anchored;
    }

    public void drawObject(ShapeRenderer shape) {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.circle((position.x * AU) * distScale + Gdx.graphics.getWidth() / 2, (position.y * AU) * distScale + Gdx.graphics.getHeight() / 2, radius * radiScale);
        shape.end();
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

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public boolean getAnchored() {
        return anchored;
    }

}
