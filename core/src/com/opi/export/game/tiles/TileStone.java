package com.opi.export.game.tiles;

import com.opi.export.AssetsHandler;
import com.opi.export.game.Tile;

public class TileStone extends Tile {

	public TileStone() {
		super(AssetsHandler.getSpriteTexture("stone"));
	}
}
