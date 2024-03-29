package com.tylerjsanto.m31;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

	public class DesktopLauncher {
		public static void main (String[] arg) {
			Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
			config.setTitle("M31 - Solar Simulator");
			config.setWindowedMode(1280, 800);
			config.useVsync(true);
			config.setForegroundFPS(60);
			new Lwjgl3Application(new SolarSimulator(), config);
		}
}
