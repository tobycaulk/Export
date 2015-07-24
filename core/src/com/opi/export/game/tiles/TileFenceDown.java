package com.opi.export.game.tiles;

import com.badlogic.gdx.math.Vector2;
import com.opi.export.AssetsHandler;
import com.opi.export.game.Tile;

public class TileFenceDown extends Tile {

	public TileFenceDown() {
		super(AssetsHandler.getSpriteTexture("fenceDown"));
	}

	@Override
	public Vector2 getCollisionOffset() {
		return new Vector2(0, -20);
	}
	
	public boolean canCollide() {
		return true;
	}
}
