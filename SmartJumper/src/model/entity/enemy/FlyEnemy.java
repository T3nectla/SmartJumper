package model.entity.enemy;

import java.util.concurrent.ThreadLocalRandom;

import model.constants.Constants;

public class FlyEnemy extends Enemy {

	public FlyEnemy(double posX, double posY, double boundX, double boundY) {
		super(posX, posY, boundX, boundY);
		setGravityActive(false);
		setVel(-ThreadLocalRandom.current().nextInt(Constants.FLYENEMY_MIN_SPEED, Constants.FLYENEMY_MAX_SPEED), 0);
		calcScore();
	}

	@Override
	public void update() {
		setPos(getPos().add(getVel()));
	}
}