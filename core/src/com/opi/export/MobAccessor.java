package com.opi.export;

import aurelienribon.tweenengine.TweenAccessor;

public class MobAccessor implements TweenAccessor<Mob> {

	public static final int POSITION_X = 1;
	public static final int POSITION_Y = 2;
	public static final int POSITION_XY = 3;
	
	@Override
	public int getValues(Mob target, int tweenType, float[] val) {
		switch(tweenType) {
		case POSITION_X:
			val[0] = target.getX();
			return 1;
		case POSITION_Y:
			val[0] = target.getY();
			return 1;
		case POSITION_XY:
			val[0] = target.getX();
			val[1] = target.getY();
			return 2;
			default: assert false; return -1;
		}
	}

	@Override
	public void setValues(Mob target, int tweenType, float[] val) {
		switch(tweenType) {
		case POSITION_X:
			target.setX(val[0]);
			break;
		case POSITION_Y:
			target.setY(val[0]);
			break;
		case POSITION_XY:
			target.setPosition(val[0], val[1]);
			break;
		}
	}
}
