package com.ggj16.days.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ggj16.days.ToDaysGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "ToDays";
		config.width = 1920;
		config.height = 1080;
		//config.fullscreen= true;
		new LwjglApplication(new ToDaysGame(), config);
	}
}
