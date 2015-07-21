package com.opi.export.game.assethandlers;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.opi.export.AssetsHandler;
import com.opi.export.FileParser;
import com.opi.export.SpriteSheet;

public class GameAssetHandler implements AssetsHandler {

	private HashMap<String, TextureRegion> textures;
	
	@Override
	public void load(String packPath) {
		HashMap<String, String> properties = FileParser.load(Gdx.files.internal(packPath));
		
		textures = SpriteSheet.load(Gdx.files.internal(properties.get("textures")));
	}
	
	public TextureRegion getTexture(String key) {
		if(!textures.containsKey(key)) {
			return null;
		}
		
		return textures.get(key);
	}
}
