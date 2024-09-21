package com.tyler.m31;

import com.badlogic.gdx.Game;
import com.tyler.m31.screens.SimulatorScreen;

public class SolarSimulator extends Game {

    @Override
    public void create() {
        this.setScreen(new SimulatorScreen());
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose() {}
}
