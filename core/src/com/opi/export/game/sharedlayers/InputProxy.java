package com.opi.export.game.sharedlayers;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.opi.export.ObjectLayer;

public class InputProxy {
	
	public static final int PRESS_W = 1;
	public static final int PRESS_A = 2;
	public static final int PRESS_S = 3;
	public static final int PRESS_D = 4;

	private static List<ObjectLayer> layers;
	
	public static void setLayers(List<ObjectLayer> layers) {
		InputProxy.layers = layers;
	}
	
	public static void tick() {
		if(Gdx.input.isKeyPressed(Keys.W)) {
			processEvent(PRESS_W);
		} else if(Gdx.input.isKeyPressed(Keys.A)) {
			processEvent(PRESS_A);
		} else if(Gdx.input.isKeyPressed(Keys.S)) {
			processEvent(PRESS_S);
		} else if(Gdx.input.isKeyPressed(Keys.D)) {
			processEvent(PRESS_D);
		}
	}
	
	private static void processEvent(int event) {
		for(int i = layers.size() - 1; i >= 0; i--) {
			if(layers.get(i).processInput(event)) {
				break;
			} else {
				continue;
			}
		}
	}
}
