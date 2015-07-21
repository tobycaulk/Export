package com.opi.export.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.opi.export.Drawable;
import com.opi.export.Export;
import com.opi.export.Screen;
import com.opi.export.Tickable;

public class Level implements Drawable, Tickable {
	
	public static final int DISTANCE_BETWEEN_LEVELS = (int) Tile.SIZE * 2;
	
	private static final int MAX_STARS = 100;

	private Screen screen;
	private Tile[][] tiles;
	private List<BackgroundStar> backgroundStars;
	private float mx;
	private float my;
	
	public Level(Screen screen) {
		this.screen = screen;
		
		initialize();
	}
	
	private void initialize() {
		backgroundStars = new ArrayList<BackgroundStar>();
	}
	
	@Override
	public void tick() {
		if(backgroundStars.size() <= MAX_STARS) {
			backgroundStars.add(new BackgroundStar(this));
		}
		
		for(int i = backgroundStars.size() - 1; i >= 0; i--) {
			BackgroundStar star = backgroundStars.get(i);
			
			star.tick();

			if(star.shouldRemove()) {
				backgroundStars.remove(star);
			}
		}
		
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				tiles[x][y].tick();
			}
		}
	}

	public void draw(SpriteBatch batch) {
		for(BackgroundStar star : backgroundStars) {
			star.draw(batch);
		}
		
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				//tiles[x][y].draw(batch, mx + (x * Tile.SIZE), my + (y * Tile.SIZE));
			}
		}
	}

	public void setPosition(float mx, float my) {
		this.mx = mx;
		this.my = my;
	}
	
	public Screen getScreen() {
		return screen;
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
	
	public Vector2 getCenteredPosition() {
		float x = (Export.WIDTH / 2) - ((getLevelWidth() * Tile.SIZE) / 2);
		float y = (Export.HEIGHT / 2) - ((getLevelHeight() * Tile.SIZE) / 2);
		
		return new Vector2(x, y);
	}
}
