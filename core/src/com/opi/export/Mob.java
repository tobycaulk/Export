package com.opi.export;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.opi.export.game.Level;

public abstract class Mob extends GameSprite implements Drawable, Tickable {

	private Level level;
	
	public Mob(TextureRegion texture, Level level, float x, float y, int width, int height) {
		super(texture);
		
		this.level = level;
		
		setSize(width, height);
		setPosition(x, y);
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		super.draw(batch);
	}
	
	public Level getLevel() {
		return level;
	}
}
