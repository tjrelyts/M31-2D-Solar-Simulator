package com.tylerjsanto.m31;

import com.badlogic.gdx.math.Vector2;

public class SimEngine {

    public static final float G = 6.67430e-11f;

    // LibGDX implementation of calculateGravitationalForce
    public Vector2 calculateGravitationalForce(CelestialObject objOne, CelestialObject objTwo) {
            float distance = objTwo.getPosition().cpy().sub(objOne.getPosition()).len();

            float force = G * (objOne.getMass() * objTwo.getMass() / distance * distance);

            Vector2 forceDir = (objTwo.getPosition().cpy().sub(objOne.getPosition())).nor();
            return new Vector2(force * forceDir.x, force * forceDir.y);
    }

    public void updateObject(CelestialObject obj, SolarSystem solSys, float deltaTime) {
        Vector2 totalForce = new Vector2(0, 0);
        if (!obj.getAnchored()) {
            for (CelestialObject otherObj : solSys.getCelestialObjects()) {
                if (!obj.equals(otherObj)) {
                    Vector2 force = calculateGravitationalForce(obj, otherObj);
                    totalForce.add(force);
                }
            }
            Vector2 acceleration = totalForce.scl(1 / obj.getMass() * deltaTime);

            obj.setVelocity(obj.getVelocity().add(acceleration).cpy());

            obj.setPosition(obj.getPosition().add(obj.getVelocity().cpy().scl(deltaTime)).cpy());

        }
    }

}
