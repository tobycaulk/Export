package com.opi.export;

import java.util.ArrayList;
import java.util.List;

public abstract class ObjectLayer implements Tickable, Drawable {

	protected List<GameSprite> sprites;
	
	public ObjectLayer() {
		this.sprites = new ArrayList<GameSprite>();
	}

	protected void addSprite(GameSprite sprite) {
		sprites.add(sprite);
	}
	
	protected void removeSprite(GameSprite sprite) {
		sprites.remove(sprite);
	}
}
