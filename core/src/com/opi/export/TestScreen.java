package com.opi.export;

import com.opi.export.game.sharedlayers.BackgroundStarLayer;
import com.opi.export.game.sharedlayers.LevelObjectLayer;

public class TestScreen extends Screen {

	public TestScreen(Export game) {
		super(game, "game_assets.pack");
	}
	
	@Override
	public void initialize() {
		addLayer(new BackgroundStarLayer());
		addLayer(new LevelObjectLayer());

		super.initialize();
	}

	@Override
	public void resize() {
	}
}
