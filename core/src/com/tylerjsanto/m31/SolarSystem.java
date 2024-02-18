package com.tylerjsanto.m31;

import java.util.ArrayList;

public class SolarSystem {

    private ArrayList<CelestialObject> celestialObjects;

    public SolarSystem() {
        celestialObjects = new ArrayList<CelestialObject>();
    }

    public void addObject(CelestialObject obj) {
        celestialObjects.add(obj);
    }

    public void removeObject(CelestialObject obj) {
        celestialObjects.remove(obj);
    }

    public ArrayList<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

}
