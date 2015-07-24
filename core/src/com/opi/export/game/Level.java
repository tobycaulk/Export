package com.opi.export.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.opi.export.Drawable;
import com.opi.export.Export;
import com.opi.export.Tickable;

public class Level implements Drawable, Tickable {
	
	public static final int DISTANCE_BETWEEN_LEVELS = (int) Tile.SIZE * 2;
	
	private Tile[][] tiles;
	private Tile[][] uTiles;
	private Tile[][] aTiles;
	private float mx;
	private float my;
	private int levelID;
	private Vector2 enter;
	
	public Level(Tile[][] tiles, Tile[][] uTiles, Tile[][] aTiles, int levelID, Vector2 enter) {
		this.tiles = tiles;
		this.uTiles = uTiles;
		this.aTiles = aTiles;
		this.levelID = levelID;
		this.enter = enter;
		
		initialize();
	}
	
	private void initialize() {
	}
	
	@Override
	public void tick() {
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				tiles[x][y].tick();
			}
		}
		
		for(int x = 0; x < uTiles.length; x++) {
			for(int y = 0; y < uTiles[0].length; y++) {
				uTiles[x][y].tick();
			}
		}
		
		for(int x = 0; x < uTiles.length; x++) {
			for(int y = 0; y < uTiles[0].length; y++) {
				aTiles[x][y].tick();
			}
		}
	}

	public void draw(SpriteBatch batch) {
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				tiles[x][y].draw(batch, mx + (x * Tile.SIZE), my + (y * Tile.SIZE));
			}
		}
	}
	
	public void drawUnderTiles(SpriteBatch batch) {
		for(int x = 0; x < uTiles.length; x++) {
			for(int y = 0; y < uTiles[0].length; y++) {
				uTiles[x][y].draw(batch, mx + (x * uTiles[x][y].getWidth()), my + (y * uTiles[x][y].getHeight()));
			}
		}
	}
	
	public void drawAboveTiles(SpriteBatch batch) {
		for(int x = 0; x < uTiles.length; x++) {
			for(int y = 0; y < uTiles[0].length; y++) {
				aTiles[x][y].draw(batch, mx + (x * aTiles[x][y].getWidth()), my + (y * aTiles[x][y].getHeight()));
			}
		}
	}

	public void setPosition(float mx, float my) {
		this.mx = mx;
		this.my = my;
	}

	public Tile getTile(int tx, int ty) {
		return tiles[tx][ty];
	}
	
	public Tile getUnderTile(int tx, int ty) {
		return uTiles[tx][ty];
	}
	
	public Tile getAboveTile(int tx, int ty) {
		return aTiles[tx][ty];
	}
	
	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
	
	public int getLevelWidth() {
		return tiles.length;
	}
	
	public int getLevelHeight() {
		return tiles[0].length;
	}
	
	public float getX() {
		return mx;
	}
	
	public float getY() {
		return my;
	}
	
	public int getLevelID() {
		return levelID;
	}
	
	public Vector2 getTilePosition(int tx, int ty) {
		return new Vector2(getX() + (tx * Tile.SIZE), getY() + (ty * Tile.SIZE));
	}
	
	public Vector2 getEnterPosition() {
		return enter;
	}
	
	public Vector2 getCenteredPosition() {
		float x = (Export.WIDTH / 2) - ((getLevelWidth() * Tile.SIZE) / 2);
		float y = (Export.HEIGHT / 2) - ((getLevelHeight() * Tile.SIZE) / 2);
		
		return new Vector2(x, y);
	}
}
