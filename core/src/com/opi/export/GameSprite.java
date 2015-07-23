package com.opi.export;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class GameSprite extends Sprite implements Tickable {

	protected boolean remove;

	public GameSprite(Texture texture) {
		super(texture);
	}
	
	public GameSprite(TextureRegion texture) {
		super(texture);
	}
	
	
	@Override
	public void tick() {
	}
	
	public void draw(SpriteBatch batch, float x, float y) {
		setPosition(x, y);
		
		super.draw(batch);
	}
	
	public void addPosition(float mx, float my) {
		setPosition(getX() + mx, getY() + my);
	}

	public void setPosition(float x, float y) {
		setX(x);
		setY(y);
	}
	
	public void setSize(float w, float h) {
		super.setSize(w, h);
	}
	
	public Vector2 getSize() {
		return new Vector2(getWidth(), getHeight());
	}
	
	public boolean shouldRemove() {
		return remove;
	}
}
