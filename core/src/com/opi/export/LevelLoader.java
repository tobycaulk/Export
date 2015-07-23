package com.opi.export;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;
import com.opi.export.game.Level;
import com.opi.export.game.Tile;

public class LevelLoader {
	
	public static Level[] load(FileHandle treePath) {
		List<Level> levels = new ArrayList<Level>();
		HashMap<String, String> levelTree = FileParser.load(treePath);
		
		for(String key : levelTree.keySet()) {
			HashMap<String, String> level = FileParser.load(Gdx.files.internal(levelTree.get(key)));
			Tile[][] tiles = new Tile[Integer.parseInt(level.get("width"))][Integer.parseInt(level.get("height"))];
			int levelID = Integer.parseInt(level.get("levelID"));
			String[] enterTileLine = level.get("enterTile").split(":");
			Vector2 enterTile = new Vector2(Integer.parseInt(enterTileLine[0]), Integer.parseInt(enterTileLine[1]));
			String levelLine = level.get("tiles");
			List<String> tileIDs = new ArrayList<String>();
				
			for(int i = 0; i < levelLine.length(); i += 4) {
				tileIDs.add(levelLine.substring(i, Math.min(levelLine.length(), i + 4)));
			}
			
			int x, y;
			x = y = 0;
			for(int i = 0; i < tileIDs.size(); i++) {
				int tileID = Integer.parseInt(tileIDs.get(i));
				tiles[x][y] = Tile.getTile(tileID);
				
				if((i + 1) % tiles.length == 0) {
					y++;
					x = 0;
				} else {
					x++;
				}
			}
			
			for(int i = 0; i < tiles.length; i++) {
				for(int j = 0; j < tiles[0].length / 2; j++) {
					Tile tmp = tiles[i][j];
					tiles[i][j] = tiles[i][tiles[i].length - 1 - j];
					tiles[i][tiles[i].length - 1 - j] = tmp;
				}
			}
			
			levels.add(new Level(tiles, levelID, enterTile));
		}
		
		return levels.toArray(new Level[levels.size()]);
	}
	
	public static Level[] load(FileHandle path, String levelPack) {
		HashMap<String, String> levelProperties = FileParser.load(path);
		
		return load(Gdx.files.internal(levelProperties.get(levelPack)));
	}
}
