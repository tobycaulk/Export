package com.opi.export;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteTexture {
	
	public String key;
	public TextureRegion texture;
	
	public SpriteTexture(String key, TextureRegion texture) {
		this.key = key;
		this.texture = texture;
	}
}
