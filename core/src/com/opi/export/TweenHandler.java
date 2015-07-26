package com.opi.export;

import com.badlogic.gdx.Gdx;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class TweenHandler {
	
	static {
		Tween.registerAccessor(Mob.class, new MobAccessor());
	}

	public static TweenManager tweenManager;
	
	public static void initialize() {
		tweenManager = new TweenManager();
	}
	
	public static void tick() {
		tweenManager.update(Gdx.graphics.getDeltaTime());
	}
}
