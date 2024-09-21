package com.tyler.m31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;

public class InputHandler implements InputProcessor {

    private final Camera CAMERA;
    private final float DAY_TIMESCALE = 86400f;

    private float timeScale;

    public InputHandler(Camera camera) {
        this.CAMERA = camera;
        this.timeScale = DAY_TIMESCALE;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.NUM_1:
                timeScale = DAY_TIMESCALE;
                break;
            case Input.Keys.NUM_2:
                timeScale = DAY_TIMESCALE * 7f;
                break;
            case Input.Keys.NUM_3:
                timeScale = DAY_TIMESCALE * 30.44f;
                break;
            case Input.Keys.NUM_4:
                timeScale = DAY_TIMESCALE * 365f;
                break;
            default:
                return false;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    public float getTimeScale() {
        return timeScale;
    }

    // This method will be called every frame from the main game loop
    public void updateCameraMovement() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            CAMERA.translate(0, 5, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            CAMERA.translate(-5, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            CAMERA.translate(0, -5, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            CAMERA.translate(5, 0, 0);
        }
    }
}
