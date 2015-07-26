package com.opi.export.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.opi.export.GameSprite;

public abstract class Item extends GameSprite {

	public Item(TextureRegion texture, int width, int height) {
		super(texture);
		
		setSize(width, height);
	}
}
