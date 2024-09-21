package com.tyler.m31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class RenderEngine {

    public ShapeRenderer shapeRenderer;

    /// 1 Astronomical Unit (AU) in meters.
    private final double ASTRONOMICAL_UNIT = 1.4960e11f;
    private final double DISTANCE_SCALE = 1.0 / (ASTRONOMICAL_UNIT / 500);

    /// 1 Solar Radius (SR) unit in meters.
    private final double SOLAR_RADIUS = 6.957e8f;
    private final double RADIUS_SCALE = 1.0 / (SOLAR_RADIUS / 200);

    public RenderEngine() {
        shapeRenderer = new ShapeRenderer();
    }

    public void render(ArrayList<CelestialBody> bodyList) {
        for (CelestialBody body : bodyList) {
            renderOrbitalPath(body);
            renderCelestialBody(body);
        }
    }

    private void renderCelestialBody(CelestialBody body) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(body.bodyColor);
        shapeRenderer.circle(
            (float) (body.getPosition().x * DISTANCE_SCALE) + Gdx.graphics.getWidth() / 2f,
            (float) (body.getPosition().y * DISTANCE_SCALE) + Gdx.graphics.getHeight() / 2f,
            (float) (body.getRadius() * RADIUS_SCALE));
        shapeRenderer.end();
    }

    private void renderOrbitalPath(CelestialBody body) {

    }

}
