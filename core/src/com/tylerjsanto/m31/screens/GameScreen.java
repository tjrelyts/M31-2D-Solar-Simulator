package com.tylerjsanto.m31.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.tylerjsanto.m31.*;

public class GameScreen implements Screen {

    private SolarSimulator solSim;
    private float massScale = 1 / 1.98892e30f;
    private float timeScale = 1.0f;
    public SolarSystem solSys = new SolarSystem();
    private float SR = 6.957e8f; // 1 Solar Radius in meters
    private float radiScale = 50 / SR; // 100 pixels per SR
    public GameScreen(SolarSimulator solSim) {
        this.solSim = solSim;
        System.out.println(Math.sqrt(6.67430e-11f * 5.9742e24f / 63710000));
        // Position vector is in terms of AU
        solSys.addObject(new Planet("Sol", 1.98892e30f * massScale, 695700000, new Vector2(0, 0), new Vector2(0, 0), true));
        solSys.addObject(new Planet("Earth", 5.9742e24f * massScale, 63710000, new Vector2(-5, 0), new Vector2(0, 0), false));
        solSys.addObject(new Planet("Earth", 6.39e23f * massScale, 33890000, new Vector2(-2, 0), new Vector2(0, 0), false));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float deltaTime) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        float scaledDeltaTime = deltaTime * timeScale;
        for (CelestialObject obj : solSys.getCelestialObjects()) {
            obj.drawObject(solSim.shape);
            solSim.simEng.updateObject(obj, solSys, scaledDeltaTime);
        }
        handleInput();
    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            // Increase time scale when UP key is pressed
            timeScale *= 1.25f; // Double the time scale factor
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            // Decrease time scale when DOWN key is pressed
            timeScale /= 1.25f; // Halve the time scale factor
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
