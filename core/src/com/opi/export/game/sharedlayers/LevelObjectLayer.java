package com.opi.export.game.sharedlayers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.opi.export.AssetsHandler;
import com.opi.export.Export;
import com.opi.export.InputProxy;
import com.opi.export.MasterDrawer;
import com.opi.export.ObjectLayer;
import com.opi.export.game.Level;
import com.opi.export.game.Player;

public class LevelObjectLayer extends ObjectLayer {

	private static final float defaultLevelPosition = (Export.HEIGHT / 4);
	
	private Level[] levels;
	private Player player;
	
	@Override
	public void initialize() {
		this.levels = AssetsHandler.getLevels();

		for(int i = 0; i < levels.length; i++) {
			Level l = levels[i];
			if((i - 1) < 0) {
				l.setPosition(l.getCenteredPosition().x, l.getCenteredPosition().y/*defaultLevelPosition*/);
			} else {
				Level lastLevel = levels[i - 1];
				l.setPosition(l.getCenteredPosition().x, (lastLevel.getY() + lastLevel.getLevelHeight()) + Level.DISTANCE_BETWEEN_LEVELS);
			}
			l.initialize();
		}
		
		Level level = AssetsHandler.getLevel(AssetsHandler.getSave().levelID);
		Vector2 enterTile = AssetsHandler.getLevel(AssetsHandler.getSave().levelID).getEnterPosition();
		player = new Player(level, level.getTilePosition((int) enterTile.x, (int) enterTile.y), (int) enterTile.x, (int) enterTile.y);
	}
	
	@Override
	public void tick() {
		for(int i = 0; i < levels.length; i++) {
			levels[i].tick();
		}
		
		player.tick();
	}

	@Override
	public void draw(SpriteBatch batch) {
		for(int i = 0; i < levels.length; i++) {
			levels[i].draw(batch);
		}
		
		MasterDrawer.add(player);
	}

	@Override
	public boolean processInput(int event) {
		switch(event) {
		case InputProxy.PRESS_W:
			if(!player.isMoving()) {
				player.moveToTile((int) player.getTilePosition().x, (int) player.getTilePosition().y + 1);
			}
			return true;
		case InputProxy.PRESS_A:
			if(!player.isMoving()) {
				player.moveToTile((int) player.getTilePosition().x - 1, (int) player.getTilePosition().y);
			}
			return true;
		case InputProxy.PRESS_S:
			if(!player.isMoving()) {
				player.moveToTile((int) player.getTilePosition().x, (int) player.getTilePosition().y - 1);
			}
			return true;
		case InputProxy.PRESS_D:
			if(!player.isMoving()) {
				player.moveToTile((int) player.getTilePosition().x + 1, (int) player.getTilePosition().y);
			}
			return true;
		}
		return false;
	}
}
