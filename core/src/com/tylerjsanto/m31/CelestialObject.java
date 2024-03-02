package com.tylerjsanto.m31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class CelestialObject {

    private String name;
    private double mass;
    private double radius;
    private Vector position;
    private Vector velocity;

    private boolean anchored;

    private final double AU = 1.4960e11f; // 1 Astronomical Unit in meters
    private final double distScale = 250 / AU; // 100 pixels per AU

    private final double SR = 6.957e8f; // 1 Solar Radius in meters
    private final double radiScale = 100 / SR; // 50 pixels per SR

    public static final float G = 6.67430e-11f;

    public CelestialObject(String name, double mass, double radius, Vector position, Vector velocity, boolean anchored) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.position = position;
        this.velocity = velocity;
        this.anchored = anchored;
    }

    public void drawObject(ShapeRenderer shape) {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.circle((float) (position.x * distScale) + Gdx.graphics.getWidth() / 2f, (float) (position.y * distScale) + Gdx.graphics.getHeight() / 2f, (float) (radius * radiScale));
        shape.end();
    }

    public Vector calcGravForce(ArrayList<CelestialObject> objList) {
        Vector totalForce = new Vector();
        if (!this.anchored) {
            for (CelestialObject obj : objList) {
                if (!this.equals(obj)) {
                    double distance = obj.position.dst2(this.position);

                    double force = G * this.mass * obj.getMass() / distance;
                    Vector forceDir = (obj.position.sub(this.position)).nor();
                    totalForce.add(force * forceDir.x, force * forceDir.y);
                }
            }
        }
        return totalForce;
    }

    public void updateObject(ArrayList<CelestialObject> objList, float deltaTime) {
        Vector totalForce = this.calcGravForce(objList);
        this.velocity = this.velocity.add(new Vector((totalForce.x / this.mass) * deltaTime, (totalForce.y / this.mass) * deltaTime));
        this.position = this.position.add(new Vector(this.velocity.x * deltaTime, this.velocity.y * deltaTime));
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public boolean getAnchored() {
        return anchored;
    }

}
