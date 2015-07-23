package com.opi.export.game.sharedlayers;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.opi.export.GameSprite;
import com.opi.export.ObjectLayer;
import com.opi.export.game.BackgroundStar;

public class BackgroundStarLayer extends ObjectLayer {

	public static final int MAX_STARS = 100;
	
	private List<GameSprite> sprites = new ArrayList<GameSprite>();
	
	@Override
	public void initialize() {
	}
	
	@Override
	public void tick() {
		if(sprites.size() <= MAX_STARS) {
			sprites.add(new BackgroundStar());
		}
		
		for(int i = sprites.size() - 1; i >= 0; i--) {
			GameSprite sprite = sprites.get(i);
			
			sprite.tick();
			
			if(sprite.shouldRemove()) {
				sprites.remove(sprite);
			}
		}
	}

	@Override
	public void draw(SpriteBatch batch) {
		for(int i = 0; i < sprites.size(); i++) {
			sprites.get(i).draw(batch);
		}
	}

	@Override
	public void processInput() {
	}
}
