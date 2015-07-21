package com.opi.export;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet {
	
	public static HashMap<String, TextureRegion> load(FileHandle path) {
		LinkedHashMap<String, String> sheetProperties = FileParser.load(path);
		Texture sheet = new Texture(Gdx.files.internal(sheetProperties.get("sheet")));
		int textureSize = Integer.parseInt(sheetProperties.get("size"));
		
		TextureRegion[][] regions = TextureRegion.split(sheet, textureSize, textureSize);
		HashMap<String, TextureRegion> textures = new HashMap<String, TextureRegion>();
		SpriteSheetCoordinates ssc = new SpriteSheetCoordinates(sheetProperties);
		
		for(String key : ssc.coordinates.keySet()) {
			String[] coords = ssc.coordinates.get(key).split(":");
			textures.put(key, regions[Integer.parseInt(coords[0])][Integer.parseInt(coords[1])]);
		}
		
		return textures;
	}
	
	private static class SpriteSheetCoordinates {
		int header_size = 2;
		
		public LinkedHashMap<String, String> coordinates = new LinkedHashMap<String, String>();
		
		public SpriteSheetCoordinates(HashMap<String, String> properties) {
			initialize(properties);
		}
		
		private void initialize(HashMap<String, String> properties) {
			int index = 0;
			for(String key : properties.keySet()) {
				if(index++ >= header_size) {
					coordinates.put(key, properties.get(key));
				}
			}
		}
	}
}
