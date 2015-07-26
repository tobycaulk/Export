package com.opi.export.game;

import com.badlogic.gdx.math.Vector2;
import com.opi.export.AssetsHandler;
import com.opi.export.Mob;

public class Player extends Mob {
	
	public static final int WIDTH = 128;
	public static final int HEIGHT = 128;

	public Player(Level level, float x, float y, int tx, int ty) {
		super(AssetsHandler.getSpriteTexture("player").texture, level, x, y, WIDTH, HEIGHT, tx, ty);
	}
	
	public Player(Level level, Vector2 position, int tx, int ty) {
		super(AssetsHandler.getSpriteTexture("player").texture, level, position, WIDTH, HEIGHT, tx, ty);
	}
}
