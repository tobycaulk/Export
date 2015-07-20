package com.opi.export;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.opi.export.game.Level;
import com.opi.export.game.Tile;
import com.opi.export.game.tiles.TileTest;

public class GameScreen extends Screen {

	private List<Level> levels;
	private int currentLevel;
	
	public GameScreen(Export game) {
		super(game);
	}
	
	@Override
	public void initialize() {
		levels = new ArrayList<Level>();
		
		Level level = new Level(this);
		
		Tile[][] tiles = new Tile[8][5];
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				tiles[x][y] = new TileTest(level);
			}
		}

		level.setTiles(tiles);
		levels.add(level);
	}

	@Override
	public void draw(SpriteBatch batch) {
		for(int i = 0; i < levels.size(); i++) {
			Level l = levels.get(i);

			l.draw(batch);
		}
	}

	@Override
	public void tick() {
		for(int i = 0; i < levels.size(); i++) {
			levels.get(i).tick();
		}
	}

	@Override
	public void resize() {
	}
}
