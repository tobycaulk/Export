package com.opi.export.game.tiles;

import com.opi.export.AssetsHandler;
import com.opi.export.game.Tile;

public class TileGrassBottom extends Tile {

	public TileGrassBottom() {
		super(AssetsHandler.getSpriteTexture("grassMiddleBottomSpace"));
	}
	
	public boolean canCollide() {
		return true;
	}
}
