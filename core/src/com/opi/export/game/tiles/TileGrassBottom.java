package com.opi.export.game.tiles;

import com.badlogic.gdx.math.Vector2;
import com.opi.export.AssetsHandler;
import com.opi.export.game.Tile;

public class TileGrassBottom extends Tile {

	public TileGrassBottom() {
		super(AssetsHandler.getSpriteTexture("grassMiddleBottomSpace"));
	}
	
	public Vector2 getCollisionOffset() {
		return new Vector2(0, 20);
	}
	
	public boolean canCollide() {
		return true;
	}
}
