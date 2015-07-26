package com.opi.export;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;
import com.opi.export.game.Entity;
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
			Entity[][] entities = new Entity[width][height];
			int levelID = Integer.parseInt(level.get("levelID"));
			String[] enterTileLine = level.get("enterTile").split(":");
			Vector2 enterTile = new Vector2(Integer.parseInt(enterTileLine[0]), Integer.parseInt(enterTileLine[1]));
			String tileLine = level.get("tiles");
			String entityLine = level.get("entities");
			
			tiles = parseTileLine(tileLine, tiles);
			entities = parseEntityLine(entityLine, entities);
			
			levels.add(new Level(tiles, entities, levelID, enterTile));
		}
		
		return levels.toArray(new Level[levels.size()]);
	}
	
	public static Level[] load(FileHandle path, String levelPack) {
		HashMap<String, String> levelProperties = FileParser.load(path);
		
		return load(Gdx.files.internal(levelProperties.get(levelPack)));
	}
	
	private static Entity[][] parseEntityLine(String entityLine, Entity[][] entities) {
		List<String> entityIDs = new ArrayList<String>();
		entityIDs = stringToList(entityLine, entityIDs);
		entities = entitiesToArray(entityIDs, entities);
		entities = (Entity[][]) flipArray(entities);
		
		return entities;
	}
	
	private static Tile[][] parseTileLine(String levelLine, Tile[][] tiles) {
		List<String> tileIDs = new ArrayList<String>();
		tileIDs = stringToList(levelLine, tileIDs);
		tiles = tilesToArray(tileIDs, tiles);
		tiles = (Tile[][]) flipArray(tiles);
		
		return tiles;
	}
	
	private static Object[][] flipArray(Object[][] objs) {
		for(int i = 0; i < objs.length; i++) {
			for(int j = 0; j < objs[0].length / 2; j++) {
				Object tmp = objs[i][j];
				objs[i][j] = objs[i][objs[i].length - 1 - j];
				objs[i][objs[i].length - 1 - j] = tmp;
			}
		}
		
		return objs;
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
	
	private static Entity[][] entitiesToArray(List<String> entityIDs, Entity[][] entities) {
		int x, y;
		x = y = 0;
		for(int i = 0; i < entityIDs.size(); i++) {
			int tileID = Integer.parseInt(entityIDs.get(i));
			entities[x][y] = Entity.getEntity(tileID);
			
			if((i + 1) % entities.length == 0) {
				y++;
				x = 0;
			} else {
				x++;
			}
		}
		
		return entities;
	}
	
	private static List<String> stringToList(String line, List<String> IDs) {
		for(int i = 0; i < line.length(); i += 4) {
			IDs.add(line.substring(i, Math.min(line.length(), i + 4)));
		}
		
		return IDs;
	}
}
