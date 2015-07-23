package com.opi.export;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.opi.export.game.Level;

public class AssetsHandler {
	
	private static HashMap<String, SpriteTexture> textures;
	private static Level[] levels;
	private static Save save;

	public static void loadSave() {
		save = Save.load();
	}
	
	public static void loadTextures(String packPath) {
		HashMap<String, String> props = FileParser.load(Gdx.files.internal(packPath));
		
		textures = SpriteSheet.load(Gdx.files.internal(props.get("textures")));
	}
	
	public static void loadLevels(String packPath) {
		HashMap<String, String> props = FileParser.load(Gdx.files.internal(packPath));
		
		levels = LevelLoader.load(Gdx.files.internal(props.get("levels")), save.level_pack);
	}
	
	public static int getTextureID(String key) {
		if(!textures.containsKey(key)) {
			return -1;
		}
		
		return textures.get(key).ID;
	}
	
	public static SpriteTexture getSpriteTexture(String key) {
		if(!textures.containsKey(key)) {
			return null;
		}
		
		return textures.get(key);
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
	
	public static Level getLevel(int levelID) {
		for(Level l : levels) {
			if(levelID == l.getLevelID()) {
				
				return l;
			}
		}
		
		return null;
	}
	
	public static Save getSave() {
		if(save == null) {
			Save.load();
		}
		
		return save;
	}
}
