package com.tylerjsanto.m31.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.*;
import com.tylerjsanto.m31.*;

import java.util.ArrayList;

public class GameScreen implements Screen {

    private final SolarSimulator solSim;
    private float AU = 1.4960e11f; // 1 Astronomical Unit in meters
    private ArrayList<CelestialObject> solSys;
    private float timeScale = 1.0f;

    public Viewport viewport;
    public Camera camera;

    public GameScreen(SolarSimulator solSim) {
        this.solSim = solSim;
        solSys = new ArrayList<>();
        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        // Position vector is in terms of AU
        solSys.add(new Planet("Sol", 1.98892e30, 6.957e8f, new Vector(0, 0), new Vector(0, 0), true));
        solSys.add(new Planet("Earth", 5.9742e24, 6.371e7f, new Vector(-1 * AU, 0), new Vector(0, 29784), false));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float deltaTime) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        float scaledDeltaTime = deltaTime * timeScale;
        for (CelestialObject obj : solSys) {

            obj.drawObject(solSim.shapeRend);
            obj.updateObject(solSys, scaledDeltaTime);
        }
        handleInput();
        camera.update();
        solSim.shapeRend.setProjectionMatrix(viewport.getCamera().combined);
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

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            camera.translate(0, 5, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            camera.translate(-5, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            camera.translate(0, -5, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            camera.translate(5, 0, 0);
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
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
