package com.opi.export;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteTexture {
	
	public int ID;
	public TextureRegion texture;
	
	public SpriteTexture(int ID, TextureRegion texture) {
		this.ID = ID;
		this.texture = texture;
	}
}
