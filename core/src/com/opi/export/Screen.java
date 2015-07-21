package com.opi.export;

public abstract class Screen implements Drawable, Tickable {
	
	public AssetsHandler assetsHandler;
	
	protected Export game;
	
	private String packPath;
	
	public Screen(Export game, String packPath) {
		this.game = game;
		this.packPath = packPath;
		
		initialize();
	}
	
	public abstract void resize();

	public void initialize() {
		assetsHandler = new AssetsHandler();
		assetsHandler.load(packPath);
	}
	
	public Export getGame() {
		return game;
	}
}
