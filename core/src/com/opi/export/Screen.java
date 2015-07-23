package com.opi.export;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.opi.export.game.sharedlayers.InputProxy;

public abstract class Screen implements Drawable, Tickable {
	
	public static AssetsHandler assetsHandler;
	
	protected Export game;
	protected String packPath;
	
	private List<ObjectLayer> layers;
	
	public Screen(Export game, String packPath) {
		this.game = game;
		this.packPath = packPath;
		this.layers = new ArrayList<ObjectLayer>();
		
		initialize();
	}
	
	public abstract void resize();
	
	public void initialize() {
		InputProxy.setLayers(layers);
	}
	
	public void draw(SpriteBatch batch) {
		for(ObjectLayer ol : layers) {
			ol.draw(batch);
		}
	}
	
	public void tick() {
		InputProxy.tick();
		
		for(ObjectLayer ol : layers) {
			ol.tick();
		}
	}

	protected void addLayer(ObjectLayer layer) {
		layers.add(layer);
	}
	
	protected void removeLayer(ObjectLayer layer) {
		layers.remove(layer);
	}
	
	public Export getGame() {
		return game;
	}
}
