package com.opi.export.game;

import java.util.ArrayList;
import java.util.List;

import com.opi.export.GameSprite;
import com.opi.export.SpriteTexture;
import com.opi.export.Tickable;
import com.opi.export.game.tiles.TileDirt;
import com.opi.export.game.tiles.TileDirtAlt;
import com.opi.export.game.tiles.TileGrass;
import com.opi.export.game.tiles.TileGrassAlt;
import com.opi.export.game.tiles.TileGrassBottom;
import com.opi.export.game.tiles.TileGrassLeft;
import com.opi.export.game.tiles.TileGrassRight;
import com.opi.export.game.tiles.TileGrassTop;
import com.opi.export.game.tiles.TileSpace;
import com.opi.export.game.tiles.TileStone;
import com.opi.export.game.tiles.TileStoneAlt;

public abstract class Tile extends GameSprite implements Tickable {
	
	public static final int OG_SIZE = 100;

	private static final List<Tile> TILE_LIST = new ArrayList<Tile>();
	
	public static float SIZE = OG_SIZE;
	
	private int textureID;
	
	public Tile(SpriteTexture spriteTexture) {
		super(spriteTexture.texture);
		
		this.textureID = spriteTexture.ID;
		
		setSize(SIZE, SIZE);
	}
	
	public int getTexureID() {
		return textureID;
	}
	
	public static void initialize() {
		TILE_LIST.add(new TileGrass());
		TILE_LIST.add(new TileGrassAlt());
		TILE_LIST.add(new TileDirt());
		TILE_LIST.add(new TileDirtAlt());
		TILE_LIST.add(new TileGrassBottom());
		TILE_LIST.add(new TileGrassTop());
		TILE_LIST.add(new TileGrassLeft());
		TILE_LIST.add(new TileGrassRight());
		TILE_LIST.add(new TileStone());
		TILE_LIST.add(new TileStoneAlt());
		TILE_LIST.add(new TileSpace());
	}
	
	public static Tile getTile(int textureID) {
		for(Tile t : TILE_LIST) {
			if(textureID == t.textureID) {
				return t;
			}
		}
		
		return null;
	}
}
