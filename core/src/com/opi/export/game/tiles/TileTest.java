package com.opi.export.game.tiles;

import com.opi.export.game.Level;
import com.opi.export.game.Tile;

public class TileTest extends Tile {

	public TileTest(Level level) {
		super(level, Tile.TEST);
	}

	@Override
	public void tick() {
	}
}
