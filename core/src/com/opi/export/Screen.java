package com.opi.export;

public abstract class Screen implements Drawable, Tickable {
	
	protected Export game;
	
	public Screen(Export game) {
		this.game = game;
		
		initialize();
	}
	
	public abstract void initialize();
	public abstract void resize();
	
	public Export getGame() {
		return game;
	}
}
