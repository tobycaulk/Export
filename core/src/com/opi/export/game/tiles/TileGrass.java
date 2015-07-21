package com.opi.export.game.tiles;

import com.opi.export.game.Level;
import com.opi.export.game.Tile;
import com.opi.export.game.assethandlers.GameAssetHandler;

public class TileGrass extends Tile {

	public TileGrass(Level level) {
		super(level, ((GameAssetHandler) level.getScreen().assetsHandler).getTexture("grass"));
	}

	@Override
	public void tick() {
	}
}
