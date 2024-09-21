package com.tyler.m31;

import com.badlogic.gdx.graphics.Color;

public class CelestialBody {

    public Color bodyColor;
    public CelestialBodyType bodyType;
    public String name;

    private final boolean isAnchored;

    private Double eccentricity;
    private double mass;
    private Vector position;
    private double radius;
    private Double semiMajorAxis;
    private Vector velocity;

    public CelestialBody(CelestialBodyType bodyType, Color bodyColor, Double eccentricity, boolean isAnchored, double mass, String name,
                         Vector position, double radius, Double semiMajorAxis, Vector velocity) {
        this.bodyType = bodyType;
        this.bodyColor = bodyColor;
        this.eccentricity = eccentricity;
        this.isAnchored = isAnchored;
        this.mass = mass;
        this.name = name;
        this.position = position;
        this.radius = radius;
        this.semiMajorAxis = semiMajorAxis;
        this.velocity = velocity;
    }

    public Double getEccentricity() {
        return eccentricity;
    }

    public boolean isAnchored() {
        return isAnchored;
    }

    public double getMass() {
        return mass;
    }

    public Vector getPosition() {
        return position;
    }

    public double getRadius() {
        return radius;
    }

    public Double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setEccentricity(Double eccentricity) {
        if (eccentricity < 0 || eccentricity >= 1) {
            throw new IllegalArgumentException("Eccentricity must be in the range [0, 1).");
        }
        this.eccentricity = eccentricity;
    }

    public void setMass(double mass) {
        if (mass < 0) {
            throw new IllegalArgumentException("Mass cannot be negative");
        }
        this.mass = mass;
    }

    public void setPosition(Vector position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        this.position = position;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    public void setSemiMajorAxis(Double semiMajorAxis) {
        if (semiMajorAxis <= 0) {
            throw new IllegalArgumentException("Semi-major axis must be positive");
        }
        this.semiMajorAxis = semiMajorAxis;
    }

    public void setVelocity(Vector velocity) {
        if (velocity == null) {
            throw new IllegalArgumentException("Velocity cannot be null");
        }
        this.velocity = velocity;
    }
}
