package com.opi.export;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.opi.export.game.Level;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.equations.Linear;

public abstract class Mob extends GameSprite implements Drawable, Tickable {

	private Level level;
	private Vector2 moveToPosition;
	private Vector2 moveToTilePosition;
	private Vector2 tilePosition;
	private boolean moving;
	
	public Mob(TextureRegion texture, Level level, float x, float y, int width, int height, int tx, int ty) {
		this(texture, level, new Vector2(x, y), width, height, tx, ty);
	}
	
	public Mob(TextureRegion texture, Level level, Vector2 position, int width, int height, int tx, int ty) {
		super(texture);
		
		this.level = level;
		this.tilePosition = new Vector2(tx, ty);
		this.moveToPosition = new Vector2();
		this.moveToTilePosition = new Vector2();
		
		setSize(width, height);
		setPosition(position.x, position.y);
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		super.draw(batch);
	}
	
	public void tweenToMovePosition() {
		Tween.to(this, MobAccessor.POSITION_XY, 0.25f)
			.target(moveToPosition.x, moveToPosition.y)
			.ease(Linear.INOUT)
			.setCallbackTriggers(TweenCallback.BEGIN | TweenCallback.COMPLETE)
			.setCallback(new TweenCallback() {

				@Override
				public void onEvent(int eventType, BaseTween<?> source) {
					switch(eventType) {
					case TweenCallback.BEGIN:
						moving = true;
						break;
					case TweenCallback.COMPLETE:
						moving = false;
						tilePosition.set(moveToTilePosition);
						break;
					}
				}
			}).start(TweenHandler.tweenManager);
	}
	
	public Vector2 getMoveToPosition() {
		return moveToPosition;
	}
	
	public void setMoveToPosition(int tx, int ty, float x, float y) {
		moveToTilePosition.set(tx, ty);
		moveToPosition.set(x, y);
	}
	
	public void moveToTile(int tx, int ty) {
		if(tx < 0 || ty < 0 || tx >= level.getLevelWidth() || ty >= level.getLevelHeight()) {
			return;
		}
		
		Vector2 nextMoveToPosition = level.getTilePosition(tx, ty);
		setMoveToPosition(tx, ty, nextMoveToPosition.x, nextMoveToPosition.y);
		tweenToMovePosition();
	}
	
	public boolean isMoving() {
		return moving;
	}
	
	public Vector2 getTilePosition() {
		return tilePosition;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public float getZIndex() {
		return getY();
	}
	
	public int compareTo(GameSprite s) {
		return getZIndex() == s.getZIndex() ? 0 : getZIndex() > s.getZIndex() ? -1 : 1;
	}
}
