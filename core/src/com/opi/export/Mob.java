package com.opi.export;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.equations.Linear;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.opi.export.game.Level;
import com.opi.export.game.Tile;

public abstract class Mob extends GameSprite implements Drawable, Tickable {

	private Level level;
	private Vector2 moveToPosition;
	private Vector2 moveToTilePosition;
	private Vector2 tilePosition;
	private boolean moving;
	private boolean canMoveUp, canMoveDown, canMoveLeft, canMoveRight;
	
	public Mob(TextureRegion texture, Level level, float x, float y, int width, int height, int tx, int ty) {
		this(texture, level, new Vector2(x, y), width, height, tx, ty);
	}
	
	public Mob(TextureRegion texture, Level level, Vector2 position, int width, int height, int tx, int ty) {
		super(texture);
		
		this.level = level;
		this.tilePosition = new Vector2(tx, ty);
		this.moveToPosition = new Vector2();
		this.moveToTilePosition = new Vector2();
		this.canMoveUp = canMoveDown = canMoveLeft = canMoveRight = true;
		
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
		
		Tile t = level.getTile(tx, ty);
		Vector2 nextMoveToPosition = level.getTilePosition(tx, ty);
		int diffX = (int) ((int) tx - moveToTilePosition.x);
		int diffY = (int) ((int) ty - moveToTilePosition.y);

		if(t.canCollide()) {
			
			if(diffX > 0) {
				canMoveRight = false;
				canMoveLeft = true;
			} else if(diffX < 0) {
				canMoveLeft = false;
				canMoveRight = true;
			}
			
			if(diffY > 0) {
				canMoveUp = false;
				canMoveDown = true;
			} else if(diffY < 0) {
				canMoveDown = false;
				canMoveUp = true;
			}
		
			nextMoveToPosition.add(t.getCollisionOffset());
			setMoveToPosition(tx, ty, nextMoveToPosition.x, nextMoveToPosition.y);
		} else {
			if(diffX > 0 && canMoveRight) {
				setMoveToPosition(tx, ty, nextMoveToPosition.x, nextMoveToPosition.y);
				canMoveLeft = true;
			}
			
			if(diffX < 0 && canMoveLeft) {
				setMoveToPosition(tx, ty, nextMoveToPosition.x, nextMoveToPosition.y);
				canMoveRight = true;
			}
			
			if(diffY > 0 && canMoveUp) {
				setMoveToPosition(tx, ty, nextMoveToPosition.x, nextMoveToPosition.y);
				canMoveDown = true;
			}
			
			if(diffY < 0 && canMoveDown) {
				setMoveToPosition(tx, ty, nextMoveToPosition.x, nextMoveToPosition.y);
				canMoveUp = true;
			}
		}

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
}
