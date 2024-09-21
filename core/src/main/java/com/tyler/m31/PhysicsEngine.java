package com.tyler.m31;

import java.util.ArrayList;

public class PhysicsEngine {

    public PhysicsEngine() { }

    public void updateSystem(ArrayList<CelestialBody> bodyList, float deltaTime) {
        for (CelestialBody body : bodyList) {
            if (!body.isAnchored()){
                Vector netForce = OrbitalMechanicsUtility.calculateGravitationalForce(body, bodyList);
                body.setVelocity(body.getVelocity().add(new Vector((netForce.x / body.getMass()) * deltaTime, (netForce.y / body.getMass()) * deltaTime)));
                body.setPosition(body.getPosition().add(new Vector(body.getVelocity().x * deltaTime, body.getVelocity().y * deltaTime)));
            }
        }
    }
}
