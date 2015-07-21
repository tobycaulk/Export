package com.opi.export.game.sharedlayers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.opi.export.ObjectLayer;
import com.opi.export.Screen;
import com.opi.export.game.Level;

public class LevelObjectLayer extends ObjectLayer {

	private Screen screen;
	private Level[] levels;
	
	public LevelObjectLayer(Screen screen) {
		this.screen = screen;
	}
	
	@Override
	public void tick() {
	}

	@Override
	public void draw(SpriteBatch batch) {
	}
}
