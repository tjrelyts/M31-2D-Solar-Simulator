package com.tylerjsanto.m31;

import com.badlogic.gdx.math.Vector2;

public class Planet extends CelestialObject {

    public Planet(String name, float mass, float radius, Vector2 position, Vector2 velocity, boolean anchored) {
        super(name, mass, radius, position, velocity, anchored);
    }

}
