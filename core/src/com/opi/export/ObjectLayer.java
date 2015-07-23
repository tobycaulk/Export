package com.opi.export;

public abstract class ObjectLayer implements Tickable, Drawable {
	
	public ObjectLayer() {
		initialize();
	}
	
	public abstract void initialize();
	public abstract void processInput();
}
