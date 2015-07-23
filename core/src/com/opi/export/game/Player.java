package com.opi.export.game;

import com.opi.export.AssetsHandler;
import com.opi.export.Mob;

public class Player extends Mob {
	
	public static final int WIDTH = 80;
	public static final int HEIGHT = 128;

	public Player(Level level, float x, float y) {
		super(AssetsHandler.getSpriteTexture("player").texture, level, x, y, WIDTH, HEIGHT);
	}
}
