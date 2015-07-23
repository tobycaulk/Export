package com.opi.export.game.sharedlayers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.opi.export.AssetsHandler;
import com.opi.export.Export;
import com.opi.export.ObjectLayer;
import com.opi.export.game.Level;

public class LevelObjectLayer extends ObjectLayer {

	private static final float defaultLevelPosition = (Export.HEIGHT / 4);
	
	private Level[] levels;
	
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
		}
	}
	
	@Override
	public void tick() {
		for(int i = 0; i < levels.length; i++) {
			levels[i].tick();
		}
	}

	@Override
	public void draw(SpriteBatch batch) {
		for(int i = 0; i < levels.length; i++) {
			levels[i].draw(batch);
		}
	}

	@Override
	public void processInput() {
	}
}
