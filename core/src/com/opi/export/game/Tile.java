package com.opi.export.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.opi.export.GameSprite;
import com.opi.export.Tickable;

public abstract class Tile extends GameSprite implements Tickable {

	public static final Texture TEST = new Texture(Gdx.files.internal("testTile.png"));
	
	public static final int OG_SIZE = 100;
	
	public static float SIZE = OG_SIZE;
	
	protected Level level;
	
	public Tile(Level level, TextureRegion texture) {
		super(texture);
		
		this.level = level;
		
		setSize(SIZE, SIZE);
	}

	public void draw(SpriteBatch batch, float x, float y) {
		setPosition(x, y);
		
		super.draw(batch);
	}
	
	public void setPosition(float x, float y) {
		setX(x);
		setY(y);
	}
}
