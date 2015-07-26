package com.opi.export.game.entities;

import com.opi.export.AssetsHandler;
import com.opi.export.game.Entity;

public class Space extends Entity {

	public Space() {
		super(AssetsHandler.getSpriteTexture("space"));
	}
}
