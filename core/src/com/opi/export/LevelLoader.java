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
			int width = Integer.parseInt(level.get("width"));
			int height = Integer.parseInt(level.get("height"));
			Tile[][] tiles = new Tile[width][height];
			Tile[][] uTiles = new Tile[width][height];
			Tile[][] aTiles = new Tile[width][height];
			int levelID = Integer.parseInt(level.get("levelID"));
			String[] enterTileLine = level.get("enterTile").split(":");
			Vector2 enterTile = new Vector2(Integer.parseInt(enterTileLine[0]), Integer.parseInt(enterTileLine[1]));
			String tileLine = level.get("tiles");
			String uTileLine = level.get("utiles");
			String aTileLine = level.get("atiles");
			
			tiles = parseTileLine(tileLine, tiles);
			uTiles = parseTileLine(uTileLine, uTiles);
			aTiles = parseTileLine(aTileLine, aTiles);
			
			levels.add(new Level(tiles, uTiles, aTiles, levelID, enterTile));
		}
		
		return levels.toArray(new Level[levels.size()]);
	}
	
	public static Level[] load(FileHandle path, String levelPack) {
		HashMap<String, String> levelProperties = FileParser.load(path);
		
		return load(Gdx.files.internal(levelProperties.get(levelPack)));
	}
	
	private static Tile[][] parseTileLine(String levelLine, Tile[][] tiles) {
		List<String> tileIDs = new ArrayList<String>();
		tileIDs = stringToTileList(levelLine, tileIDs);
		tiles = tilesToArray(tileIDs, tiles);
		tiles = flipTiles(tiles);
		
		return tiles;
	}
	
	private static Tile[][] flipTiles(Tile[][] tiles) {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length / 2; j++) {
				Tile tmp = tiles[i][j];
				tiles[i][j] = tiles[i][tiles[i].length - 1 - j];
				tiles[i][tiles[i].length - 1 - j] = tmp;
			}
		}
		
		return tiles;
	}
	
	private static Tile[][] tilesToArray(List<String> tileIDs, Tile[][] tiles) {
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
		
		return tiles;
	}
	
	private static List<String> stringToTileList(String levelLine, List<String> tileIDs) {
		for(int i = 0; i < levelLine.length(); i += 4) {
			tileIDs.add(levelLine.substring(i, Math.min(levelLine.length(), i + 4)));
		}
		
		return tileIDs;
	}
}
