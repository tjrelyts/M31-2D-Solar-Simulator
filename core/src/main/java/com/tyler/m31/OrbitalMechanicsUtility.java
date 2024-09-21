package com.tyler.m31;

import java.util.ArrayList;

public class OrbitalMechanicsUtility {

    private static final double GRAVITATIONAL_CONSTANT = 6.67430e-11f;

    public static Vector calculateGravitationalForce(CelestialBody currentBody, ArrayList<CelestialBody> bodyList) {
        Vector totalForce = new Vector();

        for (CelestialBody otherBody : bodyList) {
            if (!currentBody.equals(otherBody)) {
                double distance = otherBody.getPosition().distanceTo(currentBody.getPosition());

                double force = GRAVITATIONAL_CONSTANT * currentBody.getMass() * otherBody.getMass() / (distance * distance);
                Vector forceDirection = (otherBody.getPosition().subtract(currentBody.getPosition())).normalize();
                totalForce.add(force * forceDirection.x, force * forceDirection.y);
            }
        }
        return totalForce;
    }
}
