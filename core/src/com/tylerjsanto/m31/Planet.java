package com.tylerjsanto.m31;

import com.badlogic.gdx.math.Vector2;

public class Planet extends CelestialObject {

    public Planet(String name, float mass, float radius, float[] position, Vector2 initialVelocity, Vector2 currentVelocity) {
        super(name, mass, radius, position, initialVelocity, currentVelocity);
    }

}
