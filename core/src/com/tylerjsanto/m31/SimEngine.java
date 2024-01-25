package com.tylerjsanto.m31;

import com.badlogic.gdx.math.Vector2;

public class SimEngine {

    public static final float G = 6.67e-11f;

    public void updateSolarSystem(SolarSystem solSys, float deltaTime) {
        for (CelestialObject obj : solSys.getCelestialObjects()) {
            updateVelocity(obj, solSys, deltaTime);
            updatePosition(obj, deltaTime);
        }
    }

    public Vector2 calculateGravitationalForce(CelestialObject objOne, CelestialObject objTwo) {
        float sqrDist = objTwo.getPosition().dst2(objOne.getPosition());
        float force = G*(objOne.getMass() * objTwo.getMass()/sqrDist);

        Vector2 forceDir = (objTwo.getPosition().sub(objOne.getPosition())).nor();
        return new Vector2(force * forceDir.x, force * forceDir.y);
    }

    public void updateVelocity(CelestialObject obj, SolarSystem solSys, float deltaTime) {
        for (CelestialObject altObj : solSys.getCelestialObjects()) {
            if (!altObj.equals(obj)) {
                Vector2 force = calculateGravitationalForce(obj, altObj);
                Vector2 acceleration = force.scl(1/obj.getMass());
                obj.setCurrentVelocity(obj.getCurrentVelocity().add(acceleration.scl(deltaTime)));
            }
        }
    }

    public void updatePosition(CelestialObject obj, float deltaTime) {
        obj.getPosition().add(obj.getCurrentVelocity().scl(deltaTime));
    }

}
