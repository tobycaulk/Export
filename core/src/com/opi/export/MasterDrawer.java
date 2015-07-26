package com.opi.export;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MasterDrawer {

	public static final int MAX_SPRITES = 5000;
	
	private static List<GameSprite> sprites = new ArrayList<GameSprite>();
	
	public static void draw(SpriteBatch batch) {
		Collections.sort(sprites);
		
		for(int i = 0; i < sprites.size(); i++) {
			sprites.get(i).draw(batch);
		}

		sprites.clear();
	}
	
	public static void add(GameSprite sprite) {
		sprites.add(sprite);
	}
}
