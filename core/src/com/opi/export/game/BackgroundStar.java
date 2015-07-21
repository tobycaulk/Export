package com.opi.export.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.opi.export.Export;
import com.opi.export.GameSprite;
import com.opi.export.Tickable;

public class BackgroundStar extends GameSprite implements Tickable {

	private static final int MAX_SIZE = 5;
	private static final int MAX_VEL = 50;
	
	private static Random random = new Random();
	
	private Level level;
	private Vector2 velocity;
	private boolean remove;
	
	public BackgroundStar(Level level) {
		super(getStarTexture(random.nextInt(MAX_SIZE) + 1));
		this.level = level;

		setSize(getTexture().getWidth(), getTexture().getHeight());
		setX(random.nextInt(Export.WIDTH));
		setY(Export.HEIGHT);
		
		velocity = new Vector2(0, random.nextInt((int) getWidth() * MAX_VEL) - ((int) getWidth() * MAX_VEL));
	}
	
	private static Texture getStarTexture(int size) {
		Pixmap pix = new Pixmap(size, size, Format.RGB888);
		pix.setColor(Color.WHITE);
		pix.fill();
		Texture starTexture = new Texture(pix);
		pix.dispose();
		
		return starTexture;
	}
	
	public void draw(SpriteBatch batch) {
		super.draw(batch);
	}
	
	@Override
	public void tick() {
		setY(getY() + velocity.y * Gdx.graphics.getDeltaTime());
		
		if(getY() + getHeight() <= 0) {
			remove = true;
		}
	}
	
	public boolean shouldRemove() {
		return remove;
	}
	
	public Level getLevel() {
		return level;
	}
}
