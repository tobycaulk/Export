package com.opi.export.game.tiles;

import com.opi.export.AssetsHandler;
import com.opi.export.game.Level;
import com.opi.export.game.Tile;

public class TileGrass extends Tile {

	public TileGrass(Level level) {
		super(level, AssetsHandler.getTexture("grass"));
	}

	@Override
	public void tick() {
	}
}
