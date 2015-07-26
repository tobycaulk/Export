package com.opi.export.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.opi.export.GameSprite;
import com.opi.export.SpriteTexture;
import com.opi.export.game.entities.Fence;
import com.opi.export.game.entities.Space;

public class Entity extends GameSprite {
	
	private static final List<Entity> ENTITY_LIST = new ArrayList<Entity>();
	
	private int textureID;

	public Entity(SpriteTexture spriteTexture) {
		super(spriteTexture.texture);
		
		this.textureID = spriteTexture.ID;
	}
	
	public Entity(TextureRegion texture, float x, float y, float width, float height) {
		super(texture);
		
		setPosition(x, y);
		setSize(width, height);
	}

	public static void initialize() {
		ENTITY_LIST.add(new Fence());
		ENTITY_LIST.add(new Space());
	}
	
	public static Entity getEntity(int textureID) {
		for(Entity e : ENTITY_LIST) {
			if(textureID == e.textureID) {
				try {
					return e.getClass().newInstance();
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	@Override
	public int compareTo(GameSprite s) {
		return getZIndex() == s.getZIndex() ? 0 : getZIndex() > s.getZIndex() ? -1 : 1;
	}

	@Override
	public float getZIndex() {
		return getY();
	}
}
