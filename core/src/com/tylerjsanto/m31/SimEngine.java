package com.tylerjsanto.m31;

import com.badlogic.gdx.math.Vector2;

public class SimEngine {

    public static final float G = 6.67e-11f;

    public Vector2 calculateGravitationalForce(CelestialObject objOne, CelestialObject objTwo) {
        float dx = objTwo.getPosition()[0] - objOne.getPosition()[0];
        float dy = objTwo.getPosition()[1] - objOne.getPosition()[1];
        float dSquared = dx*dx + dy*dy;
        float force = G*(objOne.getMass() * objTwo.getMass()/dSquared);

        float angle = (float)Math.atan2(dy, dx);
        return new Vector2(force * (float)Math.cos(angle), force * (float)Math.sin(angle));
    }

}
