package com.tyler.m31;

import com.badlogic.gdx.graphics.Color;

public class Star extends CelestialBody {
    public Star(Color bodyColor, Double eccentricity, boolean isAnchored, double mass, String name, Vector position, double radius, Double semiMajorAxis, Vector velocity) {
        super(CelestialBodyType.Star, bodyColor, eccentricity, isAnchored, mass, name, position, radius, semiMajorAxis, velocity);
    }
}
