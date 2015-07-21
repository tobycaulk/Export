package com.opi.export;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetsHandler {
	
	private HashMap<String, TextureRegion> textures;
	
	public void load(String packPath) {
		HashMap<String, String> properties = FileParser.load(Gdx.files.internal(packPath));
		
		textures = SpriteSheet.load(Gdx.files.internal(properties.get("textures")));
	}
	
	public TextureRegion getTexture(String key) {
		return textures.get(key);
	}
}
