package model.entity.enemy;

import java.util.concurrent.ThreadLocalRandom;

public class FlyEnemy extends Enemy {

	public static final int MIN_SPEED_X = 6;
	public static final int MAX_SPEED_X = 12;
	public static final int SPEED_Y = 0;
	
	
	public FlyEnemy(double posX, double posY, double boundX, double boundY) {
		super(posX, posY, boundX, boundY);
		setGravityActive(false);
		setVel(-ThreadLocalRandom.current().nextInt(MIN_SPEED_X, MAX_SPEED_X), SPEED_Y);
		calcScore();
	}

	@Override
	public void update() {
		setPos(getPos().add(getVel()));
	}
}