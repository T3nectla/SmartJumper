package model.entity.enemy;

import java.util.concurrent.ThreadLocalRandom;

public class GroundEnemy extends Enemy {
	
	public static final int MIN_SPEED_X = 2;
	public static final int MAX_SPEED_X = 10;
	public static final int SPEED_Y = 0;
	
	
	public GroundEnemy(double posX, double posY, double boundX, double boundY) {
		super(posX, posY, boundX, boundY);
		setVel(-ThreadLocalRandom.current().nextInt(MIN_SPEED_X, MAX_SPEED_X), SPEED_Y);
		calcScore();
	}
	
	@Override
	public void update() {
		if(isOnGround()) {
			setPos(getPos().add(getVel()));
		}
	}
}