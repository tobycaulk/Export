package com.opi.export;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.opi.export.game.Level;

public class AssetsHandler {
	
	private static HashMap<String, SpriteTexture> textures;
	private static Level[] levels;
	
	public static void load(String packPath) {
		HashMap<String, String> props = FileParser.load(Gdx.files.internal(packPath));
		
		textures = SpriteSheet.load(Gdx.files.internal(props.get("textures")));
		levels = LevelLoader.load(Gdx.files.internal(props.get("levels")), Gdx.files.internal(props.get("level_pack")));
	}
	
	public static int getTextureID(String key) {
		if(!textures.containsKey(key)) {
			return -1;
		}
		
		return textures.get(key).ID;
	}
	
	public static TextureRegion getTexture(String key) {
		if(!textures.containsKey(key)) {
			return null;
		}
		
		return textures.get(key).texture;
	}
	
	public static Level[] getLevels() {
		return levels;
	}
	
	public Level getLevel(int levelID) {
		return levels[levelID];
	}
}
