package com.opi.export.game.tiles;

import com.opi.export.AssetsHandler;
import com.opi.export.game.Tile;

public class TileGrassTop extends Tile {

	public TileGrassTop() {
		super(AssetsHandler.getSpriteTexture("grassMiddleTopSpace"));
	}
	
	public boolean canCollide() {
		return true;
	}
}
