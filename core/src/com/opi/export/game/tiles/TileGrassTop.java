package com.opi.export.game.tiles;

import com.badlogic.gdx.math.Vector2;
import com.opi.export.AssetsHandler;
import com.opi.export.game.Tile;

public class TileGrassTop extends Tile {

	public TileGrassTop() {
		super(AssetsHandler.getSpriteTexture("grassMiddleTopSpace"));
	}
	
	public Vector2 getCollisionOffset() {
		return new Vector2(0, 10);
	}
	
	public boolean canCollide() {
		return true;
	}
}
