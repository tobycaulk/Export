package com.opi.export.game.entities;

import com.opi.export.AssetsHandler;
import com.opi.export.game.Entity;
import com.opi.export.game.Tile;

public class Fence extends Entity {

	public Fence() {
		super(AssetsHandler.getSpriteTexture("fence"));
		
		setSize(Tile.SIZE, Tile.SIZE);
	}
}
