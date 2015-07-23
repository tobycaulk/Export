package com.opi.export.game.sharedlayers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.opi.export.AssetsHandler;
import com.opi.export.ObjectLayer;
import com.opi.export.game.Level;
import com.opi.export.game.Player;
import com.opi.export.game.Tile;

public class MobObjectLayer extends ObjectLayer {

	private Player player;

	@Override
	public void initialize() {
		Level level = AssetsHandler.getLevel(AssetsHandler.getSave().levelID);
		Vector2 enterTile = AssetsHandler.getLevel(AssetsHandler.getSave().levelID).getEnterPosition();
		player = new Player(level, level.getX() + (enterTile.x * Tile.SIZE), level.getY() + (enterTile.y * Tile.SIZE));
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void draw(SpriteBatch batch) {
		player.draw(batch);
	}

	@Override
	public void processInput() {
	}
}
