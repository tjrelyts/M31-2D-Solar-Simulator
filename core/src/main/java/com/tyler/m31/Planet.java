package com.tyler.m31;

import com.badlogic.gdx.graphics.Color;

public class Planet extends CelestialBody {
    public Planet(Color bodyColor, Double eccentricity, boolean isAnchored, double mass, String name, Vector position, double radius, Double semiMajorAxis, Vector velocity) {
        super(CelestialBodyType.Planet, bodyColor, eccentricity, isAnchored, mass, name, position, radius, semiMajorAxis, velocity);
    }
}
