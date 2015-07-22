package com.opi.export;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet {
	
	public static HashMap<String, SpriteTexture> load(FileHandle path) {
		LinkedHashMap<String, String> sheetProperties = FileParser.load(path);
		Texture sheet = new Texture(Gdx.files.internal(sheetProperties.get("sheet")));
		int textureSize = Integer.parseInt(sheetProperties.get("size"));
		
		TextureRegion[][] regions = TextureRegion.split(sheet, textureSize, textureSize);
		HashMap<String, SpriteTexture> textures = new HashMap<String, SpriteTexture>();
		SpriteSheetData ssc = new SpriteSheetData(sheetProperties);
		
		for(String key : ssc.data.keySet()) {
			String[] data = ssc.data.get(key).split(":");
			int ID = (Integer.parseInt(data[1]) * textureSize) + (Integer.parseInt(data[0])) + 1;
			textures.put(key, new SpriteTexture(ID, regions[Integer.parseInt(data[0])][Integer.parseInt(data[1])]));
		}
		
		return textures;
	}
	
	private static class SpriteSheetData {
		int header_size = 2;
		
		public LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
		
		public SpriteSheetData(HashMap<String, String> properties) {
			initialize(properties);
		}
		
		private void initialize(HashMap<String, String> properties) {
			int index = 0;
			for(String key : properties.keySet()) {
				if(index++ >= header_size) {
					data.put(key, properties.get(key));
				}
			}
		}
	}
}
