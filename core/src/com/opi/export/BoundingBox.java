package com.opi.export;

import com.badlogic.gdx.math.Rectangle;

public class BoundingBox {
	
	public static Rectangle generate(float x, float y, float width, float height) {
		return new Rectangle(x, y, width, height);
	}
}
