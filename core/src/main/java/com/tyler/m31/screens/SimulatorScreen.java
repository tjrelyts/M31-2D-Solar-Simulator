package com.tyler.m31.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.*;

import com.tyler.m31.*;

import java.util.ArrayList;

public class SimulatorScreen implements Screen {

    private final Camera CAMERA;
    private final InputHandler INPUT_HANDLER;
    private final PhysicsEngine PHYSICS_ENGINE;
    private final RenderEngine RENDER_ENGINE;
    private final ArrayList<CelestialBody> SOLAR_SYSTEM;
    private final Viewport VIEWPORT;

    public SimulatorScreen() {
        CAMERA = new OrthographicCamera();
        INPUT_HANDLER = new InputHandler(CAMERA);
        PHYSICS_ENGINE = new PhysicsEngine();
        RENDER_ENGINE = new RenderEngine();
        VIEWPORT = new ScreenViewport(CAMERA);

        Gdx.input.setInputProcessor(INPUT_HANDLER);

        SOLAR_SYSTEM = new ArrayList<>();
        SOLAR_SYSTEM.add(new Star(Color.YELLOW, null, true, 1.989e30, "Sol", new Vector(), 6.957e8, null, new Vector()));
        SOLAR_SYSTEM.add(new Planet(Color.GREEN, 0.0167, false, 5.9742e24, "Earth", new Vector(1.4960e11, 0), 6.371e6, 1.4960e11, new Vector(0, 29784)));
        SOLAR_SYSTEM.add(new Planet(Color.RED, 0.0934, false, 6.4171e23, "Mars", new Vector(2.27152e11, 0), 3.3895e6, 2.27152e11, new Vector(0, 24077)));
    }

    @Override
    public void show() { }

    @Override
    public void render(float deltaTime) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        float scaledDeltaTime = deltaTime * INPUT_HANDLER.getTimeScale();

        INPUT_HANDLER.updateCameraMovement();
        RENDER_ENGINE.render(SOLAR_SYSTEM);
        PHYSICS_ENGINE.updateSystem(SOLAR_SYSTEM, scaledDeltaTime);

        CAMERA.update();
        RENDER_ENGINE.shapeRenderer.setProjectionMatrix(VIEWPORT.getCamera().combined);
    }

    @Override
    public void resize(int width, int height) {
        VIEWPORT.update(width, height, true);
    }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() { }

}
