package com.opi.export;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameCamera {
	
	private static OrthographicCamera camera;
	
	public static void initialize() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Export.WIDTH, Export.HEIGHT);
	}
	
	public static void tick() {
		camera.update();
	}
	
	public static OrthographicCamera get() {
		return camera;
	}
	
	public static void resize(float width, float height) {
		camera.setToOrtho(false, width, height);
	}
}
