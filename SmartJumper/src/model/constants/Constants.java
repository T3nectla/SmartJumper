package model.constants;

public final class Constants {
	
	private Constants() {}
	
	public static final double FPS = 1000d/60d;
	public static final double MAX_JUMP_DISTANCE = 200;
	public static final double GRAVITY = 2;
	public static final double JUMP = -(GRAVITY+2);
	
	public static final int GROUNDENEMY_MIN_SPEED = 1;
	public static final int GROUNDENEMY_MAX_SPEED = 10;
	public static final int FLYENEMY_MIN_SPEED = 6;
	public static final int FLYENEMY_MAX_SPEED = 13;
}