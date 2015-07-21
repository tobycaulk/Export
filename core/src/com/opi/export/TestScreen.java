package com.opi.export;

import java.util.ArrayList;
import java.util.List;

import com.opi.export.game.Level;
import com.opi.export.game.Tile;
import com.opi.export.game.assethandlers.GameAssetHandler;
import com.opi.export.game.sharedlayers.BackgroundStarLayer;
import com.opi.export.game.tiles.TileGrass;

public class TestScreen extends Screen {

	private List<Level> levels;
	
	public TestScreen(Export game) {
		super(game, "game_assets.pack");
	}
	
	@Override
	public void initialize() {
		assetsHandler = new GameAssetHandler();
		assetsHandler.load(packPath);
		
		addLayer(new BackgroundStarLayer());
		
		levels = new ArrayList<Level>();
		
		Level level = new Level(this);
		
		Tile[][] tiles = new Tile[8][5];
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				tiles[x][y] = new TileGrass(level);
			}
		}

		level.setTiles(tiles);
		level.setPosition(level.getCenteredPosition().x, level.getCenteredPosition().y);
		levels.add(level);
	}

	@Override
	public void resize() {
	}
}
