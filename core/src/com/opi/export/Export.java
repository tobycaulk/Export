package com.opi.export;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Export implements ApplicationListener {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	public static float viewport_width = WIDTH;
	public static float viewport_height = HEIGHT;
	public static float aspectRatio = 1;
	public static GameCamera camera;

	private FitViewport viewport;
	private SpriteBatch batch;
	private boolean resizedOnce;
	private Screen currentScreen;
	
	@Override
	public void create () {
		GameCamera.initialize();
		viewport = new FitViewport(viewport_width, viewport_height, GameCamera.get());
		batch = new SpriteBatch();
		
		switchScreen(new TestScreen(this));
	}
 
	@Override
	public void render () {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		GameCamera.tick();

		batch.setProjectionMatrix(GameCamera.get().combined);
		
		batch.begin();
		currentScreen.draw(batch);
		batch.end();
		
		currentScreen.tick();
	}

	@Override
	public void resize(int width, int height) {
		aspectRatio = (float) width / WIDTH;
		viewport_width = width;
		viewport_height = height;
		
		viewport.update((int) viewport_width, (int) viewport_height); 
		currentScreen.resize();
		
		resizedOnce = true;
	}
	
	public void switchScreen(Screen screen) {
		currentScreen = screen;
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
