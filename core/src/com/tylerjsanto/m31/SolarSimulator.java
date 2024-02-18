package com.tylerjsanto.m31;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.tylerjsanto.m31.screens.GameScreen;

public class SolarSimulator extends Game {

	public ShapeRenderer shape;
	public SimEngine simEng;

	@Override
	public void create() {
		shape = new ShapeRenderer();
		simEng = new SimEngine();
		this.setScreen(new GameScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

}
