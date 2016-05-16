package com.vusause.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.vusause.game.AstGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = AstGame.WIDTH;
		config.height = AstGame.HEIGHT;
		config.title = AstGame.TITLE;
		new LwjglApplication(new AstGame(), config);
	}
}
