package com.opi.export;

import com.opi.export.game.sharedlayers.BackgroundStarLayer;

public class TestScreen extends Screen {

	public TestScreen(Export game) {
		super(game, "game_assets.pack");
	}
	
	@Override
	public void initialize() {
		addLayer(new BackgroundStarLayer());
	}

	@Override
	public void resize() {
	}
}
