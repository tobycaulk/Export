package com.opi.export.game.tiles;

import com.badlogic.gdx.math.Vector2;
import com.opi.export.AssetsHandler;
import com.opi.export.game.Tile;

public class TileFenceUp extends Tile {

	public TileFenceUp() {
		super(AssetsHandler.getSpriteTexture("fenceUp"));
	}
	
	@Override
	public Vector2 getCollisionOffset() {
		return new Vector2(0, 20);
	}
	
	@Override
	public boolean canCollide() {
		return true;
	}
}
