package com.opi.export;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameSprite extends Sprite implements Tickable {

	protected boolean remove;

	public GameSprite(Texture texture) {
		super(texture);
	}
	
	public GameSprite(TextureRegion texture) {
		super(texture);
	}
	
	public void addPosition(float mx, float my) {
		setPosition(getX() + mx, getY() + my);
	}
	
	@Override
	public void tick() {
	}
	
	public void draw(SpriteBatch batch, float x, float y) {
		setPosition(x, y);
		
		super.draw(batch);
	}
	
	public void setPosition(float x, float y) {
		setX(x);
		setY(y);
	}
	
	public boolean shouldRemove() {
		return remove;
	}
}
