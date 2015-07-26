package com.opi.export.game;

import com.badlogic.gdx.math.Vector2;

public interface CollidableTile {
	public Vector2 getBoundingBoxOffset();
	public Vector2 getSize();
}
